package sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = GenerateArrUtil.getArr(300000,1000);
        long start = System.currentTimeMillis();
        sort(arr);
        long end = System.currentTimeMillis();
        System.out.println("time : " + (end - start));

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                throw new RuntimeException("i = " + i + ", arr[i] = " + arr[i]+ ", arr[i-1] = " + arr[i-1]);
            }
        }
    }

    //private static void sort(int[] arr){
    //    if(null == arr || 0 == arr.length )
    //        return;
    //    int len = arr.length;
    //
    //    for(int i=0; i<len-1; i++){
    //        for(int j=0; j<len-1-i; j++){
    //            if(arr[j] > arr[j+1]){
    //                arr[j] = arr[j] ^ arr[j+1];
    //                arr[j+1] = arr[j] ^ arr[j+1];
    //                arr[j] = arr[j] ^ arr[j+1];
    //            }
    //        }
    //    }
    //}

    private static void sort(int[] arr){
        if (null == arr) return;
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length - 1; j > i; j--) {
                if (arr[j] < arr[j - 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j - 1];
                    arr[j - 1] = temp;
                }
            }
        }
    }
}
