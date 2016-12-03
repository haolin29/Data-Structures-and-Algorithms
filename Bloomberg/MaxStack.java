package Bloomberg;

import java.util.LinkedList;

/**
 * Created by Haolin on 2016/12/2.
 */
public class MaxStack {
    LinkedList<Integer> stack = new LinkedList<>();
    LinkedList<Integer> max = new LinkedList<>();

    public MaxStack() {

    }

    public void push(int val) {
        stack.push(val);

        // error-prone
        if (max.isEmpty()) {
            max.push(val);
        } else if (val >= max.peek()) {
            max.push(val);
        }
    }

    public int pop() {
        int temp = -1;
        if(max.peek() == stack.pop()) {
            temp = max.pop();
        }

        return temp;
    }

    public int getMax() {
        return max.peek();
    }

    public int peek() {
        return stack.peek();
    }

}
