package String;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Haolin on 16/9/7.
 */
public class EncodeAndDecodeString {
    // Encodes a list of strings to a single string.
    public static String encode(List<String> strs) {
        if(strs == null || strs.size() == 0) {
            return "";
        }

        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < strs.size(); i++) {
            sb.append(String.valueOf(strs.get(i).length()) + '#');
            sb.append(strs.get(i));
        }

        return sb.toString();
    }

    // Decodes a single string to a list of strings.
    public static List<String> decode(String s) {
        List<String> result = new ArrayList<>();


        int start = 0;
        while(start < s.length()) {
            int index = s.indexOf("#", start);
            int len = Integer.parseInt(s.substring(start, index));

            result.add(s.substring(index + 1, index + len + 1));
            s = s.substring(index + len + 1);
            start = index + len + 1;
        }

        return result;

    }

    public static void main(String[] args) {
        List<String> strs = new ArrayList<>();
        strs.add("jfdkljfla");
        strs.add("#$%^&*(JJKJL12312");
        String s = encode(strs);

        List<String> destr = decode(s);

        System.out.println(destr);


    }
}
