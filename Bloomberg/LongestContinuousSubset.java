package Bloomberg;

/**
 * Created by Haolin on 2016/12/2.
 */
public class LongestContinuousSubset {
    public static int[] getSubset(int[] nums, int k) {
        int maxLen = 0;
        int maxStart = 0;
        int maxEnd = 0;

        int sum = 0;
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            while(j < nums.length && sum <= k) {
                sum += nums[j];
                j++;
            }

            if ((j - i) > maxLen) {
                maxLen = Math.max(maxLen, j - i);
                maxStart = i;
                maxEnd = j;
            }

            sum -= nums[i];
        }

        if (maxLen < 1) {
            return new int[0];
        }

        int[] result = new int[maxLen];

        for (int i = maxStart; i < maxEnd; i++) {
            result[i - maxStart] = nums[i];
        }

        return result;


    }

    public static void main(String[] args) {
        int[] nums = {1,2,34,5,6,7,8,9,0,1,2,3,4};
        int k = 11;

        for (int num : getSubset(nums, k)) {
            System.out.println(num);
        }
    }
}
