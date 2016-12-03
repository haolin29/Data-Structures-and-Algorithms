package DataStructure;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Created by Haolin on 2016/10/17.
 */
public class KLargestNumOfMatrix {
    static class Number {
        int x;
        int y;
        int val;

        public Number(int x, int y, int val) {
            this.x = x;
            this.y = y;
            this.val = val;
        }
    }

    static class NumComparator implements Comparator<Number> {
        @Override
        public int compare(Number n1, Number n2) {
            return n2.val - n1.val;
        }
    }

    static int[] dx = {0, 1};
    static int[] dy = {1, 0};
    public static int kthSmallest(int[][] matrix, int k) {
        // write your code here


        PriorityQueue<Number> pq = new PriorityQueue<Number>(new NumComparator());

        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] visited = new boolean[m][n];

        pq.offer(new Number(0, 0, matrix[0][0]));
        visited[0][0] = true;

        for(int i = 0; i < k - 1; i++) {
            Number cur = pq.poll();

            for(int j = 0; j < 2; j++) {
                int nx = cur.x + dx[j];
                int ny = cur.y + dy[j];

                if(nx < m && ny < n && !visited[nx][ny]) {
                    visited[nx][ny] = true;
                    pq.offer(new Number(nx, ny, matrix[nx][ny]));
                }
            }
        }

        return pq.peek().val;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{3,6,8},{4,5,6}};
        int k = 2;

        System.out.println(kthSmallest(matrix, k));
    }
}
