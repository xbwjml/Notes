package tes0301;

import java.util.HashSet;

class FFa {
    static int a = 10;
    static {
        System.out.println("father static block");
        System.out.println(a);
    }
    {
        System.out.println("father block");
    }

    public FFa() {
        System.out.println("father constructor");
    }
}

class SSon extends FFa {
    static int b = 20;
    static {
        System.out.println("son static block");
        System.out.println(b);
    }
    {
        System.out.println("son block");
    }

    public SSon() {
        System.out.println("son constructor");
    }
}

public class Test0721<T> {

    public static void main(String[] args) throws CloneNotSupportedException {
        new SSon();
    }

}
