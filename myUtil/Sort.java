package myUtil;

import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Haolin on 16/6/19.
 */
public class Sort {
    public void selectionSort(int[] A) {
        int n = A.length;

        // select the min number of right part (unsorted part), exchange with the ith number

        for (int i = 0; i < n; i++) {
            int min = A[i];
            int j;
            // find the minimum number
            for (j = i + 1; j < n; j++) {
                if (A[j] < min) {
                    min = A[j];
                }
            }

            // swap
            swap(A,i,j);
        }


    }

    public void swap(int[] A, int i, int j) {
        int temp = A[i];
        A[i] = A[j];
        A[j] = temp;
    }

    public void insertionSort(int[] A) {
        int n = A.length;

        for (int i = 0; i < n; i++) {
            for (int j = i; j >= 0 && A[j] < A[j - 1]; j--) {
                swap(A,j,j - 1);
            }
        }
    }
}
