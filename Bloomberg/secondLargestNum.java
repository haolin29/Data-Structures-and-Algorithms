package Bloomberg;

import java.util.Random;

/**
 * Created by Haolin on 2016/11/30.
 */
public class secondLargestNum {
    public static int getSecond(int[] nums) {
        int largest = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;

        for (int num : nums) {
            if(num > largest) {
                second = largest;
                largest = num;
            } else if(num > second) {
                second = num;
            }
        }

        return second;
    }

    public static void main(String[] args) {
        int[] nums = new int[1000];

        int start = 1;

        for (int i = 0; i < nums.length; i++) {
            nums[i] = start++;
        }

        System.out.println(getSecond(nums));
    }
}
