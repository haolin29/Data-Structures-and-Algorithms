package DynamicProgramming;

/**
 * Created by Haolin on 16/6/8.
 */
public class UniquePathII {
    public int uniquePath(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        // assume that the grid is square
        int n = grid.length;

        // save state
        int[][] dp = new int[n][n]; // 到当前点有多少条路径

        // init
        for (int i = 0; i < n; i++) {
            if (grid[0][i] != 1) {
                dp[0][i] = 1;

            } else {
                break;
            }

        }


        for (int i = 0; i < n; i++) {
            if (grid[i][0] != 1) {
                dp[i][0] = 1;
            } else {
                break;
            }

        }

        // transfer function

        for (int i = 1; i < n; i++) {
            for (int j = 1; j < n; i++) {
                if (grid[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
                }
            }
        }

        return dp[n - 1][n - 1];

    }
}
