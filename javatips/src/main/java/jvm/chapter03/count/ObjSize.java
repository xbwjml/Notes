package jvm.chapter03.count;

import org.openjdk.jol.info.ClassLayout;
import org.openjdk.jol.info.GraphLayout;

import java.util.HashMap;
import java.util.Map;

public class ObjSize {
    private static Object o;
    public static void main(String[] args) {
        o = new Object();
        System.out.println(ClassLayout.parseInstance(o).toPrintable());
        System.out.println(GraphLayout.parseInstance(o).toPrintable());
        System.out.println("===== 加锁后变化 =====");
        synchronized (o){
            System.out.println(ClassLayout.parseInstance(o).toPrintable());
            System.out.println(GraphLayout.parseInstance(o).toPrintable());
        }

    }
}
