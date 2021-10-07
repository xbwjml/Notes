package 泛型;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<String> list = new ArrayList();
        adds(list, 66);
        String s = list.get(0);
    }

    static void adds(List<Object > list, Object obj){
        list.add(obj);
    }
}
