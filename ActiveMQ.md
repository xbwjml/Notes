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

