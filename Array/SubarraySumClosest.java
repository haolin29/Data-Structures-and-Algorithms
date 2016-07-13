package Array;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Haolin on 16/6/25.
 */
class Element implements Comparable<Element>{
    int val;
    int index;

    public Element(int v, int i) {
        this.val = v;
        this.index = i;
    }

    public int compareTo(Element other) {
        return this.val - other.val;
    }

}

public class SubarraySumClosest {
    public int[] subarraySum(int[] nums) {
        int[] result = new int[2];
        if (nums == null || nums.length == 0) return result;

        Element[] sum = new Element[nums.length + 1];
        sum[0] = new Element(0, -1);

        int prefixSum = 0;
        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
            sum[i + 1] = new Element(prefixSum,i);
        }

        Arrays.sort(sum);

        int start = Math.min(sum[0].index, sum[1].index) + 1;
        int end = Math.max(sum[0].index, sum[1].index);
        int min = Math.abs(sum[1].val - sum[0].val);


        for (int i = 1; i < sum.length; i++) {
            int diff = Math.abs(sum[i].val - sum[i - 1].val);

            if (diff < min) {
                min = diff;
                start = Math.min(sum[i].index, sum[i - 1].index) + 1;
                end = Math.max(sum[i].index, sum[i - 1].index);
            }
        }

        result[0] = start;
        result[1] = end;
        return result;

    }
}
