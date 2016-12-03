package Snapchat;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Haolin on 2016/11/18.
 */
public class twentyFour {

    public static void main(String[] args) {
        int[] nums = {4,4,10,10};
        System.out.println(get24(nums));
    }

    public static boolean get24(int[] nums) {
        if(nums == null || nums.length == 0) return false;
        Arrays.sort(nums);
        return helper(nums, new ArrayList<>(), new boolean[nums.length]);
    }

    public static boolean helper(int[] nums, List<Integer> elem, boolean[] visited) {
        if(elem.size() == nums.length) {
            for(double num : diffWayToCompute(elem, 0, elem.size() - 1)) {
                if(num == 24.0) {
                    System.out.println(num);
                    return true;
                }
            }
        }

        for (int i = 0; i < nums.length; i++) {
            if(visited[i] || i > 0 && nums[i] == nums[i - 1] && !visited[i - 1]) {
                continue;
            }
            elem.add(nums[i]);
            visited[i] = true;
            if(helper(nums, elem, visited)) return true;
            elem.remove(elem.size() - 1);
            visited[i] = false;
        }

        return false;
    }

    public static List<Double> diffWayToCompute(List<Integer> list, int start, int end) {
        List<Double> result = new ArrayList<>();
        if(start == end) {
            result.add((double)list.get(start));
            return result;
        }

        for(int i = start; i < end; i++) {
            List<Double> left = diffWayToCompute(list, start, i);
            List<Double> right = diffWayToCompute(list, i + 1, end);
            for (Double a : left) {
                for (Double b : right) {
                    result.add(a + b);
                    result.add(a - b);
                    result.add(a * b);
                    if (b != 0) {
                        result.add(a / b);
                    }
                    System.out.println(a);
                    System.out.println(b);
                }
            }
        }
        return result;
    }
}
