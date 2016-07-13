package Array;

import java.util.HashMap;

/**
 * Created by Haolin on 16/6/25.
 */
public class SortColors {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length == 0) {
            return;
        }

        // counting sort
//        HashMap<Integer, Integer> map = new HashMap<>();
//
//        for (int num : nums) {
//            if (!map.containsKey(num)) {
//                map.put(num, 0);
//            }
//
//            map.put(num, map.get(num) + 1);
//        }
//
//        int index = 0;
//        for (int i = 0; i <= 2; i++) {
//            int count = map.get(i);
//            int j = 0;
//            while (index++ < nums.length && j++ < count) {
//                nums[index] = i;
//            }
//        }

        int start = 0;
        int end = nums.length - 1;
        int color = 0;
        while (true) {
            while (start < end && nums[start] == color) {
                start++;
            }

            while (start < end && nums[end] != color) {
                end--;
            }

            if (start == end ) {
                if (color < 3) {
                    color++;
                    end = nums.length - 1;
                } else {
                    break;
                }
            }

            // swap color
            int temp = nums[start];
            nums[start] = nums[end];
            nums[end] = temp;
        }
    }
}
