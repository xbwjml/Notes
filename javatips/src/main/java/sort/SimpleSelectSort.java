package sort;

public class SimpleSelectSort {
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

    private static void sort(int[] arr){
        if(null == arr)
            return;
        for (int i = 0; i < arr.length; i++) {
            int minIdx = i;
            for (int j = i + 1; j< arr.length; j++) {
                if (arr[j] < arr[minIdx]) minIdx = j;
            }
            if (minIdx != i) {
                int temp = arr[minIdx];
                arr[minIdx] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
