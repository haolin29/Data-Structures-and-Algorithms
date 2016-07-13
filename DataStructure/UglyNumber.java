package DataStructure;

/**
 * Created by Haolin on 16/7/3.
 */
public class UglyNumber {
    public int nthUgly(int n) {
        if (n == 0) return 0;

        int[] list = new int[n];
        int i2 = 0, i3 = 0, i5 = 0;
        list[0] = 1;

        int index = 1;
        while (index < n) {
            int u2 = list[i2] * 2, u3 = list[i3] * 3, u5 = list[i5] * 5;
            int min = Math.min(u2, Math.min(u3, u5));

            if (u2 == min) i2++;
            if (u3 == min) i3++;
            if (u5 == min) i5++;

            list[index++] = min;
        }

        return list[n - 1];


    }

    public static void main(String[] args) {
        int resutl = new UglyNumber().nthUgly(13);

    }
}
