package Search;

/**
 * Created by Haolin on 16/7/19.
 */
public class ScrambleString {
    public boolean isScramble(String s1, String s2) {

        // recursive version
        if (s1 == null || s2 == null) return false;

        if (s1.length() != s2.length()) return false;

        if (s1.length() == 1) {
            return s1.equals(s2);
        }

        int len = s1.length();
        for (int i = 1; i < len; i++) {
            if (isScramble(s1.substring(0,i), s2.substring(0,i))
                    && isScramble(s1.substring(i,len), s2.substring(i,len))) {
                return true;
            }

            if (isScramble(s1.substring(0,i), s2.substring(i, len))
                    && isScramble(s1.substring(i,len), s2.substring(0,i))) {
                return true;
            }

        }

        return false;
    }
}
