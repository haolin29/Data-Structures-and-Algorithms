package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

/**
 * Created by Haolin on 16/6/25.
 */
public class fourSum {
    public ArrayList<ArrayList<Integer>> fourSum(int[] numbers, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (numbers == null || numbers.length == 0) {
            return result;
        }

        Arrays.sort(numbers);
        // two pointer version
        int n = numbers.length;
        for (int i = 0; i < n - 3; i++) {
            if (i != 0 && numbers[i] == numbers[i-1]) {
                continue;
            }

            for (int j = i + 1; j < n - 2; j++) {
                if (j != i + 1 && numbers[j] == numbers[j-1]) {
                    continue;
                }

                int start = j + 1;
                int end = n - 1;

                while (start < end) {
                    int sum = numbers[i] + numbers[j] + numbers[start] + numbers[end];

                    if (sum == target) {
                        ArrayList<Integer> ans = new ArrayList<>();
                        ans.add(numbers[i]);
                        ans.add(numbers[j]);
                        ans.add(numbers[start]);
                        ans.add(numbers[end]);
                        result.add(ans);
                        start++;
                        end--;

                        while (start < end && numbers[start] == numbers[start - 1] ) {
                            start++;
                        }

                        while (start < end && numbers[end] == numbers[end + 1] ) {
                            end--;
                        }

                    } else if (sum > target) {
                        end--;
                    } else {
                        start++;
                    }

                }

            }
        }

        return result;
    }

    public ArrayList<ArrayList<Integer>> fourSumV2(int[] numbers, int target) {
        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (numbers == null || numbers.length == 0) {
            return result;
        }

        Arrays.sort(numbers);

        HashMap<Integer,ArrayList<int[]>> map = new HashMap<>();

        int n = numbers.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int sum = numbers[i] + numbers[j];
                if (!map.containsKey(sum)) {
                    map.put(sum, new ArrayList<int[]>());
                }
                int[] pair = new int[2];
                pair[0] = i;
                pair[1] = j;

                ArrayList<int[]> temp = map.get(sum);
                temp.add(pair);
                map.put(sum, temp);

            }
        }

        int start = 0;
        int end = n - 1;
        while (start < end) {
            int sum = numbers[start] + numbers[end];
            if (map.containsKey(-sum)) {
                // get the pair
                // check the index and if has duplicates
                // if available put it in arraylist
            }
        }
        return result;
    }

}
