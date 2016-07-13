package Array;

/**
 * Created by Haolin on 16/6/24.
 */
public class MaxSubarray {
    public int maxSubarray(int[] nums) {
        int max = Integer.MIN_VALUE;
        int miniSum = 0;
        int sum = 0;
        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];
            max = Math.max(max, sum - miniSum);
            miniSum = Math.min(miniSum,sum);
        }

        return max;
    }
}
