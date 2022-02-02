package sort;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class TopKByPriQ {
    public static void main(String[] args) {
        int[] arr = GenerateArrUtil.getArr(10,1000);
        int k = 10;
        int[] arrCopy = Arrays.copyOf(arr, arr.length);
        int[] tops = getLeastNumbers(arrCopy, k);
        return;
    }

    private static int[] getLeastNumbers(int[] arr, int k){
        if(null == arr || arr.length == 0 || k ==0)
            return new int[0];

        PriorityQueue<Integer> queue = new PriorityQueue<Integer>(k, (x,y) -> y-x );

        for (int i=0; i<k; i++)
            queue.offer(arr[i]);

        for (int i=k; i<arr.length; i++){
            if(arr[i] < queue.peek()){
                queue.poll();
                queue.offer(arr[i]);
            }
        }

        int[] res = new int[k];
        for (int i=0; i<k; i++)
            res[i] = queue.poll();
        return res;
    }
}
