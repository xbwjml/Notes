package guice.aop;

import com.google.inject.*;
import com.google.inject.Module;
import com.google.inject.matcher.Matchers;
import com.google.inject.name.Names;

public class Test {

    @Inject
    private Service service;

    public static void main(String[] args) throws InterruptedException {
        Injector injector = Guice.createInjector(new Module() {
            @Override
            public void configure(Binder binder) {
                binder.bindInterceptor(
                        Matchers.any(),
                        Matchers.annotatedWith(ConsumeTimeLog.class),
                        new ConsumeTimeLogInterceptor()
                );
            }
        });

        injector.getInstance(Test.class).service.sayHello("kk", 666);
    }
}
