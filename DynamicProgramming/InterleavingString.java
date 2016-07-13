package DynamicProgramming;

/**
 * Created by Haolin on 16/6/18.
 */
public class InterleavingString {
    public boolean isInterleaving(String s1, String s2, String s3) {
        if (s1.length() + s2.length() != s3.length()) {
            return false;
        }

        int m = s1.length();
        int n = s2.length();
        int l = s3.length();

        // state
        boolean[][] f = new boolean[m+1][n+1]; // if the first i elements in s1 and the first j elements in s2
        // can be form the first i+j elements in s3

        // init
        // whether the fist i elements in s1 equals the first i elements in s3
        f[0][0] = true;
        for (int i = 1; i <= m; i++) {
            if (s1.charAt(i - 1) == s3.charAt(i - 1)) {
                f[i][0] = true;
            }
        }

        for (int i = 1; i <= n; i++) {
            if (s2.charAt(i - 1) == s3.charAt(i - 1)) {
                f[0][i] = true;
            }
        }

        // transfer function
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if ((f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1))
                || (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1))) {
                    f[i][j] = true;
                }
            }
        }

        return f[m][n];

    }
}
