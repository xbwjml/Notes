package leetCode;

public class SellStock {
    public static void main(String[] args) {
        int[] arr = {7,1,5,3,6,4};
        int res = maxProfit(arr);
        return;
    }

    public static int maxProfit(int[] prices) {
        if(null == prices || prices.length == 0)
            return 0;
        if(prices.length == 1)
            return 0;

        int len = prices.length;
        int minBuy = Integer.MAX_VALUE;
        int max = 0;

        for(int i=0; i<len; i++){
            minBuy = Math.min(minBuy, prices[i]);
            int temp = prices[i]-minBuy;
            max = Math.max(max, temp);
        }


        return max;
    }
}
