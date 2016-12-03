package TwoPointer;

/**
 * Created by Haolin on 2016/10/22.
 */
public class MinimumWindowSubstring {
    public static String minWindow(String source, String target) {
        // write your code
        String mini = "";
        int minLen = Integer.MAX_VALUE;

        int[] sourceHash = new int[256];
        int[] targetHash = new int[256];

        initTarget(targetHash, target);

        int i = 0, j = 0;

        for(i = 0; i < source.length(); i++) {
            while(j < source.length() && !valid(sourceHash, targetHash)) {
                sourceHash[source.charAt(j)]++;
                j++;
            }

            if(valid(sourceHash, targetHash)) {
                if(minLen > j - i) {
                    minLen = Math.min(minLen, j - i);
                    mini = source.substring(i,j);
                }
            }
            sourceHash[source.charAt(i)]--;
        }

        return mini;
    }

    private static void initTarget(int[] targetHash, String target) {
        for(char c : target.toCharArray()) {
            targetHash[c]++;
        }
    }

    private static boolean valid(int[] sourceHash, int[] targetHash) {
        for(int i = 0; i < 256; i++) {
            if(targetHash[i] > sourceHash[i]) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        String s = "ABCfhdjfhjkdhfkjd";
        String t = "Afjdj";

        System.out.println(minWindow(s,t));
    }
}
