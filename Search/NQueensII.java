package Search;

import java.util.ArrayList;


/**
 * Created by Haolin on 16/7/6.
 */
public class NQueensII {



    public void search(ArrayList<Integer> cols, int count, int n) {
        if (cols.size() == n) {
            count++;
            return;
        }

        for (int col = 0; col < n; col++) {
            if (!new NQueens().isValid(cols, col)) {
                continue;
            }
            cols.add(col);
            search(cols, count, n);
            cols.remove(cols.size() - 1);
        }
    }

    public int totalNQueens(int n) {
        //write your code here
        ArrayList<Integer> cols = new ArrayList<>();
        int count = 0;
        search(cols, count, n);
        return count;
    }
}
