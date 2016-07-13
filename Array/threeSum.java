package Array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Haolin on 16/6/24.
 */
public class threeSum {
    public ArrayList<ArrayList<Integer>> threeSum(int[] numbers) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();

        if (numbers == null || numbers.length < 3) {
            return result;
        }

        Arrays.sort(numbers);

        for (int i = 0; i < numbers.length - 2; i++) {
            if (i != 0 && numbers[i] == numbers[i - 1]) {
                continue;
            }
            int left = i + 1;
            int right = numbers.length - 1;
            while (left < right) {
                int sum = numbers[i] + numbers[left] + numbers[right];
                if (sum == 0) {
                    ArrayList<Integer> oneSolution = new ArrayList<>();
                    oneSolution.add(numbers[i]);
                    oneSolution.add(numbers[left]);
                    oneSolution.add(numbers[right]);
                    result.add(oneSolution);

                    left++;
                    right--;
                    while(left < right && numbers[left] == numbers[left - 1]) {
                        left++;
                    }

                    while(left < right && numbers[right] == numbers[right + 1]) {
                        right--;
                    }
                } else if (sum > 0) {
                    right--;
                } else {
                    left++;
                }
            }
        }

        return result;
    }
}
