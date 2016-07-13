package Array;

import java.util.ArrayList;

/**
 * Created by Haolin on 16/6/23.
 */
public class MergeTwoSortedArray {
//    public ArrayList<Integer> mergeSortedArray(ArrayList<Integer> A, ArrayList<Integer> B) {
//        if (A == null && B == null) {
//            return null;
//        }
//
//        ArrayList<Integer> result = new ArrayList<>();
//
//        int i = 0, j = 0;
//
//        while (i < A.size() && j < B.size()) {
//            if (A.get(i) < B.get(j)) {
//                result.add(A.get(i++));
//            } else {
//                result.add(B.get(j++));
//            }
//        }
//
//        while (i != A.size()) {
//            result.add(A.get(i++));
//        }
//
//        while (j != B.size()) {
//            result.add(B.get(i++));
//        }
//    }

    public int[] mergeSortedArray(int[] A, int[] B) {
        // Write your code here
        int m = A.length;
        int n = B.length;
        int[] result = new int[m+n];

        int i = 0, j = 0;
        int index = 0;
        while (i < m && j < n) {
            if (A[i] < B[j]) {
                result[index++] = A[i++];
            } else {
                result[index++] = B[j++];
            }
        }

        while (i < m) {
            result[index++] = A[i++];
        }

        while (j < n) {
            result[index++] = B[j++];
        }

        return result;

    }
}
