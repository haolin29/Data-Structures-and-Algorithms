package DataStructure;

import java.util.Stack;

/**
 * Created by Haolin on 16/6/29.
 */
public class LargestRectangleInHistogram {
    public int largestRectangleArea(int[] height) {
        if (height == null || height.length == 0) {
            return 0;
        }

        /**
         * 递增栈
         * for(每个短板)
         *   left延伸的位置
         *   right延伸的位置
         *   max = max{max, (right - left + 1) * height[短板] }
         */

        Stack<Integer> stack = new Stack<>(); // keep index in the stack

        int max = 0;
        for (int i = 0; i <= height.length; i++) {
            int cur = i == height.length ? -1 : height[i];
            while (!stack.isEmpty() && cur <= height[stack.peek()]) {
                int hgt = height[stack.pop()];
                int wdh = stack.isEmpty() ? i : i - stack.peek() - 1;
                max = Math.max(max, hgt * wdh);
            }
            stack.push(i);
        }

        return max;
    }
}
