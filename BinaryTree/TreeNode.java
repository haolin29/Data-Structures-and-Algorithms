package BinaryTree;

/**
 * Basic data structure to represent a binary tree in this module
 */
public class TreeNode {
    public final int val;
    public TreeNode left, right;

    public TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }

    public TreeNode(int val) {
        this(val, null, null);
    }
}
