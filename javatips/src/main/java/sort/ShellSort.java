package sort;

public class ShellSort {
    public static void main(String[] args) {
        int[] arr = GenerateArrUtil.getArr(15,1000);
        sort(arr);
        return;
    }

    private static void sort(int[] arr){
        if(null == arr || 0 == arr.length )
            return;
        int len = arr.length;
        int d = len;

        while(d > 1){
            d /= 2;
            for (int i=d; i<len; i+=d){
                if(arr[i] < arr[i-d]){
                   int temp = arr[i];
                   int j = i;
                   while( j>0 && temp<arr[j-1] ){
                       arr[j] = arr[j-1];
                       j--;
                   }
                   arr[j] = temp;
                }
            }
        }
    }
}
