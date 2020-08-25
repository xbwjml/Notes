# 1.引入

```
设计系统时要达到的目标：
1.要做到系统解耦，当新的模块接进来时，可以做到代码改动最小;能够解耦。
2.设置流量缓冲池，可以让后端系统按照自身吞吐能力进行消费，不被冲垮;能够削峰。
3.强弱依赖梳理能将非关键调用链路的操作异步化并提升整体系统的吞吐能力;能够异步。
```



# 2.MQ的作用定义

```
面向消息的中间件(message-oriented-middleware)MOM 能很好地解决以上问题.
是指利用高效可靠的消息传递机制进行与平台无关的数据交流，并基于数据通信来进行分布式系统的集成。
通过提供消息传递和消息排队模型在分布式环境下提供解耦,弹性伸缩，冗余存储，流量削峰，异步通信，数据同步等功能。

大致的过程是这样的：
发送者把消息发送给消息服务器，消息服务器将消息存放在 队列/主题 中，在合适的时候，消息服务器会将消息转发给接受者。在这个过程中，发送和接受是异步的，也就是发送无需等待，而且发送者和接受者的生命周期没有必然关系；
尤其在发布订阅模式下，也可以完成一对多的通信，即让一个消息有多个接受者。
```



# 3.ActiveMQ下载安装

```
在 active 的bin目录下： ./activemq start
端口号默认是61616

61616端口提供JMS服务;
8161是访问控制台的端口;
```



# 4.Java编码

```

```

```java
public class Producer {
    public static void main(String[] args) throws JMSException {
        String url = "tcp://127.0.0.1:61616";
        String queueName = "queue01";
        //1.创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(url);
        //2.通过连接工厂，获得连接对象
        Connection connection = activeMQConnectionFactory.createConnection();
        //3.开启连接
        connection.start();

        //4.创建session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5.创建目的地(具体是队列还是主题)
        Queue queue = session.createQueue(queueName);

        //6.创建消息的生产者
        MessageProducer producer = session.createProducer(queue);
        //7.生产3条消息发送到MQ的队列里面
        for( int i=0; i<3; i++ ){
            //创建消息
            TextMessage textMessage = session.createTextMessage("msg---" + (i + 1));
            //通过producer发送给MQ
            producer.send(textMessage);
        }

        //8.关闭资源
        producer.close();
        session.close();
        connection.close();
        System.out.println("欧了====");
    }
}
```

```java
public class Consumer {
    public static void main(String[] args) throws JMSException {
        String url = "tcp://127.0.0.1:61616";
        String queueName = "queue01";
        //1.创建连接工厂
        ActiveMQConnectionFactory activeMQConnectionFactory = new ActiveMQConnectionFactory(url);
        //2.通过连接工厂，获得连接对象
        Connection connection = activeMQConnectionFactory.createConnection();
        //3.开启连接
        connection.start();
        //4.创建session
        Session session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
        //5.创建目的地(具体是队列还是主题)
        Queue queue = session.createQueue(queueName);

        //6.创建消费者
        MessageConsumer messageConsumer = session.createConsumer(queue);
        while (true){
            TextMessage textMessage = (TextMessage) messageConsumer.receive();
            if( null!=textMessage ){
                System.out.println("***消费者接收到消息***"+textMessage.getText());
            }else{
                break;
            }
        }

        messageConsumer.close();
        session.close();
        connection.close();
    }
}
```

```
两种消费方式:

1.同步阻塞方式(receive):
订阅者或接收者调用MessageConsumer得receive()方法来接收消息，receive方法在能够接收消息之前(或超时之前)将一直阻塞。

2.异步非阻塞方式(监听器onMessage()):
订阅者或接收者通过MessageConsumer的setMessageListener(MessageListener messageListener) 注册一个消息监听器，当消息到达后，系统自动调用监听器MessageListener的onMessage(Message message)方法.

```

```
Topic模式:


```

```
topic和queue对比:
```

|            |                            topic                             |                            queue                             |
| :--------: | :----------------------------------------------------------: | :----------------------------------------------------------: |
|  工作模式  | "订阅-发布"模式，如果当前没有订阅者，消息将会被丢弃。如果有多个订阅者，那么这些订阅者都会收到消息。 | "负载均衡"模式，如果当前没有消费者，消息也不会丢弃;如果有多个消费者，那么一条消息也只会发送给其中一个消费者，并且要求消费者ack信息。 |
|  有无状态  |                            无状态                            |         Queue数据默认会在mq服务器上以文件形式保存。          |
| 传递完整性 |                 如果没有订阅者，消息会被丢弃                 |                         消息不会丢弃                         |
|  处理效率  | 由于消息要按照订阅者的数量进行复制，所以处理性能会随着订阅者的增加而明显降低，并且还要结合不同消息协议自身的性能差异。 | 由于一条消息只发送给一个消费者，所以就算消费者再多，性能也不会有明显降低。当然不同消息协议的具体性能也是有差异的。 |



# 5.JMS

```
JMS: Java 消息服务。

Java消息服务指的是两个应用程序之间进行异步通信的API,它为标准消息协议和消息服务提供了一组通用接口，包括创建，发送，读取消息等。在Java EE中，当两个应用程序使用JMS进行通信时，它们之间并不是直接相连的，而是通过一个共同的消息收发服务组件关联起来以达到解耦/异步削峰的效果。
```

```
JMS 四大组成元素:

1.JMS provider: 实现JMS接口和规范的消息中间件,也就是MQ服务器;
2.JMS producer: 消息的生产者，创建和发送JMS消息的客户端应用;
3.JMS consumer: 消息的消费者，接收和处理JMS消息的客户端应用;
4.JMS message : 消息头+消息属性+消息体;
```

```
message 消息头:


```

```
message 消息体:
5种消息体格式

1.TextMessage:
	普通字符串消息。
2.MapMessage:
	一个map类型的消息，key为String,value为Java基本类型。
3.ByteMessage:
	二进制数组消息，包含一个byte[].
4.StreamMessage:
	Java数据流消息，用标准流操作来顺序地填充和读取。
5.ObjectMessage:
	对象消息，包含一个可序列化的Java对象。
```

```
message 消息属性:


```

