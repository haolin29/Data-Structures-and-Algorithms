package Search;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Haolin on 16/7/6.
 */
public class Permutations {
    public ArrayList<ArrayList<Integer>> permute(ArrayList<Integer> nums) {
        // write your code here
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (nums == null || nums.size() == 0) {
            return result;
        }

        Collections.sort(nums);
        ArrayList<Integer> path = new ArrayList<>();
        dfs(nums, result, path);
        return result;
    }

    public void dfs(ArrayList<Integer> nums, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path) {
        if (path.size() == nums.size()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            if (path.contains(nums.get(i))) {
                continue;
            }
            path.add(nums.get(i));
            dfs(nums, result, path);
            path.remove(nums.size() - 1);
        }
    }
}
