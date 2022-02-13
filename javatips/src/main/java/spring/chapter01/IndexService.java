package spring.chapter01;

import org.springframework.stereotype.Component;

@Component
public class IndexService {
    public IndexService() {
        System.out.println("IndexService无参构造");
    }
}
