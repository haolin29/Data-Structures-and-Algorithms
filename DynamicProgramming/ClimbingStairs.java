package DynamicProgramming;

/**
 * Created by Haolin on 16/6/9.
 */
public class ClimbingStairs {
    public int climbing(int n) {
        if (n == 0) {
            return 0;
        }

        int[] dp = new int[n + 1]; // 前i个位置跳到i的方法个数

        dp[0] = 1;
        dp[1] = 1;

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }

        return dp[n];

    }
}
