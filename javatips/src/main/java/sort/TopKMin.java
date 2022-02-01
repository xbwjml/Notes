package sort;

import java.util.Arrays;

public class TopKMin {

    public static void main(String[] args) {
        int[] arr = new int[]{3,2,1};
        int k = 2;
        int[] arrCopy = Arrays.copyOf(arr, arr.length);
        //int[] tops = getLeastNumbers(arrCopy, k);
        int[] tops = getLeastNumbers2(arrCopy, k);
        return;
    }

    private static int[] getLeastNumbers(int[] arr, int k) {
        if(k == 0)
            return new int[0];
        //先把arr的前k个元素建立一个大顶堆
        int[] temp = new int[k];
        for(int i=0; i<k; i++)
            temp[i] = arr[i];
        for(int i=temp.length/2; i>-1; i--)
            heapify(temp, i, temp.length-1);

        //再遍历arr剩下的元素,若小于temp堆顶元素,则替代堆顶元素,堆化
        for(int i=k; i<arr.length; i++){
            if(arr[i] < temp[0]){
                temp[0] = arr[i];
                heapify(temp, 0, temp.length-1);
            }
        }

        return temp;
    }

    //维护大顶堆
    private static void heapify(int[] arr, int currIdx, int lastIdx){
        int p = arr[currIdx];
        for(int k=2*currIdx+1; k<=lastIdx; k=2*k+1){
            if(k<lastIdx && arr[k+1]>arr[k])
                k++;
            if(arr[k] <= p)
                break;
            arr[currIdx] = arr[k];
            currIdx = k;
        }
        arr[currIdx] = p;
    }

    private static int[] getLeastNumbers2(int[] arr, int k) {
        if(null == arr || arr.length == 0)
            return new int[0];
        sortByQuick(arr, 0, arr.length-1, k-1);
        int[] res = new int[k];
        for(int i=0; i<k; i++)
            res[i] = arr[i];
        return res;
    }

    private static void sortByQuick(int[] arr, int low, int high, int target){
        if(low < high){
            int pivotIdx = part(arr, low, high);
            if(pivotIdx == target)
                return;
            if(pivotIdx < target)
                sortByQuick(arr, pivotIdx+1, high, target);
            else
                sortByQuick(arr, low,pivotIdx-1, target);
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
