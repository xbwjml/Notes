package sort;

import java.util.Arrays;

public class MergeSort {
    public static void main(String[] args) {
        int[] arr = GenerateArrUtil.getArr(1000,20000);
        sortArray(arr);

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

    public static int[] sortArray(int[] nums) {
        mergeSort(nums, 0, nums.length - 1);
        return nums;
    }

    public static void mergeSort(int[] nums, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(nums, left, mid);
            mergeSort(nums, mid + 1, right);
            merge(nums, left, mid, right);
        }
    }

    public static void merge(int[] nums, int left, int mid, int right) {
        int[] tempArr = new int[nums.length];
        for (int i = left; i <= right; i++)
            tempArr[i] = nums[i];

        int k = left;
        int p1 = left;
        int p2 = mid + 1;
        while (p1 <= mid && p2 <= right) {
            if (tempArr[p1] <= tempArr[p2]) {
                nums[k++] = tempArr[p1++];
            } else {
                nums[k++] = tempArr[p2++];
            }
        }

        while(p1 <= mid) nums[k++] = tempArr[p1++];
        while(p2 <= right) nums[k++] = tempArr[p2++];
    }
}
