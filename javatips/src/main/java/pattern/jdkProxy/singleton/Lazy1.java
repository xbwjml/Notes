package pattern.jdkProxy.singleton;

public class Lazy1 {
    private static Lazy1 obj;

    private Lazy1(){}

    public static Lazy1 getIns(){
        if(null == obj) {
            synchronized(Lazy1.class){
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                obj = new Lazy1();
            }
        }
        return obj;
    }

    public static void main(String[] args) {
        Runnable runnable = ()->{
            Lazy1 obj = Lazy1.getIns();
            System.out.println(obj);
        };

        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);

        t1.start();
        t2.start();
    }
}

