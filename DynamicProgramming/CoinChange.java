package DynamicProgramming;

/**
 * Created by Haolin on 16/6/18.
 */
public class CoinChange {
    public int miniNum(int amount, int[] coins) {
        if (coins == null || coins.length == 0) {
            return -1;
        }

        // state
        int[] dp = new int[amount + 1]; // 换到i 需要最少几个硬币

        final int max = Integer.MAX_VALUE;
        // init
        for (int i = 1; i <= amount; i++) {
            dp[i] = max;
        }

        // transfer function
        for(int i = 1; i <= amount; i++) {
            for (int j = 0; j < coins.length; j++) {

                if (i + coins[j] <= amount && dp[i] != max) {
                    dp[i + coins[j]] = Math.min(dp[i + coins[j]], dp[i] + 1);
                }

            }
        }

        return dp[amount] == max ? -1 : dp[amount];


    }
}
