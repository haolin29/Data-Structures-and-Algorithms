package Search;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Haolin on 16/7/7.
 */
public class KSumII {
    public ArrayList<ArrayList<Integer>> kSumII(int[] A, int k, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (A == null || A.length < k) {
            return result;
        }

        Arrays.sort(A);
        ArrayList<Integer> path = new ArrayList<>();
        dfs(A, path, k, target, result, 0);

        return result;
    }

    public void dfs(int[] A, ArrayList<Integer> path, int k, int target,
                    ArrayList<ArrayList<Integer>> result, int pos) {
        // base case
        if (k == 0 && target == 0) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int i = pos; i < A.length; i++) {
            if (A[i] > target || k < 0) {
                break;
            }
            path.add(A[i]);
            dfs(A, path, k - 1, target - A[i], result, i + 1);
            path.remove(path.size() - 1);
        }
    }
}
