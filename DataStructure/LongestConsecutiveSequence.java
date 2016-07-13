package DataStructure;

import java.util.HashMap;

/**
 * Created by Haolin on 16/6/30.
 */
public class LongestConsecutiveSequence {
    public int longestSequence(int[] num) {
        if (num == null || num.length == 0) {
            return 0;
        }

        // 用hashset 更好, 直接remove

        HashMap<Integer,Boolean> map = new HashMap<>();

        int max = 1;

        for (int number : num) {
            map.put(number, false);
        }

        for (int i : num) {
            if (map.get(i)) {
                continue;
            }

            int temp = i;
            int localMax = 0;

            while (map.containsKey(temp)) {
                localMax++;
                map.put(temp, true);
                temp++;
            }

            temp = i - 1;
            while (map.containsKey(temp)) {
                localMax++;
                map.put(temp, true);
                temp++;
            }

            max = Math.max(max, localMax);
        }

        return max;

    }
}
