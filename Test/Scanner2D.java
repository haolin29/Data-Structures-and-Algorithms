package Test;

import java.util.Scanner;

/**
 * Created by Haolin on 2016/9/28.
 */
public class Scanner2D {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int arr[][] = new int[n][3];
        for(int arr_i=0; arr_i < n; arr_i++){
            for(int arr_j=0; arr_j < 3; arr_j++){
                arr[arr_i][arr_j] = in.nextInt();
            }
        }

        System.out.println("11");
    }
}
