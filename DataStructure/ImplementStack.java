package DataStructure;

import java.util.ArrayList;

/**
 * Created by Haolin on 16/7/1.
 */
public class ImplementStack {
    ArrayList<Integer> stack = new ArrayList<>();
    public void push(int x) {
        // Write your code here
        stack.add(x);

    }

    // Pop the top of the stack
    public void pop() {
        // Write your code here
        stack.remove(stack.size() - 1);

    }

    // Return the top of the stack
    public int top() {
        // Write your code here
        return stack.get(stack.size() - 1);
    }

    // Check the stack is empty or not.
    public boolean isEmpty() {
        // Write your code here
        return stack.size() == 0;
    }
}
