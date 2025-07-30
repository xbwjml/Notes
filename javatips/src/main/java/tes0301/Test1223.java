package tes0301;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

class Test0720 {
    public Test0720() {
    }

    public static String sVal = "16416541";


}

interface IA {}
interface IB {}
interface IC extends IA, IB {}

public class Test1223 {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(555);
        list.add(666);
        list.add(777);
        list.add(888);
        list.add(999);

        IntSummaryStatistics sta = list.stream().collect(
                Collectors.summarizingInt(i -> i));
        sta.getAverage();
        sta.getMax();

        Map<Integer, Optional<Integer>> collect = list.stream().collect(Collectors.groupingBy(
                i -> i, Collectors.maxBy(Integer::compareTo)
        ));
        return;
    }

    public static void m1(int...args) {
        System.out.println(args);
    }
}
