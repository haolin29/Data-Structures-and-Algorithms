package BinarySearch;

/**
 * Created by Haolin on 16/7/8.
 */
public class SearchInRotatedSortedArray {
    public int search(int[] A, int target) {
        if (A == null || A.length == 0) {
            return -1;
        }

        int start = 0;
        int end = A.length - 1;

        while (start + 1 < end) {
            int mid = start + (end - start) / 2;

            if (A[mid] == target) {
                return mid;
            }

            if (A[start] < A[mid]) {
                if (A[start] <= target && A[mid] > target) {
                    end = mid;
                } else {
                    start = mid;
                }
            } else {
                if (A[end] >= target && A[mid] < target) {
                    start = mid;
                } else {
                    end = mid;
                }
            }
        }

        if (A[start] == target) {
            return start;
        } else if (A[end] == target) {
            return end;
        }

        return -1;

    }
}
