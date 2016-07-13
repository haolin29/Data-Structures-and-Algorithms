package Search;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Haolin on 16/7/6.
 */
public class NQueens {

    static int count = 0;

    public int totalNQueens(int n) {
        //write your code here
        ArrayList<Integer> cols = new ArrayList<>();

        search(cols, n);

        return count;
    }

    public void search(ArrayList<Integer> cols, int n) {
        if (cols.size() == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!isValid(cols, col)) {
                continue;
            }
            cols.add(col);
            search(cols, n);
            cols.remove(cols.size() - 1);
        }
    }



    public boolean isValid(ArrayList<Integer> cols, int col) {
        int row = cols.size();

        for (int i = 0; i < row; i++) {
            // same column
            if (cols.get(i) == col) {
                return false;
            }

            // top-left to bottom-right
            if (i - cols.get(i) == row - col) {
                return false;
            }

            // top-right to bottom-left
            if (i + cols.get(i) == row + col) {
                return false;
            }

        }

        return true;
    }
}
