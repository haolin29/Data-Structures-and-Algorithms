package BinarySearch;

/**
 * Created by Haolin on 16/7/8.
 */
public class SearchA2DMatrixII {
    public int searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0) {
            return 0;
        }

        int occurrence = 0;

        int rows = matrix.length;
        int cols = matrix[0].length;

        int row = rows - 1;
        int col = 0;

        while (row >= 0 && col < cols) {
            if (matrix[row][col] == target) {
                occurrence++;
                row--;
            } else if (matrix[row][col] > target) {
                row--;
            } else {
                col++;
            }

        }

        return occurrence;
    }
}
