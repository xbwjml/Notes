package sort;

import java.util.concurrent.ThreadLocalRandom;

public class GenerateArrUtil {

    /**
     *
     * @param n 数量
     * @param m 范围
     * @return
     */
    public static int[] getArr(int n, int m){
        ThreadLocalRandom current = ThreadLocalRandom.current();
        int[] arr = new int[n];
        for (int i=0; i<n; i++)
            arr[i] = current.nextInt(m);
        return arr;
    }
}
