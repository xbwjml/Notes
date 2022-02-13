package spring.chapter01;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {
    public static void main(String[] args) {
        AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);
        IndexService bean = ac.getBean(IndexService.class);
        UserService u = ac.getBean(UserService.class);

        return;
    }
}
