package sort;

public class BubbleSort {
    public static void main(String[] args) {
        int[] arr = GenerateArrUtil.getArr(15,1000);
        sort(arr);
        return;
    }

    private static void sort(int[] arr){
        if(null == arr || 0 == arr.length )
            return;
        int len = arr.length;

        for(int i=0; i<len-1; i++){
            for(int j=0; j<len-1-i; j++){
                if(arr[j] > arr[j+1]){
                    arr[j] = arr[j] ^ arr[j+1];
                    arr[j+1] = arr[j] ^ arr[j+1];
                    arr[j] = arr[j] ^ arr[j+1];
                }
            }
        }
    }
}
