package Search;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Haolin on 16/7/6.
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        // write your code here
        List<List<String>> result = new ArrayList<>();
        if (s == null) return result;

        // s里面当前切割出来path, 在index的位置切一刀,结果放到result里面
        List<String> path = new ArrayList<>();
        dfs(s, path, 0, result);
        return result;

    }

    public void dfs(String s, List<String> path, int start, List<List<String>> result) {
        if (start == s.length()) {
            result.add(new ArrayList<>(path));
            return;
        }

        for (int end = start + 1; end <= s.length(); end++) {
            String sub = s.substring(start, end);
            if (!isPalindrome(sub)) {
                continue;
            }
            path.add(sub);
            dfs(s, path, end, result);
            path.remove(path.size() - 1);

        }

    }

    public boolean isPalindrome(String s) {
        int begin = 0;
        int end = s.length() - 1;

        while (begin < end) {
            if (s.charAt(begin++) != s.charAt(end--)) {
                return false;
            }
        }

        return true;
    }
}
