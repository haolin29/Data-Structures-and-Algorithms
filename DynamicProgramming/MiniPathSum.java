package DynamicProgramming;

/**
 * Created by Haolin on 16/6/8.
 */
public class MiniPathSum {
    public int pathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }

        // state
        int m = grid.length;
        int n = grid[0].length;
        int[][] dp = new int[m][n]; // 从起点到当前点的最小路径和

        // init
        for (int i = 0; i < n; i++) {
            dp[0][i] = grid[0][i];
        }

        for (int i = 0; i < m; i++) {
            dp[i][0] = grid[i][0];
        }

        // transfer function
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = Math.min(dp[i - 1][j], dp[i][j - 1]) + grid[i][j];
            }
        }

        return dp[m - 1][n - 1];

    }
}
