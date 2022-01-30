package sort;

import java.io.ObjectInputValidation;
import java.util.Arrays;

public class QuickSort {
    public static void main(String[] args) {
        int[] arr = GenerateArrUtil.getArr(15,1000);
        int[] res = Arrays.copyOf(arr, arr.length);
        //sort(res, 0, arr.length-1);
        quickSort(res, 0, arr.length-1);
        return;
    }
    private static void quickSort2(int[] array, int low, int high) {
        if (low >= high) {
            return;
        }
        int i = low, j = high, index = array[i]; // 取最左边的数作为基准数
        while (i < j) {
            while (i < j && array[j] >= index) { // 向左寻找第一个小于index的数
                j--;
            }
            if (i < j) {
                array[i++] = array[j]; // 将array[j]填入array[i]，并将i向右移动
            }
            while (i < j && array[i] < index) {// 向右寻找第一个大于index的数
                i++;
            }
            if (i < j) {
                array[j--] = array[i]; // 将array[i]填入array[j]，并将j向左移动
            }
        }
        array[i] = index; // 将基准数填入最后的坑
        quickSort2(array, low, i - 1); // 递归调用，分治
        quickSort2(array, i + 1, high); // 递归调用，分治
    }

    private static void quickSort(int[] arr, int low, int high){
        if(low >= high)
            return ;

        int i = low;
        int j = high;
        int povit = arr[low];
        while(i < j){
            while (i<j && arr[j]>=povit) j--;
            arr[i] = arr[j];
            while (i<j && arr[i]<=povit) i++;
            arr[j] = arr[i];
        }
        arr[i] = povit;

        quickSort(arr, low,i-1);
        quickSort(arr, i+1,high);
    }

    private static void sort(int[] arr, int low, int high){
        if(low < high){
            int pivotIdx = part(arr, low, high);
            sort(arr, low, pivotIdx-1);
            sort(arr, pivotIdx+1, high);
        }
    }

    private static int part(int[] arr, int low, int high){
        int pivot = arr[low];
        while(low < high){
            while (low<high && arr[high]>=pivot) high--;
            arr[low] = arr[high];
            while (low<high && arr[low]<=pivot) low++;
            arr[high] = arr[low];
        }
        arr[low] = pivot;
        return low;
    }
}
