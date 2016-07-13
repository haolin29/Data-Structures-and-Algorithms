package Array;

/**
 * Created by Haolin on 16/6/24.
 */
public class MaximumProductSubarray {
    public int maxProduct(int[] nums) {
        int len = nums.length;
        int[] max = new int[len];
        int[] min = new int[len];

        max[0] = min[0] = nums[0];

        int result = nums[0];
        for (int i = 1; i < len; i++) {
            max[i] = min[i] = nums[i];
            if (nums[i] > 0) {
                max[i] = Math.max(max[i], max[i - 1] * max[i]);
                min[i] = Math.min(min[i], min[i - 1] * min[i]);
            } else if (nums[i] < 0) {
                max[i] = Math.max(max[i], min[i - 1] * max[i]);
                min[i] = Math.min(min[i], max[i - 1] * min[i]);
            }

            result = Math.max(max[i], result);

        }

        return result;
    }
}
