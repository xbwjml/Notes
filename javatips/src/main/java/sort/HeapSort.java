package sort;

import java.util.Arrays;

public class HeapSort {
    public static void main(String[] args) {
        int[] arr = GenerateArrUtil.getArr(15,1000);
        int[] res = Arrays.copyOf(arr, arr.length);
        sort(res);
        return;
    }

    private static void sort(int[] arr) {
        //构建大顶堆
        //只需移动分之节点,叶子节点无须移动，所以 i<=len/2;
        int len = arr.length;
        for(int i=len/2; i>-1; i--)
            heapify(arr, i, len-1);

        //依次取出堆顶元素(数组最大值),和最后一个元素交换,继续堆化
        for(int j=len-1; j>0; j--){
            swap(arr, 0, j);
            heapify(arr, 0, j-1);
        }
    }

    /**
     * 堆化
     * @param arr
     * @param currIndex     要移动的元素索引
     * @param lastIndex     堆化范围的内的最大索引
     */
    private static void heapify(int[] arr, int currIndex, int lastIndex){
        int temp = arr[currIndex];
        for(int k=2*currIndex+1; k<=lastIndex; k=2*k+1){
            if(k<lastIndex && arr[k]<arr[k+1])
                k++;
            if(arr[k] <= temp)
                break;
            arr[currIndex] = arr[k];
            currIndex = k;
        }
        arr[currIndex] = temp;
    }

    private static void swap(int[] arr, int idx1, int idx2){
        arr[idx1] = arr[idx1] ^ arr[idx2];
        arr[idx2] = arr[idx1] ^ arr[idx2];
        arr[idx1] = arr[idx1] ^ arr[idx2];
    }
}
