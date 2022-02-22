package spring.chapter02;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;

public class MainTest {
    public static void main(String[] args) {
        DefaultListableBeanFactory beanFactory = new DefaultListableBeanFactory();
        beanFactory.registerSingleton("u1", new User() );
        User u = beanFactory.getBean("u1", User.class);

        return;
    }
}
