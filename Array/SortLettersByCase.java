package Array;

/**
 * Created by Haolin on 16/6/25.
 */
public class SortLettersByCase {

    public void exchange(char[] chars, int start, int end) {
        char c = chars[start];
        chars[start] = chars[end];
        chars[end] = c;
    }

    public void sortLetters(char[] chars) {
        if (chars == null || chars.length == 0) {
            return;
        }

        int start = 0;
        int end = chars.length - 1;

        while (true) {
            while (start < end && chars[start] > 'a') {
                start++;
            }

            while (start < end && chars[end] < 'a') {
                end--;
            }

            if (start == end) break;
            exchange(chars, start, end);
        }

    }


}
