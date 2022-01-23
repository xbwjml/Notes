package collection;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListToArrayTest {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        list.add("hello");
        list.add("goLang");

        Object[] objects = list.toArray();
        String[] strings = list.toArray(new String[0]);

        String[] strArr = {"j", "a", "v", "a"};
        List<String> arrList = Arrays.asList(strArr);
        strArr[0] = "qqqqq";

        return;
    }
}
