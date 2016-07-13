package DynamicProgramming;

/**
 * Created by Haolin on 16/6/10.
 */
public class  PalindromePartitioningii {
    public int miniCut(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }

        // preprocess
        boolean[][] isPalindrome = getPalindrome(s);

        // state
        int n = s.length();
        int[] f = new int[n + 1]; // 前i个元素最少可以切几刀

        // init
        for (int i = 0; i <= n; i++) {
            f[n] = i - 1;
        }

        // transfer function
        for (int i = 1; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                if (isPalindrome[j][i - 1] && f[j] + 1 < f[i]) {
                    f[i] = f[j] + 1;
                }
            }
        }

        return f[n];
    }

    public boolean[][] getPalindrome(String s) {
        int n = s.length();
        boolean[][] result = new boolean[n][n];

        // init
        for (int i = 0; i < n; i++) {
            result[i][i] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                result[i][i+1] = true;
            }
        }

        // transfer function
        for (int len = 2; len < n; len++) {
            for (int start = 0; start < n - len; start++) {
                result[start][start+len] = result[start+1][start + len - 1] && s.charAt(start) == s.charAt(start + len);
            }
        }

        return result;

    }
}
