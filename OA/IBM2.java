package OA;

/**
 * Created by Haolin on 2016/10/29.
 */
public class IBM2 {
    public static void main(String[] a) {

        String s = "IBM cognitive computing|IBM \"cognitive\""
                + " computing is a revolution| ibm cognitive  computing|IBM Cognitive Computing' is a revolution?";

        //s = "\"C S D\"|C-S-D|the \"c s d\"";

        System.out.println(filter(s));

    }

    private static String filter(String s) {

        if (s == null || s.length() == 0) {
            return s;
        }

        String[] words = s.split("\\|");
        if (words.length <= 1) {
            return s;
        }

        String[] processed = new String[words.length];

        for (int i = 0; i < words.length; i++) {
            // pre process the string to trim and remove special chars
            String cur = preProcess(words[i]);
            processed[i] = cur;

            // if contained in any results, or any results is contained current
            for (int j = 0; j < processed.length; j++) {

                if (processed[j] == null || j == i) {
                    continue;
                }

                String tmp = processed[j];
                if(tmp.equals(cur)){
                    int len1 = words[j].length();
                    int len2 = words[i].length();

                    if(len2 < len1)
                        processed[j] = null;
                    else
                        processed[i] = null;

                    continue;
                }

                if (processed[j].contains(cur)) { // equal is included
                    processed[i] = null;
                } else if (cur.contains(processed[j])) {
                    processed[j] = null;
                }
            }
        }

        StringBuilder res = new StringBuilder();

        // output the remaining words
        for (int i = 0; i < processed.length; i++) {
            if (processed[i] != null && processed[i].length() > 0)
                res.append(words[i].replaceAll("\\s+", " ") + "|");
        }

        return res.substring(0, res.length() - 1);
    }

    private static String preProcess(String s) {

        s = s.trim().replaceAll("\\s+", " ");

        String[] words = s.split("\\s");

        StringBuilder sb = new StringBuilder();

        // remove
        for (int pos = 0; pos < words.length; pos++) {

            char[] chars = words[pos].toCharArray();

            String tmp = "";
            for (int i = 0; i < chars.length; i++)
                if (Character.isLetterOrDigit(chars[i])) {
                    tmp += Character.toLowerCase(chars[i]);
                }

            sb.append(tmp);
            sb.append(" ");
        }

        return sb.substring(0, sb.length() - 1);
    }
}
