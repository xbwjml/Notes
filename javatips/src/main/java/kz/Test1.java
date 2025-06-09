package kz;

import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@AllArgsConstructor
@Data
class Apple{
    private int weight;
    private String color;
}

public class Test1 {
    public static void main(String[] args) {
        List<Apple> list = new ArrayList<>();
        list.add(new Apple(0, "red"));
        list.add(new Apple(1, "yellow"));
        list.add(new Apple(2, "blue"));
        list.add(new Apple(3, "green"));
        list.add(new Apple(4, "white"));
        list.add(new Apple(5, "black"));
        list.add(new Apple(5, "purple"));

        Map<Integer, Apple> map = list.stream().collect(Collectors.toMap(
                e -> e.getWeight(),
                e -> e
        ));

        System.out.println();
        return;
    }
}
