package chapter6;

import java.util.concurrent.atomic.AtomicIntegerArray;

public class AtomicIntArrTest {
    static int[] val = new int[]{1,2};

    static AtomicIntegerArray aotmArr = new AtomicIntegerArray(val);

    public static void main(String[] args) {
        aotmArr.getAndSet(0, 3);
        System.out.println(aotmArr.get(0));
        System.out.println(val[0]);
    }
}
