package leetCode;

import java.util.Vector;
import java.util.concurrent.atomic.AtomicInteger;

public class TestVec {
    private static Vector<Integer> vector = new Vector<>();

    public static void main(String[] args) {
        AtomicInteger atom = new AtomicInteger(100);
        int andIncrement = atom.incrementAndGet();
        return;
    }
}
