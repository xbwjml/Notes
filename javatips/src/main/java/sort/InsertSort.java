package sort;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = GenerateArrUtil.getArr(15,100);
        sort(arr);
        return;
    }

    private static void sort(int[] arr){
        if(null == arr || 0 == arr.length )
            return;
        for(int i=1; i<arr.length; i++ ){
            if(arr[i] < arr[i-1]){
                int temp = arr[i];
                int j = i;
                while(j > 0 && temp < arr[j-1]){
                    arr[j] = arr[j-1];
                    j--;
                }
                arr[j] = temp;
            }
        }
    }

}
