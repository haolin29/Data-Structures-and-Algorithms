package BinaryTree;

/**
 * Tell if a tree is balanced
 */
public class IsBalanced {
    public boolean isBalanced(TreeNode root) {
        return computeDepth(root) >= 0;
    }

    public int computeDepth(TreeNode root) {
        if (root == null) { return 0; }
        int leftDepth = computeDepth(root.left);
        if (leftDepth < 0) return -1;
        int rightDepth = computeDepth(root.right);
        if (rightDepth < 0) return -1;
        boolean isBalanced = Math.abs(leftDepth - rightDepth) <= 1;
        if (isBalanced) {
            return Math.max(leftDepth, rightDepth) + 1;
        } else {
            return -1;
        }
    }
}
