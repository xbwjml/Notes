package guice.aop;

import com.google.inject.Singleton;

@Singleton
public class ServiceImpl implements Service{

    @ConsumeTimeLog
    @Override
    public void sayHello(String s, Integer i) throws InterruptedException {
        Thread.sleep(1000);
        System.out.println("Hello");
        Thread.sleep(2000);

    }
}
