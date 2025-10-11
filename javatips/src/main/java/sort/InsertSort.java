package sort;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr = GenerateArrUtil.getArr(3000,10000);
        sort(arr);

        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                throw new RuntimeException("i = " + i + ", arr[i] = " + arr[i]+ ", arr[i-1] = " + arr[i-1]);
            }
        }

        for (int i = 0; i < arr.length; i++) {
            //System.out.println(arr[i]);
        }
        return;
    }

    public static void sort(int[] arr){
        for (int i = 0; i < arr.length; i++) {
            for (int j = i; j > 0; j--) {
                if (arr[j] < arr[j-1]) {
                    int t = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = t;
                } else {
                    break;
                }
            }
        }
    }

}
