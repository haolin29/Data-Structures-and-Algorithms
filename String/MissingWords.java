package String;

/**
 * Created by Haolin on 2016/10/6.
 */
public class MissingWords {
    public static String[] missing(String s, String t) {
        int i = 0;
        int j = 0;

        String[] arr1 = s.split(" ");
        String[] arr2 = t.split(" ");

        String[] result = new String[arr1.length - arr2.length];
        while(i < arr1.length && j < arr2.length) {
            if(arr1[i].equals(arr2[j])) {
                i++;
                j++;
            } else {
                result[i - j] = arr1[i];
                i++;
            }
        }

        while(i != arr1.length) {
            result[i - j] = arr1[i++];
        }

        return result;
    }

    public static void main(String[] args) {
        String s = "I am lucky";
        String t = "am";

        String[] res = missing(s, t);

        for(String word : res) {
            System.out.println(word);
        }

    }
}
