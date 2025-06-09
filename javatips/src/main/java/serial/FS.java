package serial;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

public class FS {
    static class Father{
        public int money = 1;
        public Father(){
            money = 2;
            show();
        }
        public void show(){
            System.out.println("I'am father, I have $"+money);
        }
    }

    static class Son extends Father{
        public int money = 3;
        public Son(){
            money = 4;
            show();
        }
        public void show(){
            System.out.println("I'am son, I have $"+money);
        }
    }

    public static void main(String[] args) {
        Father guy
                = new Son();
        System.out.println("the gay has $"+guy.money);
    }
}
