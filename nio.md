# 1.Java NIO简介

```
Java NIO 是从 Java1.4开始引入的一个新的 IO API，可以替代标准的 JAVA IO API。NIO 与原来的IO有同样的作用和目的，但是使用的方式完全不同，NIO支持面向缓冲区的，基于通道的IO操作。NIO将以更高效的方式进行文件读写操作.
```

|   IO   |    NIO     |
| :----: | :--------: |
| 面向流 | 面向缓冲区 |
| 阻塞IO |  非阻塞IO  |
|        |   选择器   |

```
Java NIO 核心在于: 通道(channel)和缓冲区(buffer).通道表示打开到IO设备(例如文件,套接字)的连接.若需要使用NIO系统,需要获取用于IO设备的通道以及用于容纳数据的缓冲区.然后操作缓冲区,对数据进行处理.
简而言之,Channel负责传输,Buffer负责存储.
```



# 2.buffer缓冲区

```
缓冲区(buffer):一个用于特定基本数据类型的容器. 由java.nio包定义的,所有缓冲区都是Buffer抽象类的子类.
Java NIO 中的buffer主要用于与NIO通道进行交互,数据是从通道读入缓冲区,从缓冲区写入通道中的.
```

```java
/**
 * 一.缓冲区(Buffer):在 Java NIO 中负责数据的存取。
 * 缓冲区就是数组，用于存取不同类型的数据。
 *
 * 根据数据类型不同，提供了相应类型的缓冲区:
 * ByteBuffer,
 * CharBuffer,
 * DoubleBuffer,
 * FloatBuffer,
 * IntBuffer,
 * LongBuffer,
 * ShortBuffer
 *
 * 上述缓冲区的管理方式几乎一致，通过allocate()获取缓冲区
 *
 * 二:缓冲区存取数据的两个核心方法：
 * put(): 存入数据到缓冲区
 * get(): 获取缓冲区中的数据
 *
 * 三：Buffer中的4个核心属性:
 * capacity: 缓冲区中最大存储数据的容量。一旦声明就不能改变
 * limit:    缓冲区中可以操作数据的大小,limit后数据不能读写
 * position: 缓冲区中正在操作数据的位置
 * mark:     表示记录当前position的位置。可以通过reset()恢复到mark的位置
 *
 * 0 <= mark <= position <= limit <= capacity
 *
 * 四:直接缓冲区与非直接缓冲区:
 * 非直接缓冲区: 通过 allocate() 方法分配缓冲区,
 *              将缓冲区建立在JVM的内存中。
 * 直接缓冲区：通过allocateDirect()方法分配直接缓冲区,
 *            将缓冲区建立在物理内存中。
 */
public class Demo1 {

    private void fun(ByteBuffer buf){
        System.out.println(buf.position());
        System.out.println(buf.limit());
        System.out.println(buf.capacity());
        System.out.println("=======================");
    }

    @Test
    public void test1(){
        //1.分配一个指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        fun(buf);

        //2.用put()往缓冲区中存数据
        String str = "Hello";
        buf.put(str.getBytes());
        fun(buf);

        //3.切换到读取数据模式
        buf.flip();
        fun(buf);

        //4.用get()读取缓冲区中的数据
        byte[] dst = new byte[buf.limit()];
        buf.get(dst);
        System.out.println(new String(dst,0,dst.length));
        fun(buf);

        //5.rewind(): 可重复读
        buf.rewind();
        fun(buf);

        //6.clear清空缓冲区,但是缓冲区中的数据依然存在，但是处于"被遗忘状态"
        buf.clear();
        fun(buf);
    }

    @Test
    public void test2(){
        ByteBuffer buf = ByteBuffer.allocate(1024);
        String str = "abcde";
        buf.put(str.getBytes());
        buf.flip();
        byte[] dst = new byte[buf.limit()];
        buf.get(dst,0,2);
        System.out.println(new String(dst,0,2));
        System.out.println("position: "+buf.position());

        //mark() 标记现在position位置
        buf.mark();
        buf.get(dst,2,2);
        System.out.println(new String(dst,2,2));
        System.out.println("position: "+buf.position());

        //reset() 将position恢复到mark的位置s=
        buf.reset();
        System.out.println("position: "+buf.position());
    }

    @Test
    public void test3(){
        //分配直接缓冲区
        ByteBuffer byteBuffer = ByteBuffer.allocateDirect(1024);
    }
}

```

