package mockito.day2;

import com.google.common.base.Joiner;
import lombok.AllArgsConstructor;
import lombok.Data;

import java.util.*;
import java.util.stream.Collectors;

@Data
@AllArgsConstructor
class Fruit implements Cloneable{
    private String catalog;
    private String color;
    private Integer weight;

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }
}

public class TT2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        List<Fruit> list = new ArrayList(){{
            add(new Fruit("apple", "red", 1));
            add(new Fruit("apple", "yellow", 2));
            add(new Fruit("apple", "green", 3));

            add(new Fruit("banana", "yellow", 10));
            add(new Fruit("banana", "green", 20));

            add(new Fruit("orange", "orange!!", 100));
        }};


        return;
    }
}
