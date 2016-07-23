package DynamicProgramming;

/**
 * Created by Haolin on 16/7/22.
 */
public class HouseRobberII {
    public int rob(int[] nums) {
        if(nums == null || nums.length == 0) return 0;
        if (nums.length == 1) return nums[0];

        return Math.max(helper(nums, 0, nums.length - 1), helper(nums, 1, nums.length));
    }

    public int helper(int[] nums, int start, int end) {

        /* 没考虑到的因素:
        *  start == end
        *  只有三个元素的情况
        *  这题的corner case很多
        */

        if(start >= end) {
            return 0;
        }
        if((end - start) == 1) return nums[start];

        int prev2 = nums[start];
        int prev1 = Math.max(nums[start + 1], nums[start]);

        int cur = prev1;

        for (int i = start + 2; i < end; i++) {
            cur = Math.max(prev2 + nums[i], prev1);
            prev2 = prev1;
            prev1 = cur;
        }

        return cur;
    }
}
