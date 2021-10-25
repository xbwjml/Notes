import java.util.HashMap;
import java.util.function.BiFunction;

public class Test4 {
    public static void main(String[] args) {

        HashMap<String, Integer> prices = new HashMap<>();

        prices.put("Shoes", 200);
        prices.put("Bag", 300);
        prices.put("Pant", 150);

        Integer newVal = prices.merge("Bag", 66, (oldV, newV) -> 99);

        Integer res = prices.getOrDefault("Shoessssss", 111);

        System.out.println(prices);

        return;
    }


}

