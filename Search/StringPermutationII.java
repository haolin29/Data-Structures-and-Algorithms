package Search;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Haolin on 16/7/7.
 */
public class StringPermutationII {
    public List<String> stringPermutation2(String str) {
        List<String> result = new ArrayList<>();
        if (str == null) {
            return result;
        }

        StringBuilder sb = new StringBuilder();

        char[] chars = str.toCharArray();
        Arrays.sort(chars);

        boolean[] visited = new boolean[str.length()];
        dfs(chars, sb, result, visited);

        return result;
    }

    public void dfs(char[] chars, StringBuilder sb, List<String> result,boolean[] visited ) {
        // base case
        if (sb.length() == chars.length) {
            result.add(sb.toString());
            return;
        }

        for (int i = 0; i < chars.length; i++) {
            if (visited[i] || (i != 0 && chars[i] == chars[i - 1] && !visited[i - 1])) {
                continue;
            }
            sb.append(chars[i]);
            visited[i] = true;
            dfs(chars, sb, result, visited);
            sb.deleteCharAt(sb.length() - 1);
            visited[i] = false;
        }
    }
}
