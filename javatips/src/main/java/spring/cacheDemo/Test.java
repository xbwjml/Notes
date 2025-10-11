package spring.cacheDemo;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import spring.chapter01.AppConfig;
import utils.LogUtils;

public class Test {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("spring.xml");
        BeanA a = context.getBean(BeanA.class);
        LogUtils.log(a);
    }
}
