package Array;

/**
 * Created by Haolin on 16/6/24.
 */
public class BestTimeToBuyAndSellStock {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }
        int mini = prices[0];
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < prices.length; i++) {
            mini = Math.min(mini,prices[i]);
            max = Math.max(max, prices[i] - mini);
        }

        return max;
    }

    public int maxProfitII(int[] prices) {
        if (prices == null || prices.length == 0) {
            return 0;
        }

        int max = 0;
        int last = prices[0];

        for (int i = 1; i < prices.length; i++) {
            if (prices[i] > last) {
                max += prices[i] - last;
            }

            last = prices[i];
        }

        return max;

    }

    public int maxProfitIII(int[] prices) {
        if (prices == null || prices.length < 2) {
            return 0;
        }

        int len = prices.length;

        int[] left = new int[len];
        int[] right = new int[len];

        int mini = prices[0];
        int max = Integer.MIN_VALUE;

        for (int i = 1; i < len; i++) {
            max = Math.max(max, prices[i] - mini);
            mini = Math.min(mini, prices[i]);
            left[i] = max;
        }

        int last = prices[len - 1];
        max = Integer.MIN_VALUE;
        for (int i = len - 2; i >= 0; i--) {
            max = Math.max(last - prices[i], max);
            last = Math.max(last, prices[i]);
            right[i] = max;
        }

        int result = 0;
        for (int i = 1; i < len; i++) {
            result = Math.max(result, left[i] + right[i]);
        }
        return result;
    }
}
