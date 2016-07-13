package Array;

import java.util.ArrayList;

/**
 * Created by Haolin on 16/6/24.
 */
public class MinimumSubarray {
    public int miniSubarray(ArrayList<Integer> nums) {
        int sum = 0;
        int maxSum = 0;
        int mini = Integer.MAX_VALUE;

        for (int num : nums) {
            sum += num;
            mini = Math.min(mini, sum - maxSum);
            maxSum = Math.max(sum, maxSum);
        }

        return mini;
    }
}
