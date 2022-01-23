package collection;

import java.util.ArrayList;
import java.util.List;

public class ArrayListSubTest {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("w");
        list.add("o");
        list.add("r");
        list.add("l");
        list.add("d");
        List sub = list.subList(1, 3);
        sub.add("kkkk");
        sub.remove("w");

        return;
    }
}
