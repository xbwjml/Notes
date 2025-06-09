package guice.module;

import com.google.inject.AbstractModule;
import com.google.inject.name.Names;

public class SampleModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(IHelloPrinter.class).annotatedWith(Names.named("jiandandian")).to(SimpleHelloPrinter.class);
        bind(IHelloPrinter.class).annotatedWith(Names.named("fuzadian")).to(ComplexHelloPrinter.class);
    }
}
