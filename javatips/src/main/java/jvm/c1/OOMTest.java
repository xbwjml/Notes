package jvm.c1;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class OOMTest {
    private void doNotStop() {
        while (true) {}
    }

    public void stackLeakByThread() {
        while (true) {
            Thread t = new Thread(() -> {
               doNotStop();
            });
        }
    }

    public static void main(String[] args) {
    }

}
