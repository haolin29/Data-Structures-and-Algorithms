package OA;

/**
 * Created by Haolin on 2016/10/29.
 */
public class IBM1 {
    public static void main(String [] a){

        System.out.println(output(7, 2, 3));
    }


    private static String output(int n, int p, int q){

        if(n <= 0 || p < 1 || q < 1 || p == q)
            return null;

        // construct in a String builder
        StringBuilder sb = new StringBuilder();

        String pStr = String.valueOf(p);
        String qStr = String.valueOf(q);

        for(int num=1; num<=n; num++){

            String tmpRes = "";

            if(num % p == 0 || num % q == 0)
                tmpRes += "OUT";

            String numS = String.valueOf(num);

            if(numS.contains(pStr) || numS.contains(qStr))
                tmpRes += "THINK";

            if(tmpRes.length() == 0)
                sb.append(num);
            else
                sb.append(tmpRes);

            sb.append(",");
        }

        return sb.substring(0, sb.length()-1);
    }
}
