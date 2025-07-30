package Singleton;

public class HungrySington {
    private static HungrySington instance = new HungrySington();

    private HungrySington() {}

    public static HungrySington getInstance() {
        return instance;
    }
}

class HungrySington2 {
    private static HungrySington2 instance;

    static {
        instance = new HungrySington2();
    }

    public static HungrySington2 getInstance() {
        return instance;
    }
}

class StaticInnerSingleton {
    private StaticInnerSingleton() {
        System.out.println("StaticInnerSingleton constructor");
        //故意制造new 对象耗时久的情况
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public static StaticInnerSingleton getInstance() {
        return LazyHolder.INSTANCE;
    }

    private static class LazyHolder {
        private static final StaticInnerSingleton INSTANCE = new StaticInnerSingleton();
    }
}

