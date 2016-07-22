package DynamicProgramming;

import java.util.*;

/**
 * Created by Haolin on 16/7/22.
 */
public class WordBreakII {
    public static List<String> wordBreak(String s, Set<String> wordDict) {
        List<String> result = new ArrayList<>();

        if (s == null || s.length() == 0) {
            return result;
        }

        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        boolean[][] f = new boolean[n][n + 1];

        dp[0] = true;
        for (int i = 1; i <= n; i++) {
            for (int j = i - 1; j >= 0; j-- ) {
                if (dp[j] && wordDict.contains(s.substring(j, i))) {
                    dp[i] = true;
                    f[j][i] = true;
                }
            }
        }

        List<String> path = new ArrayList<>();
        dfs(s, result, path, s.length(), f);

        return result;

    }

    public static void dfs(String s, List<String> result,
                    List<String> path, int pos, boolean[][] isValue) {
        if (pos == 0) {
            StringBuilder sb = new StringBuilder();
            for (int i = path.size() - 1; i >= 0; i--) {
                sb.append(path.get(i)).append(" ");
            }
            sb.deleteCharAt(sb.length() - 1);
            result.add(sb.toString());
        }

        for (int i = 0; i < s.length(); i++ ) {
            if (isValue[i][pos]) {
                path.add(s.substring(i,pos));
                dfs(s, result, path, i,isValue);
                path.remove(path.size() - 1);
            }
        }
    }

    public static void main(String[] args) {
        String s = "catsanddog";
        Set<String> wordDict = new HashSet<>(Arrays.asList("cat","cats","and","sand","dog"));
        List<String> result = wordBreak(s, wordDict);

    }
}
