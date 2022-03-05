package jvm.chapter03.count;

public class RefCountGC {

    public Object ins;
    private static final int size = 1024 * 1024;
    private final byte[] arr = new byte[2 * size];

    public static void main(String[] args) {
        RefCountGC a = new RefCountGC();
        RefCountGC b = new RefCountGC();
        a.ins = b;
        b.ins = a;
        a = null;
        b = null;
        System.gc();
    }
}
