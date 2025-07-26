package tes0301;

import java.util.*;

class FFF {

    public void m1(){}
}

class AAA extends FFF{
    @Override
    public void m1() {
        super.m1();
    }
}

public class Test0721<T> {

    public void push(Collection<? extends T> e) {
        System.out.println(e);
    }

    public static void main(String[] args) throws CloneNotSupportedException {
        Class<Void> voidClass = void.class;
        return;
    }

    

}
