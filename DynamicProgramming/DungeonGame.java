package DynamicProgramming;

/**
 * Created by Haolin on 16/7/22.
 */
public class DungeonGame {
    public int calculateMinimumHP(int[][] dungeon) {
        // mini HP should 1 when enter each room
        int m = dungeon.length;
        int n = dungeon[0].length;

        if (dungeon == null || m == 0 || n == 0) {
            return 0;
        }

        // state
        int[][] dp = new int[m][n];

        // init
        // transfer function, invariant
        // dp[i][j] = max{1, -d[i][j] + min(dp[i + 1][j], dp[i][j + 1])}

        dp[m - 1][n - 1] = Math.max(1, -dungeon[m - 1][n - 1] + 1);

        for (int i = m - 1; i >= 0; i--) {
            dp[i][n - 1] = Math.max(1, -dungeon[i][n - 1] + dp[i + 1][n - 1]);
        }

        for (int i = n - 1; i >= 0; i--) {
            dp[m - 1][i] = Math.max(1, -dungeon[m - 1][i] + dp[m - 1][i + 1]);
        }

        for(int i = m - 2; i >= 0; i--) {
            for(int j = n - 2; j >= 0; j--) {
                dp[i][j] = Math.max(1, -dungeon[i][j] + Math.min(dp[i+1][j], dp[i][j+1]));
            }
        }

        return dp[0][0];


    }
}
