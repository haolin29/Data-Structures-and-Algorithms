package Bit;

/**
 * Created by Haolin on 2016/9/29.
 */
public class NumberofBits {
    public static void main(String[] args) {
        int count = 0;

        int n = 4;

        for(int i = 0; i < 32; i++) {
            if((n & (1 << i)) != 0) {
                count++;
            }
        }

        System.out.println(count);
    }
}
