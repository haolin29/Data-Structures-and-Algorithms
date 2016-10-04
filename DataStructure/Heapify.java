package DataStructure;

/**
 * Created by Haolin on 16/7/2.
 */
public class Heapify {

    public void heapify(int[] A) {
        // bottom up approach
        // if find one child in reverse-array order, sift down, sift up
        if (A == null || A.length == 0) {
            return;
        }

        int n = A.length;
        for (int i = n / 2; i >= 0; i--) {
            siftdown(A,i);
        }
    }

    public void siftdown(int[] A, int i) {
        while (i < A.length) {
            int smallest = i;
            if (i * 2 + 1 < A.length && A[i * 2 + 1] < A[smallest]) {
                smallest = i * 2 + 1;
            }
            if (i * 2 + 2 < A.length && A[i * 2 + 2] < A[smallest]) {
                smallest = i * 2 + 2;
            }

            if (i == smallest) break;

            int temp = A[smallest];
            A[smallest] = A[i];
            A[i] = temp;

            i = smallest;

        }
    }

    public void siftup(int[] A, int i) {
        while (i != 0) {
            int parent = (i - 1) / 2;
            if (A[parent] < A[i]) {
                break;
            }
            int temp = A[parent];
            A[parent] = A[i];
            A[i] = temp;
            i = parent;
        }
    }
}
