package Array;

/**
 * Created by Haolin on 16/6/23.
 */
public class MedianOfTwoSortedArrays {
    public double findMedianSortedArrays(int[] A, int[] B) {
        int len = A.length + B.length;
        if (len % 2 == 1) {
            return findKth(A, 0, B, 0, len / 2 + 1);
        } else {
            return (findKth(A, 0, B, 0, len / 2) + findKth(A, 0, B, 0, len / 2 + 1)) / 2;
        }
    }

    public double findKth(int[] A, int AStart, int B[], int BStart, int k) {
        // basecase
        if (AStart >= A.length) {
            return B[BStart + k - 1];
        }

        if (BStart >= B.length) {
            return A[AStart + k - 1];
        }

        if (k == 1) {
            return Math.min(A[AStart],B[BStart]);
        }

        int AKey = AStart + k / 2 - 1 > A.length ? Integer.MAX_VALUE : A[AStart + k / 2 - 1];
        int BKey = BStart + k / 2 - 1 > B.length ? Integer.MAX_VALUE : B[BStart + k / 2 - 1];

        if (AKey < BKey) {
            return findKth(A, AStart + k / 2, B, BStart, k - k / 2);
        } else {
            return findKth(A, AStart, B, BStart + k / 2, k - k / 2);
        }
    }

    // summary
    // find Kth element
    // we should consider which part we should discard
    // what is the base case and corner case?
    // how to discard element? move the start point and change the k
}
