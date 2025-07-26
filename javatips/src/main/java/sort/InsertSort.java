package sort;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = GenerateArrUtil.getArr(30,100);
        sort(arr);

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

    public static void sort(int[] arr){
        for (int i = 1; i < arr.length; i++) {
            int pivot = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > pivot) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = pivot;
        }
    }

}
