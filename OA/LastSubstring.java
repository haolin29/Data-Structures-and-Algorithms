package OA;

/**
 * Created by Haolin on 16/9/8.
 */
public class LastSubstring {
    public String getLastSubstring(String str) {

        char best = str.charAt(0);
        for (int i = 0; i < str.length(); i++) {
            char cur = str.charAt(i);
            if (cur > best) {
                best = cur;
            }
        }

        String res = "";
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == best) {
                String sub = str.substring(i);
                if (sub.compareTo(res) > 0) {
                    res = sub;
                }
            }
        }
        return res;
    }
}
