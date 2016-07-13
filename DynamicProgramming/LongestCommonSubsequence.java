package DynamicProgramming;

/**
 * Created by Haolin on 16/6/17.
 */
public class LongestCommonSubsequence {
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

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                f[i][j] = Math.max(f[i - 1][j],f[i][j - 1]);

                if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    f[i][j] = Math.max(f[i][j],f[i - 1][j - 1] + 1);
                }
            }
        }

        return f[m][n];

    }
}
