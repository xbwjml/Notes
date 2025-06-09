package guice.module;

import com.google.inject.Singleton;

@Singleton
public class ComplexHelloPrinter implements IHelloPrinter{
    @Override
    public void print() {
        System.out.println("Hello, Complex World");
    }
}
