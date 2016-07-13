package BinarySearch;

/**
 * Created by Haolin on 16/7/8.
 */
public class FindMinimumInRotatedSortedArrayII {
    public int findMin(int[] num) {
        if (num == null || num.length == 0) {
            return -1;
        }

        /**
         * 这题考察的不是二分法,而是最坏的情况是什么样的
         * 最坏的情况[1,1,1,1......1,1,1,1,]中间有个0,这时候必须全部扫描一遍,时间复杂度就退化到O(n)
         */

        int start = 0;
        int end = num.length - 1;
        while (start + 1 < end) {
            int mid = start + (end - start) / 2;
            if (num[mid] == num[end]) {
                end--;
            } else if (num[mid] < num[end]) {
                end = mid;
            } else {
                start = mid;
            }
        }

        if (num[end] < num[start]) {
            return num[end];
        } else {
            return num[start];
        }
    }
}
