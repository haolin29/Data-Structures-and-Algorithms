package BackTracking;

import java.util.ArrayList;

/**
 * Created by Haolin on 16/7/24.
 */
public class CountNumbersWithUniqueDigits {
    int count = 0;
    public int countNumbersWithUniqueDigits(int n) {
        // state(0,0,0)
        // (the current number, number of steps to get that number ,
        // a bitmask which represent which number is marked as visited so far in the current number).
        int res = 1;
        double max = Math.pow(n, 10);
        int used = 0;
        for (int i = 1; i < 10; i++) {
            used |= 1 << i;
            dfs(i, max, used);
            used &= ~(1 << i);
        }

        return res;
    }

    public int dfs(int pre, double max, int used) {
        int res = 0;
        if (pre < max) res++;
        else return res;

        for (int i = 0; i < 10; i++) {
            if ((used & (1 << i)) == 0) {
                used |= 1 << i;
                int cur = pre * 10 + i;
                res += dfs(cur, max, used);
                used &= ~(1 << i);
            }
        }
        return res;
    }
}
