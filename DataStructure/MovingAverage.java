package DataStructure;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * Created by Haolin on 16/9/6.
 */
public class MovingAverage {
    Deque<Integer> deque;
    int size;
    int sum;

    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        deque = new ArrayDeque<>();
        this.size = size;
        sum = 0;
    }

    public double next(int val) {
        deque.addLast(val);
        sum += val;
        if(deque.size() < size) {
            return (double)sum / deque.size();
        } else {
            int temp = deque.pollFirst();
            sum -= temp;
            return (double)sum / size;
        }
    }

    public static void main(String[] args) {
        MovingAverage m = new MovingAverage(3);
        m.next(1);
        m.next(3);
        m.next(5);
        m.next(9);
    }

}
