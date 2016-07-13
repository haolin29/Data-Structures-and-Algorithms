package Array;

import java.util.HashMap;

/**
 * Created by Haolin on 16/6/24.
 */
public class TwoSum {
    public int[] twoSum(int[] numbers, int target) {
        if (numbers == null || numbers.length == 0) {
            return null;
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        int[] result = new int[2];

        for (int i = 0; i < numbers.length; i++) {
            if (map.containsKey(target - numbers[i])) {
                result[0] = map.get(target - numbers[i]) + 1;
                result[1] = i + 1;
                return result;
            }

            map.put(numbers[i],i);
        }

        return result;

    }
}
