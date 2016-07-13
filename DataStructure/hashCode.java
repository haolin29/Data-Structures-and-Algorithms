package DataStructure;

/**
 * Created by Haolin on 16/6/30.
 */
public class hashCode {
    public int hashCode(char[] key, int HASH_SIZE) {
        long sum = 0;
        for (char c: key) {
            sum = sum * 33 + (int)c;
            sum = sum % HASH_SIZE;
        }

        return (int)sum;
    }
}
