package DataStructure;

import java.util.Stack;

/**
 * Created by Haolin on 16/6/29.
 */
public class ImplementQueuebyTwoStacks {
    public class Queue {
        private Stack<Integer> stack1;
        private Stack<Integer> stack2;

        public Queue() {
            // do initialization if necessary
            stack1 = new Stack<>();
            stack2 = new Stack<>();
        }

        public void push(int element) {
            // write your code here
            stack1.push(element);
        }

        public int pop() {
            // write your code here
            if (stack2.empty()){
                while (!stack1.empty()) {
                    int num = stack1.pop();
                    stack2.push(num);
                }
            }

            return stack2.pop();
        }

        public int top() {
            // write your code here
            if (stack2.empty()){
                while (!stack1.empty()) {
                    int num = stack1.pop();
                    stack2.push(num);
                }
            }

            return stack2.peek();
        }
    }
}
