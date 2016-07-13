package Search;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Created by Haolin on 16/7/6.
 */
public class PermutationII {
    public ArrayList<ArrayList<Integer>> permuteUnique(ArrayList<Integer> nums) {
        // write your code here

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (nums == null || nums.size() == 0) {
            return result;
        }

        Collections.sort(nums);
        int[] visited = new int[nums.size()];
        ArrayList<Integer> path = new ArrayList<>();
        dfs(nums, result, path, visited);
        return result;
    }

    public void dfs(ArrayList<Integer> nums, ArrayList<ArrayList<Integer>> result, ArrayList<Integer> path,
                    int[] visited) {
        if (path.size() == nums.size()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = 0; i < nums.size(); i++) {
            if (visited[i] == 1 || (i != 0 && nums.get(i) == nums.get(i - 1) && visited[i - 1] == 0))
            path.add(nums.get(i));
            visited[i] = 1;
            dfs(nums, result, path, visited);
            path.remove(nums.size() - 1);
            visited[i] = 0;
        }
    }
}
