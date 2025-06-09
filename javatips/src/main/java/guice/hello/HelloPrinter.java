package guice.hello;

import com.google.inject.Inject;
import com.google.inject.Singleton;

@Singleton
public class HelloPrinter {
    public void print(){
        System.out.println("Helllo World!");
    }
}


