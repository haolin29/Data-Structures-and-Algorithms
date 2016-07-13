package DataStructure;

import BinaryTree.TreeNode;

import java.util.Stack;

/**
 * Created by Haolin on 16/6/30.
 */
public class MaxTree {
    public TreeNode maxTree(int[] A) {
        /**
         * 寻找从左往右第一个比它大的数 -> 递减栈
         * 栈顶的数大,continue
         * 栈顶的数小,弹出来的树做左子树,弹出的所有节点中,先pop的是后pop的右子树
         */

        Stack<TreeNode> stack = new Stack<>();
        TreeNode root = null;

        for (int i = 0; i <= A.length; i++) {
            TreeNode right = i == A.length ? new TreeNode(Integer.MAX_VALUE) : new TreeNode(A[i]);
            while (!stack.isEmpty()) {
                if (right.val > stack.peek().val) {
                    TreeNode node = stack.pop();
                    if (stack.isEmpty()) {
                        right.left = node;
                    } else {
                        TreeNode left = stack.peek();
                        if (left.val > right.val) {
                            right.left = node;
                        } else {
                            left.right = node;
                        }
                    }
                } else {
                    break;
                }
            }
            stack.push(right);
        }
        return stack.peek().left;
    }

}
