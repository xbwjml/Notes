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



# 3.channel通道

```
通道(channel):由java.nio.channels包定义的。Channel表示IO源与目标打开的连接。Channel类似于传统的"流"。只不过Channel本身不能直接访问数据,Channel只能与Buffer交互。
```

```java
/**
 * 一. 通道(channel):用于源节点与目标节点的连接。
 *                  在Java NIO中负责缓冲区中数据的传输。
 *                  channel本身不存储任何数据。
 *
 * 二.通道的一些主要实现类；
 *      FileChannel,
 *      SocketChannel,
 *      ServerSocketChannel,
 *      DatagramChannel,
 *
 * 三.获取通道:
 *      1.Java对支持通道的类提供了getChannel()方法;
 *      2.从jdk1.7开始，nio.2对各个通道提供了静态方法open();
 *      3.从jdk1.7开始，nio.2中的File工具类的newByteChannel();
 *
 * 四.通道之间的数据传输:
 *      transferFrom()
 *      transferTo()
 *
 * 五. 分散(Sactter)与聚集(Gather)
 *      分散读取：将通道中的数据分散到多个缓冲区
 *      聚集写入: 将读个缓冲区中的数据都聚集到通道中
 *
 * 六. 字符集 Charset
 *
 */
public class Demo1 {

    //1.利用通道完成文件的复制(非直接缓冲区)
    @Test
    public void test1() throws IOException {
        FileInputStream fileInputStream = new FileInputStream("1.jpg");
        FileOutputStream fileOutputStream = new FileOutputStream("2.jpg");

        //获取通道
        FileChannel inChannel = fileInputStream.getChannel();
        FileChannel outChannel = fileOutputStream.getChannel();

        //分配指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);

        //将通道中的数据存入缓冲区
        while ( inChannel.read(buf) != -1 ){
            buf.flip();//将缓冲区切换成读取模式
            outChannel.write(buf);//将缓冲区中的数据写入通道
            buf.clear();//清空缓冲区
        }

        outChannel.close();
        inChannel.close();
        fileOutputStream.close();
        fileInputStream.close();
    }


    //2.使用直接缓冲区完成文件的复制(内存映射文件)
    @Test
    public void test2() throws IOException{
        FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("3.jpg"),
                StandardOpenOption.WRITE, StandardOpenOption.READ,StandardOpenOption.CREATE_NEW);

        //内存映射文件
        MappedByteBuffer inMappedBuf = inChannel.map(FileChannel.MapMode.READ_ONLY, 0, inChannel.size());
        MappedByteBuffer outMappedBuf = outChannel.map(FileChannel.MapMode.READ_WRITE, 0, inChannel.size());

        //直接对缓冲区进行数据读写
        byte[] dst = new byte[inMappedBuf.limit()];
        inMappedBuf.get(dst);
        outMappedBuf.put(dst);

        inChannel.close();
        outChannel.close();
    }

    //3.通道之间的数据传输(直接缓冲区)
    @Test
    public void test3() throws IOException{
        FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
        FileChannel outChannel = FileChannel.open(Paths.get("3.jpg"),
                StandardOpenOption.WRITE, StandardOpenOption.READ,StandardOpenOption.CREATE_NEW);

        inChannel.transferTo(0,inChannel.size(),outChannel);

        inChannel.close();
        outChannel.close();
    }

}
```



# 4.阻塞与非阻塞

```

```

## 4.1阻塞式

```java
/**
 * 一.使用NIO完成网络通信的三个核心:
 *      1.通道(Channel),负责连接.
 *      2.缓冲区(Buffer),负责数据的存取.
 *      3.选择器(Selector),是SelectableChannel的多路复用器,
 *                         用于监控SelectableChannel的IO状况.
 */
public class Blocking {

    //客户端
    @Test
    public void cilent() throws IOException {
        //1.获取通道
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9999));
        FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
        //2.分配指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        //3.读取本地文件并往服务端发送
        while ( inChannel.read(buf) != -1 ){
            buf.flip();
            sChannel.write(buf);
            buf.clear();
        }
        //4.关闭通道
        inChannel.close();
        sChannel.close();
    }

    //服务端
    @Test
    public void server() throws IOException {
        //1.获取通道
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        FileChannel outChannel = FileChannel.open(Paths.get("2.jpg"),
                                    StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        //2.绑定连接
        ssChannel.bind(new InetSocketAddress(9999));
        //3.获取客户端连接的通道
        SocketChannel acceptChannel = ssChannel.accept();
        //4.分配指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        //5.接收客户端的数据并保存到本地
        while ( acceptChannel.read(buf) != -1 ){
            buf.flip();
            outChannel.write(buf);
            buf.clear();
        }
        //6.关闭通道
        acceptChannel.close();
        outChannel.close();
        ssChannel.close();
    }

}

```

```java
/**
 *
 */
public class Blocking2 {

    //客户端
    @Test
    public void cilent() throws IOException {
        //1.获取通道
        SocketChannel sChannel = SocketChannel.open(new InetSocketAddress("127.0.0.1", 9999));
        FileChannel inChannel = FileChannel.open(Paths.get("1.jpg"), StandardOpenOption.READ);
        //2.分配指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        //3.读取本地文件并往服务端发送
        while ( inChannel.read(buf) != -1 ){
            buf.flip();
            sChannel.write(buf);
            buf.clear();
        }
        sChannel.shutdownOutput();
        //4.接收服务端的反馈
        int len=0;
        while( (len=sChannel.read(buf)) != -1 ){
            buf.flip();
            System.out.println(new String(buf.array(), 0, len));
            buf.clear();
        }
        //5.关闭通道
        inChannel.close();
        sChannel.close();
    }

    //服务端
    @Test
    public void server() throws IOException {
        //1.获取通道
        ServerSocketChannel ssChannel = ServerSocketChannel.open();
        FileChannel outChannel = FileChannel.open(Paths.get("2.jpg"),
                StandardOpenOption.WRITE, StandardOpenOption.CREATE);
        //2.绑定连接
        ssChannel.bind(new InetSocketAddress(9999));
        //3.获取客户端连接的通道
        SocketChannel acceptChannel = ssChannel.accept();
        //4.分配指定大小的缓冲区
        ByteBuffer buf = ByteBuffer.allocate(1024);
        //5.接收客户端的数据并保存到本地
        while ( acceptChannel.read(buf) != -1 ){
            buf.flip();
            outChannel.write(buf);
            buf.clear();
        }
        //6.发送反馈给客户端
        buf.put("服务端接收数据成功".getBytes());
        buf.flip();
        acceptChannel.write(buf);
        //7.关闭通道
        acceptChannel.close();
        outChannel.close();
        ssChannel.close();
    }

}

```



## 4.2非阻塞式