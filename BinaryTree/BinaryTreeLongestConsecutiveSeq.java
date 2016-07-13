package BinaryTree;

/**
 * Created by Haolin on 16/6/5.
 */
public class BinaryTreeLongestConsecutiveSeq {
    int maxLen = 0;
    public int longestSeq(TreeNode root) {
        helper(root, null, 0);
        return maxLen;
    }

    public void helper(TreeNode root, TreeNode parent, int len) {
        if (root == null) {
            return;
        }

        len = (parent != null && root.val == parent.val + 1) ? len + 1 : len;
        maxLen = Math.max(maxLen, len);
        helper(root.left,root,len);
        helper(root.right,root,len);
    }


    public int longestSeqBottomUp(TreeNode root) {
        longestSeqBottomUpHelper(root);
        return maxLen;
    }

    private int longestSeqBottomUpHelper(TreeNode root) {
        if (root == null) return 0;

        int left = longestSeqBottomUpHelper(root.left) + 1;
        int right = longestSeqBottomUpHelper(root.right) + 1;

        if (root.left != null && root.left.val != root.val + 1) {
            return 1;
        }

        if (root.right != null && root.right.val != root.val + 1) {
            return 1;
        }

        int len = Math.max(left,right);
        maxLen = Math.max(len,maxLen);

        return len;

    }
}
