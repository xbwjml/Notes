package leetCode;

public class Test2 {
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            S s = new S();
            s.f();
        });

        Thread t2 = new Thread(() -> {
            S s = new S();
            s.f();
        });

        t1.start();
        t2.start();
    }
}

class S {
    synchronized void f () {
        System.out.println(System.nanoTime());
    }
}


