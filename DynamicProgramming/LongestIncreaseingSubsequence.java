package DynamicProgramming;

/**
 * Created by Haolin on 16/6/10.
 */
public class LongestIncreaseingSubsequence {
    public int LIS(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }

        // state
        int n = A.length;
        int[] f = new int[n]; // 从起点到当前点LIS的长度

        // init
        int max = 0;

        // transfer function
        for (int i = 0; i < n; i++) {
            f[i] = 1;
            for (int j = 0; j < i; j++) {
                if (A[j] <= A[i]) { // 可以有duplicate
                    if (f[i] < f[j] + 1) {
                        f[i] = f[j] + 1;
                    }
                }
            }

            max = Math.max(max, f[i]);
        }

        return max;
    }
}
