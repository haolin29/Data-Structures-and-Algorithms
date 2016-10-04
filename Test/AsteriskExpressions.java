package Test;

import java.util.LinkedList;
import java.util.Scanner;

/**
 * Created by Haolin on 2016/9/28.
 */
public class AsteriskExpressions {
    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc = new Scanner(System.in);
        int lines = sc.nextInt();
        for(int i = 0; i < lines; i++) {
            String exps = sc.next();
            String result = parseAsterisk(exps);
            System.out.println(result);
        }

    }

    public static String parseAsterisk(String s) {
        if(s == null || s.length() == 0 ) {
            return "Syntax Error";
        }

        LinkedList<Long> stack = new LinkedList<>();

        if(s.charAt(0) == '*') {
            return "Syntax Error";
        }
        String firstNum = getNum(s, 0);

        stack.push(Long.parseLong(firstNum));
        int i = firstNum.length();

        while(i < s.length()) {
            String exp = getOp(s,i);

            if(exp == null) {
                return "Syntax Error";
            }

            i += exp.length();
            String nextNum = getNum(s, i);
            long num = Long.parseLong(nextNum);

            if(exp.equals("*")) {
                stack.push(num);
            }

            if(exp.equals("**")) {

                long n1 = (long)(Math.pow(stack.pop(), num));
                stack.push(n1);
            }

            i += nextNum.length();
        }

        long result = 1;
        while(!stack.isEmpty()) {
            result *= stack.pop();
        }

        return result + "";
    }

    public static String getNum(String s, int start) {
        StringBuilder sb = new StringBuilder();
        while(start < s.length() && Character.isDigit(s.charAt(start))) {
            sb.append(s.charAt(start));
            start++;
        }

        return sb.toString();
    }

    public static String getOp(String s, int start) {
        StringBuilder sb = new StringBuilder();
        int count = 0;
        while(start < s.length() && s.charAt(start) == '*') {
            sb.append(s.charAt(start));
            start++;
            count++;
        }

        return count > 2 ? null : sb.toString();
    }
}
