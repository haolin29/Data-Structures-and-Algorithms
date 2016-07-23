package DynamicProgramming;

/**
 * Created by Haolin on 16/7/22.
 */
public class HouseRobber {
    public int rob(int[] nums) {
        if (nums == null || nums.length == 0 ) {
            return -1;
        }

        int n = nums.length;

        if (nums.length == 1) {
            return nums[0];
        }

        int[] dp = new int[n];

        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);

        for (int i = 2; i < n; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }

        return dp[n - 1];
    }

    //version 2
    public int rob2(int[] nums) {
        if (nums == null || nums.length == 0 ) {
            return 0;
        }

        int n = nums.length;

        if (nums.length == 1) {
            return nums[0];
        }


        int prev2 = nums[0];
        int prev1 = Math.max(nums[0], nums[1]);

        int cur = prev1;
        for (int i = 2; i < n; i++) {
            cur = Math.max(prev1, prev2 + nums[i]);
            prev2 = prev1;
            prev1 = cur;
        }

        return cur;
    }
}
