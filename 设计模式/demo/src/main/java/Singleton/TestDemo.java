package Singleton;

import java.io.*;
import java.lang.reflect.Constructor;


public class TestDemo {
    public static void main(String[] args) throws Exception {
        System.out.println("starrt");
        for (int i = 0; i < 10; i++) {
            Thread.sleep(1000);
            System.out.println(i);
        }
        StaticInnerSingleton instance = StaticInnerSingleton.getInstance();
        System.out.println(instance);

    }

    public static void m1() {
        StaticInnerSingleton instance = StaticInnerSingleton.getInstance();
        System.out.println(instance);
    }
}
