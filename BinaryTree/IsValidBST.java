package BinaryTree;

/**
 * tell if a binary tree is a Binary Search Tree
 */
public class IsValidBST {
    // if u wanna avoid using static member, use this wrapper instead
    // but in fact we do not need to care so much about the issue of using
    // static variables in this situation
    //
    // It's equivalent to TreeNode** in C++
    static class NodeWrapper {
        TreeNode node;
        public NodeWrapper() {}
        public void setNode(TreeNode node) {
            this.node = node;
        }
    }

    public boolean isValidBST(TreeNode root) {
        return isBSTHelper(root, new NodeWrapper());
    }

    private boolean isBSTHelper(TreeNode node, NodeWrapper pred) {
        if (node == null) { return true; }
        if (!isBSTHelper(node.left, pred)) { return false; }
        if (pred.node != null && node.val <= pred.node.val) {
            return false;
        }
        pred.setNode(node);
        return isBSTHelper(node.right, pred);
    }
}
