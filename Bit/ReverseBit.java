package Bit;

/**
 * Created by Haolin on 2016/10/7.
 */
public class ReverseBit {
    public static void main(String[] args) {
        int n = 5;
        int mask = 1, result = 0;
        for(int i = 0; i < 32; i++) {
            result <<= 1;
            if((mask & n) != 0) result |= 1;
            mask <<= 1;
        }

        System.out.println(result);
    }
}
