package DynamicProgramming;

import java.util.Set;

/**
 * Created by Haolin on 16/6/10.
 */
public class WordBreak {
    public boolean wordBreak(String s, Set<String> dict) {
        if (s == null || s.length() == 0) {
            return true;
        }
        int maxLen = getMaxLen(dict);

        // state
        int n = s.length();
        boolean[] f = new boolean[n+1];

        // init
        f[0] = true;

        // transfer function
        for (int i = 1; i <= n; i++) {
            for (int len = 1; len <= maxLen && len <= i; len++) { // last word length
                if (!f[i - len]) continue;
                String sub = s.substring(i - len, i);
                if (dict.contains(sub)) {
                    f[i] = true;
                    break;
                }
            }
        }

        return f[n];

    }

    public int getMaxLen(Set<String> dict) {
        int maxLen = 0;
        for (String s:dict) {
            maxLen = Math.max(maxLen,s.length());
        }
        return maxLen;
    }

}
