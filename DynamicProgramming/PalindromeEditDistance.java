package DynamicProgramming;

/**
 * Created by Haolin on 2016/11/25.
 */
public class PalindromeEditDistance {
    public static int miniEditDistance(String s) {
        if (s == null || s.length() <= 1 ) {
            return 0;
        }

        int len = s.length();

        // substring[i, j] 是palindrome的最小操作数是多少
        int[][] dp = new int[len][len];

        // init skip, dp[i][i] = 0,  dp[i][i + 1] = 0

        for(int i = 1; i < len; i++) {
            for(int j = i; j >= 0; j--) {
                if(i == j) {
                    dp[i][i] = 0;
                } else if(i == j + 1 && s.charAt(i) == s.charAt(j)) {
                    dp[j][i] = 0;
                } else if(i == j + 1 && s.charAt(i) != s.charAt(j)) {
                    dp[j][i] = 1;
                } else if(s.charAt(i) == s.charAt(j)) {
                    dp[j][i] = dp[j + 1][i - 1];
                } else if(s.charAt(i) != s.charAt(j)) {
                    dp[j][i] = Math.min(dp[j + 1][i - 1],
                            Math.min(dp[j + 1][i], dp[j][i - 1])) + 1;
                }
            }
        }

        return dp[0][len - 1];
    }

    // version 2 区间型动归标准写法
    public static int miniEditDistanceII(String s) {
        if (s == null || s.length() <= 1 ) {
            return 0;
        }

        int len = s.length();

        // substring[i, j] 是palindrome的最小操作数是多少
        int[][] dp = new int[len][len];

        // init skip, dp[i][i] = 0
        for(int i = 0; i < len - 1; i++) {
            if(s.charAt(i) != s.charAt(i + 1)) {
                dp[i][i + 1] = 1;
            }
        }

        for(int l = 2; l < len; l++) {
            for(int i = 0; i + l < len; i++) {
                if(s.charAt(i) == s.charAt(i + l)) {
                    dp[i][i + l] = dp[i + 1][i + l - 1];
                } else {
                    dp[i][i + l] = Math.min(dp[i + 1][i + l - 1],
                            Math.min(dp[i + 1][i + l], dp[i][i + l - 1])) + 1;
                }
            }
        }

        return dp[0][len - 1];
    }

    public static void main(String[] args) {
        String s = "fhjksdjflsadjlfjlasdjfioeqwuoi32uoruwoerusdjklfvasdlkdvhyo48urt4uor9";

        System.out.println(miniEditDistance(s));
        System.out.println(miniEditDistanceII(s));
    }
}
