package guice.aop;

import com.google.inject.ImplementedBy;

@ImplementedBy(ServiceImpl.class)
public interface Service {
    public void sayHello(String s, Integer i) throws InterruptedException;
}
