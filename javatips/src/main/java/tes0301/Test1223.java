package tes0301;

import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;

class Test0720 {
    public Test0720() {
    }

    public static String sVal = "16416541";


}

interface IA {}
interface IB {}
interface IC extends IA, IB {}

public class Test1223 {
    public static void main(String[] args) {
        //strStr("adcadcaddcadde", "adcadde");
        Integer a = null;
        int b = 10;

        Integer i = true ? a : b;

        return;
    }

    public static int strStr(String haystack, String needle) {
        if (haystack.length() < needle.length()) {
            return -1;
        }

        //next
        int[] next = new int[needle.length()];
        int k = 0;
        int j = 1;
        while (j < needle.length()) {
            if (needle.charAt(j) == needle.charAt(k)) {
                k++;
                next[j] = k;
                j++;
            } else {
                if (k > 0) {
                    k = next[k - 1];
                } else if (k == 0) {
                    next[j] = 0;
                    j++;
                }
            }
            int a = 1;
        }

        //match
        int i = 0;
        int j2 = 0;
        while (i < haystack.length() && j2 < needle.length()) {
            if (haystack.charAt(i) == needle.charAt(j2)) {
                i++;
                j2++;
            } else {
                if (j2 == 0) i++;
                else {
                    j2 = next[j2 - 1];
                }
            }
        }

        if (j2 == needle.length())
            return i - needle.length();

        return -1;
    }
}
