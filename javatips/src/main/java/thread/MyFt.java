package thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;
import java.util.concurrent.TimeUnit;

public class MyFt implements Callable<String> {
    @Override
    public String call() throws Exception {
        System.out.println("ft线程工作");
        Thread.sleep(3000);
        return "ft线程返回值";
    }

    public static void main(String[] args) throws Exception{
        FutureTask<String> futureTask = new FutureTask<>(new MyFt());
        new Thread(futureTask).start();

        String s = futureTask.get(30000, TimeUnit.MILLISECONDS);
        System.out.println(s);
    }
}
