package chapter9;

public class Test211 {
    public static void main(String[] args) throws InterruptedException{
        Person p = new Person();
        Thread t1 = new Thread(()->{
            try {
                p.m2();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t1.setName("线程1");

        Thread t2 = new Thread(()->{
            try {
                p.m4();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });
        t2.setName("线程2");

        t1.start();
        t2.start();



    }
}

class Person{

    public String m1() throws InterruptedException{
        int a = 1;
        Thread.sleep(3000);
        return "m1";
    }

    public synchronized String m2() throws InterruptedException{
        int a = 2;
        Thread.sleep(3000);
        return "m2";
    }

    public static String m3() throws InterruptedException{
        int a = 3;
        Thread.sleep(3000);
        return "m3";
    }

    public synchronized static String m4() throws InterruptedException{
        int a = 4;
        Thread.sleep(3000);
        return "m4";
    }
}

