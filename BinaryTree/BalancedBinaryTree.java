package BinaryTree;

/**
 * Created by Haolin on 16/6/3.
 */

// bottom up
public class BalancedBinaryTree {
    public boolean BalancedBinaryTree(TreeNode root) {
        return getDepth(root) != -1;
    }

    public int getDepth(TreeNode root) {
        if(root == null) {
            return 0;
        }

        int left = getDepth(root.left);
        int right = getDepth(root.right);


        // use -1 to present unBalanced
        if (left == -1 || right == -1 || Math.abs(left - right ) > 1) {
            return -1;
        }

        return Math.max(left, right) + 1;
    }
}
