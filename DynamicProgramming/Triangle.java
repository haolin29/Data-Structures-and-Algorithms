package DynamicProgramming;

/**
 * Created by Haolin on 16/6/6.
 */
public class Triangle {
    public int minimumPathSumV1(int[][] triangle) {
        // top down
        if (triangle == null || triangle.length == 0) {
            return -1;
        }
        int n = triangle.length;
        int[][] f = new int[n][n]; // 从0,0 出发到当前点的最短距离

        // initialize
        f[0][0] = triangle[0][0];

        for (int i = 1; i < n; i++) {
            f[i][0] = f[i - 1][0] + triangle[i][0];
            f[i][i] = f[i - 1][i - 1] + triangle[i][i];
        }

        // calculate
        for (int i = 1; i < n; i++) {
            for (int j = 1; j < i; j++) {
                f[i][j] = Math.min(f[i - 1][j],f[i - 1][j - 1]) + triangle[i][j];
            }
        }

        // result
        int best = f[n - 1][0];
        for (int i = 1; i < n; i++) {
            if (f[n - 1][i] < best) {
                f[n - 1][i] = best;
            }
        }

        return best;

    }

    public int miniPathSumV2(int[][] triangle) {
        // bottom up
        if (triangle == null || triangle.length == 0) {
            return -1;
        }

        int n = triangle.length;
        int[][] f = new int[n][n]; //从后往前看
        for (int i = 0; i < n; i++) {
            f[n - 1][i] = triangle[n - 1][i];
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                f[i][j] = Math.min(f[i + 1][j],f[i+1][j+ 1]) + triangle[i][j];
            }
        }

        return f[0][0];

    }

    int[][] hash;
    public int miniPathSumV3(int[][] triangle) {
        // memorization search
        if (triangle == null || triangle.length == 0) {
            return -1;
        }

        int n = triangle.length;
        this.hash = new int[n][n];

        for (int i = 0; i < n; i++) {
            for(int j = 0; j < n; j++) {
                hash[i][j] = -1;
            }
        }
        return helper(triangle,0,0);
    }

    public int helper(int[][] triangle, int x, int y) {
        if (x >= triangle.length) {
            return 0;
        }

        if (hash[x][y] != -1) {
            return hash[x][y];
        }

        return hash[x][y] = Math.min(helper(triangle, x + 1,y), helper(triangle, x + 1, y+ 1)) + triangle[x][y];
    }
}
