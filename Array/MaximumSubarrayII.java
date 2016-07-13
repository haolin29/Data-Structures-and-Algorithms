package Array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Haolin on 16/6/24.
 */
public class MaximumSubarrayII {
    public static int maxTwoSubarray(ArrayList<Integer> nums) {
        int len = nums.size();
        int[] left = new int[len];
        int[] right = new int[len];

        int miniSum = 0;
        int sum = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < len; i++) {
            sum += nums.get(i);
            max = Math.max(max,sum - miniSum);
            miniSum = Math.min(miniSum,sum);
            left[i] = max;
        }

        miniSum = 0;
        sum = 0;
        max = Integer.MIN_VALUE;
        for (int j = len - 1; j >= 0; j--) {
            sum += nums.get(j);
            max = Math.max(max,sum - miniSum);
            miniSum = Math.min(miniSum,sum);
            right[j] = max;
        }

        max = Integer.MIN_VALUE;
        for (int i = 0; i < len - 1; i++) {
            max = Math.max(max, left[i] + right[i + 1]);
        }

        return max;
    }

    public static void main(String[] args) {
        ArrayList<Integer> nums = new ArrayList<>(Arrays.asList(1,3,-1,2,-1,2));
        int max = maxTwoSubarray(nums);
    }
}
