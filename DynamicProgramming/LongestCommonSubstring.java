package DynamicProgramming;

/**
 * Created by Haolin on 16/6/17.
 */
public class LongestCommonSubstring {
    public int LCS(String A, String B) {
        if (A == null || A.length() == 0 || B == null || B.length() == 0) {
            return 0;
        }

        int m = A.length();
        int n = B.length();

        // state
        int[][] f = new int[m+1][n+1];

        // init f[i][0] = 0, f[0][i] = 0;

        // transfer function

        int max = 0;
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (A.charAt(i - 1) != B.charAt(j - 1)) {
                    continue;
                }

                f[i][j] = f[i - 1][j - 1] + 1;

                max = Math.max(f[i][j],max);

            }
        }

        return max;

    }
}
