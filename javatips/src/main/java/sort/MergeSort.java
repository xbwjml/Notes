package sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = GenerateArrUtil.getArr(15,1000);
        int[] res = Arrays.copyOf(arr, arr.length);
        res = new  int[]{18 ,14, 15, 17, 11, 13, 16, 12, 23};
        sort(res);
        return;
    }

    private static void sort(int[] arr){
        int[] temp = new int[arr.length];
        part(arr, 0, arr.length-1, temp);
    }

    private static void part(int[] arr, int left, int right, int[] temp) {
        if(left < right){
            int mid = (left+right)/2;
            //继续分左半边
            part(arr, left, mid, temp);
            //继续分右半边
            part(arr, mid+1, right, temp);
            //合并
            merge(arr, left, mid, right, temp);
        }
    }

    private static void merge(int[] arr, int left, int mid, int right, int[] temp){
        int i = left;
        int j = mid+1;
        int k = 0;

        while(i<=mid && j<=right){
            if(arr[i] < arr[j])
                temp[k++] = arr[i++];
            else
                temp[k++] = arr[j++];
        }

        while ( i<=mid ) temp[k++] = arr[i++];
        while ( j<=right ) temp[k++] = arr[j++];

        k=0;
        while (left <= right)
            arr[left++] = temp[k++];
    }
}
