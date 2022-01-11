package chapter3;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

class Person{
    String name;
    String age;
    public Person(String name, String age) {
        this.name = name;
        this.age = age;
    }
}

public class Test2 {
    public static void main(String[] args) {
        /**
         * [1,2,3,0,0,0]
         * 3
         * [2,5,6]
         * 3
         */
        int[] a = {1,2,3,0,0,0};
        int m = 3;
        int[] b = {2,5,6};
        int n = 3;
        merge(a,m,b,n);
        return;
    }

    private static void merge(int[] A, int m, int[] B, int n) {
        int pa = m-1;
        int pb = n-1;

        int curr = A.length - 1 ;
        while( curr > -1 ){
            if( pa==-1 ){
                A[curr] = B[pb];
                pb--;
                curr--;
                continue;
            }
            if( pb==-1 ){
                A[curr] = A[pa];
                pa--;
                curr--;
                continue;
            }

            if( A[pa] > B[pb] ){
                A[curr] = A[pa];
                pa--;
            }else{
                A[curr] = B[pb];
                pb--;
            }
            curr--;
        }
    }
}
