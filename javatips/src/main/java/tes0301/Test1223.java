package tes0301;


import java.math.BigDecimal;
import java.util.*;

class FFaa {
    static {
        System.out.println("父类 static 代码块");
    }
    {
        System.out.println("父类 构造 代码块");
    }

    public FFaa() {
        System.out.println("父类构造方法");
    }
}

class SSonn extends FFaa {
    static {
        System.out.println("子类 static 代码块");
    }
    {
        System.out.println("子类 构造 代码块");
    }
    public SSonn() {
        System.out.println("子类构造方法");
    }
}

public class Test1223 {
    public static void main(String[] args) {
        int[] arr = {2};
        int amount = 3;
        coinChange(arr, amount);
    }

    public static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, Integer.MAX_VALUE);

        dp[0] = 0;
        for (int i = 0; i < dp.length; i++){
            for (int c : coins) {
                if (i - c < 0) continue;
                dp[i] = Math.min(dp[i], 1 + dp[i - c]);
            }
        }

        return dp[amount] == (amount + 1) ? -1 : dp[amount];
    }
}
