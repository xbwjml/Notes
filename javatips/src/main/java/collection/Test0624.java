package collection;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

@Data
@AllArgsConstructor
class Book {
    private String author;
    private String name;
}

public class Test0624 {
    public static void main(String[] args) {
        List<Book> list = new ArrayList(){{
            add(new Book("makesi", "资本论"));
            add(new Book("tuoersitai", "战争与和平"));
            add(new Book("wuchengen", "西游记"));
            add(new Book("liening", "革命"));
        }};

        LinkedHashMap<String, String> collect = list.stream().collect(
                LinkedHashMap::new,
                (map, e) -> map.put(e.getAuthor(), e.getName()),
                Map::putAll
        );
        return;
    }
}
