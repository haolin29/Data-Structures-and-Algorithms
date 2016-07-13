package Array;

import java.util.Arrays;

/**
 * Created by Haolin on 16/6/24.
 */
public class TwoSumClosest {
    public int twoSumClosest(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        Arrays.sort(nums);
        int start = 0;
        int end = nums.length - 1;
        int closest = Integer.MAX_VALUE;

        while (start < end) {
            int sum = nums[start] + nums[end];
            if (sum < target) {
                if (target - sum < closest) {
                    closest = target - sum;
                }
                start++;
            } else {
                if (sum - target < closest) {
                    closest = sum - target;
                }
                end--;
            }
        }

        return closest;

    }
}
