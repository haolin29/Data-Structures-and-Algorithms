package Array;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Haolin on 16/6/24.
 */
public class SubarraySum {
    public ArrayList<Integer> subarraySum(int[] nums) {
        if (nums == null) {
            return null;
        }

        HashMap<Integer,Integer> map = new HashMap<>();
        ArrayList<Integer> result = new ArrayList<>();

        // my version
//        int tmp = 0;
//        for (int i = 0; i < nums.length; i++) {
//            tmp += nums[i];
//            if (tmp == 0) {
//                result.add(0);
//                result.add(i);
//                return result;
//            } else if (map.containsKey(tmp)) {
//                result.add(map.get(tmp)+1);
//                result.add(i);
//                return result;
//            } else {
//                map.put(tmp,i);
//            }
//        }


        // jiuzhang version
        int sum = 0;
        map.put(0, -1);

        for (int i = 0; i < nums.length; i++) {
            sum += nums[i];

            if (map.containsKey(sum)) {
                result.add(map.get(sum) + 1);
                result.add(i);
                return result;
            }

            map.put(sum,i);
        }


        return result;
    }
}
