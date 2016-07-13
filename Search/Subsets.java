package Search;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Haolin on 16/7/6.
 */
public class Subsets {
    public ArrayList<ArrayList<Integer>> subsets(int[] nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (nums == null || nums.length == 0) {
            return result;
        }

        ArrayList<Integer> path = new ArrayList<>();
        Arrays.sort(nums);

        // 把[] 开头的所有的排列, 都放到result里面
        dfs(nums, result, path, 0);

        return result;

    }
    // 把list开头的所有排列都加到result里面
    public void dfs(int[] nums, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path, int index) {
        result.add(new ArrayList<>(path));

        // for,1开头的, 2开头的, 3 开头的
        for (int i = index; i < nums.length; i++) {
            // if have duplication
//            if (i != index && nums[i] == nums[i - 1]) {
//                continue;
//            }
            // index 是什么,递归下层的第一个元素
            path.add(nums[i]);
            dfs(nums, result, path, i + 1); // marked
            path.remove(path.size() - 1);
        }
    }


    public static void main(String[] args) {
        int[] nums = new int[]{1,2,3};
        System.out.println(nums);

        ArrayList<ArrayList<Integer>> result = new Subsets().subsets(nums);
        for (ArrayList<Integer> path : result) {
            System.out.println(path);
        }
    }
}
