package sort;

import java.io.ObjectInputValidation;
import java.util.Arrays;
import java.util.Random;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = GenerateArrUtil.getArr(1000,2000);
        sort(arr, 0, arr.length - 1);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                throw new RuntimeException("i = " + i + ", arr[i] = " + arr[i]+ ", arr[i-1] = " + arr[i-1]);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            System.out.println(arr[i]);
        }
        return;
    }

    public static void sort(int[] arr, int low, int high) {
        if (low < high) {
            int p = partition(arr, low, high);
            sort(arr, low, p - 1);
            sort(arr, p + 1, high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        //random pick pivot
        int k = new Random().nextInt(high - low + 1) + low;
        int temp = arr[k];
        arr[k] = arr[low];
        arr[low] = temp;

        int pivot = arr[low];
        while (low < high) {
            while (low < high && pivot <= arr[high]) high--;
            arr[low] = arr[high];
            while (low < high && arr[low] <= pivot) low++;
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }

}
