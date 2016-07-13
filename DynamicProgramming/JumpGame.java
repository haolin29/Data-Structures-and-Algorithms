package DynamicProgramming;

/**
 * Created by Haolin on 16/6/9.
 */
public class JumpGame {
    public boolean canJump(int[] A) {
        if (A == null || A.length == 0) {
            return true;
        }

        // state
        int n = A.length;
        boolean[] can = new boolean[n]; // 从起点是否可达当前i所在的那个点

        // init
        can[0] = true;

        // transfer func
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (can[j] && j + A[j] >= i ) {
                    can[i] = true;
                    break; // 前i个位置里面只要有一个可以就行了
                }
            }
        }

        return can[n - 1];


    }
}
