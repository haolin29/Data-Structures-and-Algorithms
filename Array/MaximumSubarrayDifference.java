package Array;

/**
 * Created by Haolin on 16/6/24.
 */
public class MaximumSubarrayDifference {
    public int maxDiff(int[] nums) {
        int len = nums.length;
        int[] left = new int[len];
        int[] right = new int[len];

        int miniSum = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            sum += nums[i];
            max = Math.max(max,sum - miniSum);
            miniSum = Math.min(miniSum,sum);
            left[i] = max;
        }

        int maxSum = 0;
        sum = 0;
        int min = Integer.MAX_VALUE;
        for (int j = len - 1; j >= 0; j--) {
            sum += nums[j];
            min = Math.min(min,sum - maxSum);
            maxSum = Math.max(maxSum,sum);
            right[j] = min;
        }

        int maxDiff = Integer.MIN_VALUE;
        for (int i = 0; i < len - 1; i++) {
            maxDiff = Math.max(maxDiff, Math.abs(left[i] + right[i + 1]));
        }

        return maxDiff;
    }
}
