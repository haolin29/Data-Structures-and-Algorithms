package DynamicProgramming;

/**
 * Created by Haolin on 16/7/11.
 */
public class RegularExpressionMatching {
    public boolean isMatch(String s, String p) {
        return helper(s,p,0,0);
    }

    public boolean helper(String s, String p, int i, int j) {
        if (j == p.length()) {
            return i == s.length();
        }

        // j + 1 != '*'
        if (j == p.length() - 1 || p.charAt(j + 1) != '*') {
            if (i == s.length() || s.charAt(i) != p.charAt(j) && p.charAt(j) != '.' ) {
                return false;
            } else {
                return helper(s,p,i+1, j+1);
            }
        }

        // j + 1 == '*'
        while (i < s.length() && (p.charAt(j) == '.' || p.charAt(j) == s.charAt(i))) {
            // best case
            if (helper(s,p,i,j+2)) {
                return true;
            }
            i++;
        }

        return helper(s,p,i, j+2);
    }


//    public boolean isMatchDP(String s, String p) {
//        // state:see if first i and first j can match
//        boolean[][] match = new boolean[s.length() + 1][p.length() + 1];
//
//        // initialize
//        match[0][0] = true;
//
//        // transfer function
//        for (int j = 1; j < p.length(); j++) {
//
//        }
//
//    }
}
