package mockito.day2;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
class Fruitt{
    String name;
    Integer weight;
}

public class Test0218 {
    public static void main(String[] args) {
        List<Fruitt> list = new ArrayList(){{
            add(new Fruitt("apple", 11));
            add(new Fruitt("banana", 22));
        }};

        int a = 1;
        list.forEach(e -> e.setName(e.getName() + "新年"));
        return;
    }
}
