package 枚举;

import java.util.EnumMap;

public class FruitTest {
    public static void main(String[] args) {
        EnumMap map = new EnumMap(Fruit.class);
        map.put(Fruit.PEACH, "桃子");
        return;
    }
}
