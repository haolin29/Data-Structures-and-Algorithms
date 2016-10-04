package OA;

import java.util.PriorityQueue;

/**
 * Created by Haolin on 16/9/8.
 */
public class ReductionCost {
    public static int reductionCost(int[] num) {
        if (num == null || num.length == 0) {
            return -1;
        }

        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : num) {
            pq.add(i);
        }

        int total = 0;
        while (pq.size() > 1) {
            int num1 = pq.poll();
            int num2 = pq.poll();
            total += num1 + num2;
            pq.add(num1 + num2);
        }

        return total;
    }
}
