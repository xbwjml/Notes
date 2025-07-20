package test0301;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;

public class Test1223 {
    public static void main(String[] args) {

        int[] arr = new int[]{7,1,5,3,6,4};
        maxProfit(arr);
    }

    public static int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        dp[0][0] = prices[0];

        for (int i = 1; i < prices.length; i++) {
            dp[i][0] = Math.min(prices[i-1], prices[i]);
            dp[i][1] = Math.max(dp[i - 1][1], prices[i] - dp[i][0]);
        }

        return dp[prices.length - 1][1];
    }
}
