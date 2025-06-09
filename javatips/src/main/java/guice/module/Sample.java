package guice.module;

import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;
import com.google.inject.name.Named;

public class Sample {
    @Inject
    @Named("jiandandian")
    private IHelloPrinter jprinter;

    @Inject
    @Named("fuzadian")
    private IHelloPrinter fprinter;

    public void hello(){
        jprinter.print();
        fprinter.print();
    }

    public static void main(String[] args) {
        Injector injector = Guice.createInjector(new SampleModule());
        Sample sample = injector.getInstance(Sample.class);
        sample.hello();
    }
}
