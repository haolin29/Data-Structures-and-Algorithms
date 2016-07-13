package BinaryTree;

import java.util.Stack;

/**
 * Created by Haolin on 16/6/3.
 */
public class BinarySearchTreeIterator {
    private TreeNode cur; // why use this parameter? memorize the intermediate status
    private Stack<TreeNode> stack = new Stack<>();

    public BinarySearchTreeIterator(TreeNode root) {
        this.cur = root;
    }

    public boolean hasNext() {
        if (cur != null || !stack.isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    public TreeNode next() {
        while(cur != null) {
            stack.push(cur);
            cur = cur.left;
        }

        TreeNode node = stack.pop();
        cur = node.right;
        return node;

    }
}
