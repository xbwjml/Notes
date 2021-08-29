package Singleton;


public class SingletonMode{
    public static void main(String[] args) {
        Singleton7.getInstance();
    }
}

/***
 * 懒汉式加载
 * 当需要这个实例的时候，调用该类的getInstance()方法来获得实例；
 * 通过构造方法私有化来避免外部通过new的方式生成对象;
 * 缺点:
 *  线程不安全
 */
class Singleton1 {

    private static Singleton1 singleton1;

    private Singleton1(){}

    public static Singleton1 getInstance(){
        if( singleton1 == null ){
            singleton1 = new Singleton1();
        }
        return singleton1;
    }

    /**
     * 在多线程情况下，假设两个线程同时调用 getInstance() 方法，
     * 第一个线程判断还没有对象(singleton为null),就会立即调用构造器具生成对象，
     * 而此时第二个线程判断 if( singleton == null )， 如果此时刚好第一个线程还没完成生成对象，
     * 那么第二个线程会判断对象为null,第二个线程也会调用构造器生成对象,那么就出现了两个对象。
     * 这种情况出现的概率虽然小,但是当实例化这个对象所需时间较长，就很有可能发声。
     */
}

/**
 * 懒汉式+同步方法
 * 为了解决懒汉式加载的线程不安全问题，
 * 可以在 getInstance() 方法上加 synchronized关键字把这个方法同步
 * 缺点：效率太低, 同步方法getInstance()在第一次获取对象的时候调用就行了，
 *      之后该对象已经存在，无需再调用 同步方法getInstance()，只需直接返回对象
 *      因为多线程调用同步方法效率很低。
 */
class Singleton2{

    private static Singleton2 singleton2;

    private Singleton2(){}

    public static synchronized Singleton2 getInstance(){
        if( singleton2 == null ){
            singleton2 = new Singleton2();
        }
        return singleton2;
    }

}

/**
 * 懒汉式+同步代码块
 * 由于懒汉式+同步方法效率太低,所以先判断 if( singleton == null )
 * 之后再进入同步代码块生成对象
 * 缺点:
 *      线程不安全。
 *      加入第一个线程刚刚通过了 if( singleton3 == null )，
 *      还未来得及往下执行，第二个线程也通过了这个判断语句，那么就生成了多个实例。
 *
 */
class Singleton3{
    private static Singleton3 singleton3;

    private Singleton3(){}

    public static Singleton3 getInstance(){
        if( singleton3 == null ){
            synchronized (Singleton3.class){
                singleton3 = new Singleton3();
            }
        }
        return singleton3;
    }
}


/**
 * 双重检查
 * 针对 懒汉式+同步代码块的线程不安全问题，在new 实例之前再加一步判断
 */
class Singleton4{

    private static Singleton4 singleton4;

    private Singleton4(){}

    public static Singleton4 getInstance(){
        if( null == singleton4 ){
            synchronized (Singleton4.class){
                if( null == singleton4 ){
                    singleton4 = new Singleton4();
                }
            }
        }
        return singleton4;
    }

}

/**
 * 饿汉式(静态常量)
 * 在类装载的时候完成实例化，避免了线程安全问题
 * 类里的静态常量 singleton5 在加载类的时候就生成。
 *
 * 缺点:
 *  若从未使用过这个实例，则会造成浪费。拖延程序启动时间
 */
class Singleton5{

    private static final Singleton5 singleton5 = new Singleton5();

    private Singleton5(){}

    public static Singleton5 getInstance(){
        return singleton5;
    }

}

/**
 * 饿汉式(静态代码块)
 * 和饿汉式(静态常量)类似，只不过把生成对象放到了静态代码块中，
 * 达到在装载类时就生成对象
 */
class Singleton6{

    private static Singleton6 singleton6;

    private Singleton6(){}

    {
        singleton6 = new Singleton6();
    }

    public static Singleton6 getInstance(){
        return singleton6;
    }

}

/**
 *  静态内部类
 *  和饿汉式类似，都是通过JVM加载类的时候初始化静态成员来保证线程安全
 *  但相比于饿汉式的优点: 调用getInstance()方法时才实例化对象，达到了懒加载。
 */
class Singleton7{

    private Singleton7(){}

    private static class Singleton7Inner{
        private static final Singleton7 singleton7 = new Singleton7();
    }

    public static Singleton7 getInstance(){
        return Singleton7Inner.singleton7;
    }
}

/**
 * 枚举
 * 其他方法都能通过反射破坏单例子，只有枚举不能。
 */
enum Singleton8{

    INSTANCE;

    public Singleton8 getInstance(){
        return INSTANCE;
    }
}