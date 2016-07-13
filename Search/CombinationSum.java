package Search;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Haolin on 16/7/7.
 */
public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        // write your code here
        List<List<Integer>> result = new ArrayList<>();
        if (candidates == null || candidates.length == 0) {
            return result;
        }

        Arrays.sort(candidates);
        List<Integer> path = new ArrayList<>();
        // 从candidates 从index位置挑出一部分数 放到path,当target == 0 的时候放到result
        dfs(candidates, path, 0,target, result);
        return result;

    }

    public void dfs(int[] candidates, List<Integer> path, int index, int target, List<List<Integer>> result) {
        // base case
        if (target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        // remove duplicate
        for (int i = index; i < candidates.length; i++) {
            if (candidates[i] > target) { // 如果这条线上的和不可能凑成target
                break;
            }

            if (i != 0 && candidates[i] == candidates[i - 1]) {
                continue;
            }

            path.add(candidates[i]);
            dfs(candidates, path, i, target - candidates[i], result);
            path.remove(path.size() - 1);
        }
    }
}
