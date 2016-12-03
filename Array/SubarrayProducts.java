package Array;

import java.util.List;

/**
 * Created by Haolin on 2016/10/12.
 */
public class SubarrayProducts {
    public static long subarrayProducts(int[] nums, int k) {
        if(nums == null || nums.length == 0) {
            return 0;
        }

        return helper(nums, k, 1, 0, 0);
    }

    public static long helper(int[] nums, int k, int product, int pos, int count) {
        if (product > k) {
            return 0;
        }

        if(pos == nums.length) {
            if (product < k) {
                return count + 1;
            }

            return 0;
        }

        for (int i = pos; i < nums.length; i++) {
            if (product * nums[i] < k) {
                count += helper(nums, k, product * nums[i], i + 1, count);
            } else {
                continue;
            }
        }

        return count;
    }

    public static void main(String[] args) {
        int[] nums = {1,2,3};
        int k = 4;
        long count = subarrayProducts(nums, k);
        System.out.println(count);
    }

}
