package DataStructure;

import java.util.Stack;

/**
 * Created by Haolin on 16/6/29.
 */
public class MinStack {
    Stack<Integer> stack;
    Stack<Integer> minStack;
    public MinStack() {
        // do initialize if necessary
        stack = new Stack<>();
        minStack = new Stack<>();
    }

    public void push(int number) {
        // write your code here
        if (minStack.empty()) {
            stack.push(number);
            minStack.push(number);
        } else {
            if (number > minStack.peek()) {
                stack.push(number);
            } else {
                stack.push(number);
                minStack.push(number);
            }
        }
    }

    public int pop() {
        // write your code here
        int num = stack.pop();
        if (num == minStack.peek()) {
            minStack.pop();
        }

        return num;
    }

    public int min() {
        // write your code here
        return minStack.peek();
    }
}
