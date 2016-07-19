package DynamicProgramming;

/**
 * Created by Haolin on 16/6/18.
 */
public class DistinctSequences {
    public int distinct(String S, String T) {
        if (S == null || T == null) {
            return 0;
        }

        int m = S.length();
        int n = T.length();

        // state
        int[][] f = new int[m+1][n+1];

        // init
        for (int i = 0; i <= m; i++) {
            f[i][0] = 1;
        }


        // transfer function
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (S.charAt(i - 1 ) == T.charAt(j - 1)) {
                    f[i][j] = f[i - 1][j - 1] + f[i - 1][j];
                } else {
                    f[i][j] = f[i - 1][j];
                }
            }
        }

        return f[m][n];
    }


    public static int numDistinct(String S, String T) {
        // Start typing your Java solution below
        // DO NOT write main() function
        if (S.length() == 0) {
            return T.length() == 0 ? 1 : 0;
        }
        if (T.length() == 0) {
            return 1;
        }
        int cnt = 0;
        for (int i = 0; i < S.length(); i++) {
            if (S.charAt(i) == T.charAt(0)) {
                cnt += numDistinct(S.substring(i + 1), T.substring(1));
            }
        }
        return cnt;
    }

    public static void main(String[] args) {
        String s = "rbbb";
        String t = "rbb";

        int count = numDistinct(s, t);

    }
}
