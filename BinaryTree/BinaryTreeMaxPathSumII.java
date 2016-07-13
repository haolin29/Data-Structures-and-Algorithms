package BinaryTree;

/**
 * Created by Haolin on 16/6/4.
 */
public class BinaryTreeMaxPathSumII {
    public int BinaryTreeMaxPathSumII(TreeNode root) {
        if(root == null) {
            return 0;
        }

        // divide
        int left = BinaryTreeMaxPathSumII(root.left);
        int right = BinaryTreeMaxPathSumII(root.right);

        return Math.max(Math.max(left,right),0) + root.val;

    }
}
