package spring.chapter01;

import org.springframework.beans.factory.FactoryBean;

public class MyFcBean implements FactoryBean {
    @Override
    public Object getObject() throws Exception {
        return new Person() ;
    }

    @Override
    public Class<?> getObjectType() {
        return Person.class;
    }

    @Override
    public boolean isSingleton() {
        return false;
    }
}
