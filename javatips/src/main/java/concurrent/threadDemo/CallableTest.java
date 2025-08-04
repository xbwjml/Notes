package concurrent.threadDemo;


import java.util.concurrent.*;

class Mycall1 implements Callable<String> {
    @Override
    public String call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 10; i++) sum += i;
        return String.valueOf(sum);
    }
}

class Mycall2 implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {
        int sum = 0;
        for (int i = 0; i < 10; i++) sum += i;
        return sum;
    }
}

public class CallableTest {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        Callable<String> c1 = new Mycall1();
        FutureTask<String> f1 = new FutureTask<>(c1);
        Thread t1 = new Thread(f1);
        t1.start();

        String res = f1.get();
        System.out.println(res);
    }
}
