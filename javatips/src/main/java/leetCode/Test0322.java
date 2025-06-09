package leetCode;

public class Test0322 {

    public static void main(String[] args) {
        int[] arr = new int[]{4,3,2,1,4};
        int res = total2(arr);
        System.out.println(res);
        return;
    }

    private int totalBrutal(int[] arr){
        int max = 0;
        for(int i=0; i<arr.length-1; i++){
            for(int j=i+1; j<arr.length; j++){
                int height = Math.min(arr[i], arr[j]);
                int width = j - i;
                int s = height * width;
                max = Math.max(max, s);
            }
        }
        return max;
    }

    private static int total2(int[] arr){
        if(null == arr || arr.length < 2)
            return 0;
        int left = 0;
        int right = arr.length - 1;
        int max = (right - left) * Math.min(left, right);

        while(left < right){
            int height = Math.min(arr[left], arr[right]);
            max = Math.max((right - left) * height, max);
            if(arr[left] <= arr[right]){
                left++;
            }else{
                right--;
            }
        }

        return max;
    }
}
