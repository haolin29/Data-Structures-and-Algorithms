package Test;

import java.util.PriorityQueue;

/**
 * Created by Haolin on 16/8/4.
 */
public class PQ {
    public static void main(String[] args) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(3, (a,b) -> (a - b));

        pq.add(1);
        pq.add(2);
        pq.add(3);

        System.out.println(pq.poll());
    }
}
