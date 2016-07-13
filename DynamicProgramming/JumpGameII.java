package DynamicProgramming;

/**
 * Created by Haolin on 16/6/9.
 */
public class JumpGameII {
    public int canJump(int[] A) {
        if (A == null || A.length == 0) {
            return 0;
        }
        int n = A.length;
        int[] f = new int[n]; // 从起点跳到i的最小steps

        // init
        f[0] = 1;

        // transfer function
        for (int i = 1; i < n; i++) {
            f[i] = -1;
            for (int j = 0; j < i; j++) {
                if(f[j] != -1 && A[j] + j >= i) {
                    f[i] = f[j] + 1;
                    break;
                }
            }
        }

        return f[n - 1];


    }
}
