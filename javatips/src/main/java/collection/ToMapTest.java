package collection;

import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

class Person {
    String name;
    String province;

    public Person(String name, String province) {
        this.name = name;
        this.province = province;
    }

    public String getName() {
        return name;
    }

    public String getProvince() {
        return province;
    }
}

public class ToMapTest {
    public static void main(String[] args) {
        List<Person> list = new LinkedList();
        list.add(new Person("tom", "SH"));
        list.add(new Person("mike", "ZJ"));
        list.add(new Person("ada", "SC"));
        list.add(new Person("zack", "BJ"));
        list.add(new Person(null, "TJ"));

        Map<String, String> map = list.stream().collect(Collectors.toMap(
                e -> e.getProvince(),
                e -> Optional.ofNullable(e.getName()).orElse("默认"),
                (a,b) -> b
        ));

        return;
    }
}


