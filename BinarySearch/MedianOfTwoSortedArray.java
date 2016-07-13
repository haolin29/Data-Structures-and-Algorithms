package BinarySearch;

/**
 * Created by Haolin on 16/7/8.
 */
public class MedianOfTwoSortedArray {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int len = A.length + B.length;

        if (len % 2 == 1) {
            return findKth(A,0,B,0, len / 2 + 1);
        } else {
            return (findKth(A,0,B,0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2;
        }
    }

    public double findKth(int[] A, int aStart, int[] B, int bStart, int k) {
        // base case
        if (aStart >= A.length ) {
            return B[bStart + k - 1];
        }

        if (bStart >= B.length) {
            return A[aStart + k - 1];
        }

        if (k == 1) {
            return Math.min(A[aStart], B[bStart]);
        }

        // coordinate change
        int Akey = aStart + k / 2 - 1 > A.length ? Integer.MAX_VALUE : A[aStart + k / 2 - 1];
        int Bkey = bStart + k / 2 - 1 > A.length ? Integer.MAX_VALUE : B[bStart + k / 2 - 1];

        if (Akey < Bkey) {
            return findKth(A, aStart + k / 2, B, bStart, k - k / 2);
        } else {
            return findKth(A, aStart, B, bStart + k / 2, k - k / 2);
        }
    }
}