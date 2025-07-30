package Singleton;

public class LazySingleton {
    private static LazySingleton instance;
    private LazySingleton() {
        //故意制造new 对象耗时久的情况
        //try {
        //    Thread.sleep(100);
        //} catch (InterruptedException e) {
        //    throw new RuntimeException(e);
        //}
    }

    public static LazySingleton getInstance() {
        if (null == instance) {
            //当第一个线程进入到这里,正在new对象, 还没new完,仍旧是null, 此时其他线程也会进来
            instance = new LazySingleton();
        }
        return instance;
    }
}


class LazySynSingleton {
    private static LazySynSingleton instance;
    private LazySynSingleton() {}

    // 线程安全,但是低效. 当对象已经new完之后, 就没必要上锁了.
    public static synchronized LazySynSingleton getInstance() {
        if (null == instance) {
            instance = new LazySynSingleton();
        }
        return instance;
    }
}


class LazySynSingleton2 {
    private static LazySynSingleton2 instance;
    private LazySynSingleton2() {}

    public static LazySynSingleton2 getInstance() {
        //和 synchronized加在方法上几乎一样
        synchronized (LazySynSingleton2.class) {
            if (null == instance) {
                instance = new LazySynSingleton2();
            }
            return instance;
        }
    }
}

//双重检查锁
class LazySynDoubleCheckSingleton {
    private volatile static LazySynDoubleCheckSingleton instance;
    private LazySynDoubleCheckSingleton() {
        //故意制造new 对象耗时久的情况
        //try {
        //    Thread.sleep(100);
        //} catch (InterruptedException e) {
        //    throw new RuntimeException(e);
        //}
    }

    public static LazySynDoubleCheckSingleton getInstance() {
        if (null == instance) {
            //若此时对象还没创建完毕,可能会有多个线程进入这里
            synchronized (LazySynDoubleCheckSingleton.class) {
                //进入同步代码块之后,先看看对象是不是已经被别的线程创建了
                if (null == instance) {
                    instance = new LazySynDoubleCheckSingleton();
                }
            }
        }
        return instance;
    }
}
