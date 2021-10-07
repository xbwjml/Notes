package threadLocalTest;

import java.util.ArrayList;
import java.util.List;

public class TTT {
    public static void main(String[] args) {

        List<Integer> list = new ArrayList();
        list.add(11);
        list.add(22);
        list.add(33);
        list.add(44);
        list.add(55);

        boolean b = list.removeIf(e -> {
            return e % 100 == 0;
        });

        return;
    }
}


