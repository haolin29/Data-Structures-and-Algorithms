package BinaryTree;

/**
 * Created by Haolin on 16/6/5.
 */
public class LowestCommonAncestor {
    public TreeNode LCAOfBST(TreeNode root, TreeNode p, TreeNode q) {

        if (root == null || root == p || root == q) {
            return root;
        }

        if (root.val < Math.min(p.val, q.val)) {
            return LCAOfBST(root.right,p,q);
        } else if (root.val > Math.max(p.val,q.val)) {
            return LCAOfBST(root.left,p,q);
        } else {
            return root;
        }

    }

    public TreeNode LCA(TreeNode root, TreeNode p, TreeNode q) {
        if (root == null || root == q || root == p) {
            return root;
        }

        // divide
        TreeNode left = LCA(root.left, p, q);
        TreeNode right = LCA(root.right,p,q);

        // conquer
        // find it!
        if (left != null && right != null) {
            return root;
        }

        return left == null ? right : left;
    }

}
