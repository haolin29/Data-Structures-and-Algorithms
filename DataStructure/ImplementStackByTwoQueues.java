package DataStructure;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Haolin on 16/7/1.
 */
public class ImplementStackByTwoQueues {
    // 主从关系,只变一个
    Queue<Integer> q1 = new LinkedList<>();
    Queue<Integer> q2 = new LinkedList<>();

    public void moveItem() {
        while (q1.size() != 1) {
            q2.offer(q1.poll());
        }
    }

    public void swapQueue() {
        Queue<Integer> temp = new LinkedList<>();
        q1 = q2;
        q2 = temp;
    }

    public void push(int x) {
        // Write your code here
        q1.offer(x);
    }

    // Pop the top of the stack
    public void pop() {
        moveItem();
        q1.poll();
        swapQueue();

    }



    // Return the top of the stack
    public int top() {
        moveItem();
        int temp = q1.poll();
        swapQueue();
        q1.offer(temp);
        return temp;

    }

    // Check the stack is empty or not.
    public boolean isEmpty() {
        // Write your code here
        return q1.isEmpty() && q2.isEmpty();
    }
}
