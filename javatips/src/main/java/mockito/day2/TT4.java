package mockito.day2;

import lombok.Data;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Data
class Card{
    String no;
    String color;
}
public class TT4 {
    public static void main(String[] args) {
        IntStream intStream = IntStream.range(0, 10-1);
        intStream.forEach(e->{
            System.out.println(e);
        });
        return;
    }
}
