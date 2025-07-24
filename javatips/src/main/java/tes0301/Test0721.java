package tes0301;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.*;

class AAA implements Cloneable, Comparator {

    @Override
    protected AAA clone() throws CloneNotSupportedException {
        return (AAA) super.clone();
    }


    @Override
    public int compare(Object o1, Object o2) {
        return 0;
    }
}

public class Test0721 {
    int fff;

    public static void main(String[] args) throws CloneNotSupportedException {

        String s = "heloo";
        //List s = new ArrayList();
        System.out.println(s.hashCode());
        System.out.println(s.hashCode());
        System.out.println(s.hashCode());

        AAA clone = new AAA().clone();

        var strings = new ArrayList<String>();

        return;


    }

    

}
