package sort;

public class SimpleSelectSort {
    public static void main(String[] args) {
        int[] arr = GenerateArrUtil.getArr(15,1000);
        sort(arr);
        return;
    }

    private static void sort(int[] arr){
        if(null == arr || 0 == arr.length )
            return;
        int len = arr.length;

        for (int i=0; i<len-1; i++){
            int minIdx = i;
            for(int j=i+1; j<len; j++){
                if(arr[j] < arr[minIdx])
                    minIdx = j;
            }
            if(minIdx != i){
                arr[i] = arr[i] ^ arr[minIdx];
                arr[minIdx] = arr[i] ^ arr[minIdx];
                arr[i] = arr[i] ^ arr[minIdx];
            }
        }
    }
}
