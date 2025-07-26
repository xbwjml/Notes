package sort;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = GenerateArrUtil.getArr(30000900,1000);
        long start = System.currentTimeMillis();
        sort(arr);
        long end = System.currentTimeMillis();
        System.out.println("time : " + (end - start));

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                throw new RuntimeException("i = " + i + ", arr[i] = " + arr[i]+ ", arr[i-1] = " + arr[i-1]);
            }
        }

        //for (int i = 0; i < arr.length; i++) {
        //    System.out.println(arr[i]);
        //}
        return;
    }

    private static void sort(int[] arr){
        if (null == arr) return;

        for (int d = arr.length / 2; d > 0; d /= 2) {
            for (int i = d; i<arr.length; i++) {
                int pivot = arr[i];
                int j = i - d;
                while (j > -1 && pivot < arr[j]) {
                    arr[j + d] = arr[j];
                    j-=d;
                }
                arr[j + d] = pivot;
            }

        }

    }
}
