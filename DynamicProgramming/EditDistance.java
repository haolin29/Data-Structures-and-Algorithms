package DynamicProgramming;

/**
 * Created by Haolin on 16/6/17.
 */
public class EditDistance {
    public int miniDistance(String word1, String word2) {
        if (word1 == null || word2 == null ) {
            return 0;
        }

        int m = word1.length();
        int n = word2.length();

        // state
        int[][] f = new int[m+1][n+1]; // how many steps by editing word1 to word2 at the elements befor i and j

        // init
        for (int i = 0; i <= m; i++) {
            f[i][0] = i;
        }

        for (int i = 0; i <= n; i++) {
            f[0][i] = i;
        }

        // transfer function
        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (word1.charAt(i - 1) != word2.charAt(j - 1)) {
                    f[i][j] = 1 + Math.min(Math.min(f[i][j - 1], f[i - 1][j]), f[i - 1][j - 1]);
                } else {
                    f[i][j] = Math.min(Math.min(f[i][j - 1] + 1, f[i - 1][j] + 1), f[i - 1][j - 1]);
                }
            }
        }

        return f[m][n];
    }
}
