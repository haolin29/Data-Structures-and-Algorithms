package AZ;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Haolin on 2016/11/17.
 */
public class WindowSum {
    public static List<Integer> windowSum(int[] array, int k) {
        if(array == null || array.length == 0 || k <= 0) {
            return new ArrayList<>();
        }

        List<Integer> result = new ArrayList<>();
        int sum = 0;
        for(int i = 0; i < array.length; i++) {
            if(i < k) {
                sum += array[i];
                if(i == k - 1) {
                    result.add(sum);
                }
            } else {
                sum += array[i];
                sum -= array[i - k];
                result.add(sum);
            }
        }

        return result;
    }

    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,8};
        int k = 3;
        List<Integer> result = windowSum(arr, k);
        for (int i : result) {
            System.out.print(i + " ");
        }

    }

}
