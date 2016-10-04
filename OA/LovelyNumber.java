package OA;

/**
 * Created by Haolin on 16/9/8.
 */
public class LovelyNumber {
    public int lovely1Helper(int a) {
        char[] str = String.valueOf(a).toCharArray();
        int total = 0;

        for (int i = 0; i < str.length; i++) {
            int count = 0;
            boolean stop = false;

            for (int j = 0; j < i; j++) {
                if (str[j] < str[i])    count++;
                else if (str[j] == str[i])  stop = true;
            }
            int d = str[i] - '0' - (i == 0 ? 1 : 0) - count;
            for (int j = i+1; j < str.length; j++) {
                d *= (10 - j);
            }
            total += d;
            if (stop) {
                break;
            } else if (i == str.length - 1) {
                total++;
            }
        }

        for (int i = 1; i < str.length; i++) {
            int fac = 9;
            for (int j = 1; j < i; j++) {
                fac *= (10 - j);
            }
            total += fac;
        }
        return total + 1;
    }

    public int lovely(int a, int b) {
        return lovely1Helper(b) - lovely1Helper(a-1);
    }

    public static void main(String[] args) {
        LovelyNumber test = new LovelyNumber();
        System.out.println(test.lovely(1, 1020120291));
    }

}
