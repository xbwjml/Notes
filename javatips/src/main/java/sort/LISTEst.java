package sort;

import java.util.Arrays;

public class LISTEst {
    public static void main(String[] args) {
        int[] nums = {1,3,5,4,7};
        findNumberOfLIS(nums);
        Arrays.sort();
        return;
    }

    private static int findNumberOfLIS(int[] nums) {
        if(null == nums) return 0;
        int len = nums.length;
        if(len < 2) return len;

        int[] dp = new int[len];
        dp[0] = 1;
        int maxLen = 1;
        for(int i=1; i<len; i++){
            dp[i] = 1;
            for(int j=0; j<i; j++){
                if(nums[i] > nums[j])
                    dp[i] = Math.max(dp[i], dp[j]+1);
            }
            maxLen = Math.max(maxLen, dp[i]);
        }

        int[] bucket = new int[len+1];
        for(int i=0; i<len; i++)
            bucket[dp[i]]++;

        return bucket[maxLen];
    }
}
