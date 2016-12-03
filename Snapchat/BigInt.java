package Snapchat;

/**
 * Created by Haolin on 2016/11/23.
 */
public class BigInt {

    public static String add(String number, String num2) {
        int i = number.length() - 1;
        int j = num2.length() - 1;

        StringBuilder sb = new StringBuilder();
        int carry = 0;
        while(i >= 0 || j >= 0) {
            int sum = carry;
            if(i >= 0) {
                sum += number.charAt(i--) - '0';
            }

            if(j >= 0) {
                sum += num2.charAt(j--) - '0';
            }

            sb.append(sum % 10);
            carry /= 10;
        }

        if (carry != 0) {
            sb.append(carry);
        }
        return sb.reverse().toString();
    }

    public static String sub(String number, String num2) {
        boolean neg = false;
        if (smallThan(number, num2)) {
            String temp = number;
            number = num2;
            num2 = temp;
            neg = true;
        }

        StringBuilder sb = new StringBuilder();
        int carry = 0;

        int i = number.length() - 1;
        int j = num2.length() - 1;

        while(i >= 0 || j >= 0) {
            int sum = -carry;
            if (i >= 0) {
                sum += number.charAt(i--) - '0';
            }
            if (j >= 0) {
                sum -= num2.charAt(j--) - '0';
            }

            if (sum < 0) {
                sum += 10;
                carry = 1;
            }
            sb.append(sum);
        }
        if (sb.charAt(sb.length() - 1) == '0') {
            sb.deleteCharAt(sb.length() - 1);
        }

        if (sb.length() == 0) {
            return "0";
        }

        sb = neg ? sb.append("-") : sb;

        return sb.reverse().toString();
    }

    public static boolean smallThan(String number, String num2) {
        if (num2.length() > number.length()) return true;
        else if (number.length() > num2.length()) return false;
        else {
            for (int i = 0; i < number.length(); i++) {
                if (num2.charAt(i) > number.charAt(i)) {
                    return true;
                }
            }
            return false;
        }
    }

    public static String multiply(String num1, String num2) {
        int[] result = new int[num1.length() + num2.length()];
        int i = num1.length() - 1;
        int j = num2.length() - 1;

        for (; i >= 0; i--) {
            int carry = 0;
            for (; j >= 0; j--) {
                int product = carry + result[i + j + 1] + (num1.charAt(i) - '0') * (num2.charAt(j) - '0');
                result[i + j + 1] = product % 10;
                carry = product / 10;
            }
            result[i + j + 1] = carry;
        }

        StringBuilder sb = new StringBuilder();

        for (int k = 0; k < result.length; k++) {
            if (sb.length() == 0 && result[k] == 0) continue;
            sb.append(result[k]);
        }

        return sb.length() == 0 ? "0" : sb.toString();
    }

    public static void main(String[] args) {
        String num1 = "1";
        String num2 = "100";
        System.out.println(add(num1, num2));
        System.out.println(sub(num1, num2));
        System.out.println(multiply(num1, num2));
    }
}
