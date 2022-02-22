package spring.chapter01;

import org.springframework.beans.factory.support.AbstractBeanDefinition;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class MainTest {
    public static void main(String[] args) {

        ClassPathXmlApplicationContext ac = new ClassPathXmlApplicationContext("spring.xml");

        UserService uu = ac.getBean("uu", UserService.class);
        UserService uu1 = ac.getBean("uu", UserService.class);
        UserService uu2 = ac.getBean("uu2", UserService.class);
        UserService uu22 = ac.getBean("uu2", UserService.class);


        return;
    }
}
