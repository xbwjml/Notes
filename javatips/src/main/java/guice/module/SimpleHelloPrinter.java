package guice.module;

import com.google.inject.Singleton;

@Singleton
public class SimpleHelloPrinter implements IHelloPrinter{
    @Override
    public void print() {
        System.out.println("Hello, Simple World");
    }
}
