package DynamicProgramming;

/**
 * Created by Haolin on 2016/11/26.
 */
public class BackPackI {
    public static boolean canGetTwoArray(int[] nums) {
        if(nums == null || nums.length == 0 ) {
            return false;
        }

        int sum = 0;
        for(int num : nums) {
            sum += num;
        }
        // 易错点
        if(sum % 2 == 1) {
            return false;
        }

        boolean[][] dp = new boolean[2][sum/2 + 1];
        dp[0][0] = true;

        for(int i = 1; i <= nums.length; i++) {
            for(int j = 0; j <=  sum / 2; j++) {
                if(dp[(i - 1) % 2][j]) {
                    dp[i % 2][j] = true;
                } else if(j >= nums[i - 1]) {
                    dp[i % 2][j] = dp[(i - 1) % 2][j - nums[i - 1]];
                }
            }
        }

        return dp[nums.length % 2][sum / 2];

    }

    public static void main(String[] args) {
        int[] nums = { 5,11, 1, 5};

        System.out.println(canGetTwoArray(nums));
    }
}
