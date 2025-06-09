package serial;

import java.util.*;
public class Psvm {

    static int unit = 16;

    public static void main(String[] args){
        Scanner in = new Scanner(System.in);
        while (in.hasNext()) {
            String number = in.next();
            int res = trans(number.substring(2));
            System.out.println(res);
        }
        return;
    }


    public static int trans(String num){
        int res = 0;
        char[] arr = num.toCharArray();
        for(char c : arr){
            int t = getNum(c);
            res = res * unit + t;
        }
        return res;
    }

    public static int getNum(char c){
        if(c > 47 && c < 58) return c - 48;
        if(c > 10 && c < 72) return c - 65 + 10;
        return 0;
    }
}
