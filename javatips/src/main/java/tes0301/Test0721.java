package tes0301;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;


class AAA {
    int id;
    static int sid = 100;

    public AAA(String id) {
        int a = 1;
    }
}

public class Test0721 {

    public static void main(String[] args) throws CloneNotSupportedException {
        AAA aaa = new AAA();
        aaa.id = AAA.sid;
        AAA.sid++;

        //System.setOut();
        return;

    }

    

}
