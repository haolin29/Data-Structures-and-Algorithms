package BinaryTree;

import java.util.Stack;

/**
 * Created by Haolin on 16/6/5.
 */
public class InOrderSuccessorInBST {
    public static TreeNode inOrderSuccessor(TreeNode root, TreeNode p) {
        if(root == null || p == null) {
            return null;
        }

        TreeNode successor = null;

        while(root != null && root.val != p.val) {
            if (root.val > p.val) {
                successor = root;
                root = root.left;
            } else {
                root = root.right;
            }
        }

        if (root == null) {
            return successor;
        }

        if (root.right == null) {
            return successor;
        }

        root = root.right;

        while(root.left != null) {
            root = root.left;
        }

        return root;
    }

    public TreeNode inOrderSuccessorRec(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }

        if (root.val <= p.val) {
            return inOrderSuccessorRec(root.right,p);
        } else {
            TreeNode left = inOrderSuccessorRec(root.left,p);
            return (left != null) ? left : root;
        }
    }

    public TreeNode inOrderPredecessorRec(TreeNode root, TreeNode p) {
        if (root == null) {
            return null;
        }

        if (root.val >= p.val) {
            return inOrderPredecessorRec(root.left,p);
        } else {
            TreeNode right = inOrderPredecessorRec(root.right,p);
            return (right != null) ? right : root;
        }

    }

    public static void main(String[] args) {
        TreeNode root = BinaryTreeSerialization.deserialize("4,2,6,1,3,5,7");
        TreeNode p = new TreeNode(4);
        TreeNode result = inOrderSuccessor(root, p);
        System.out.println(result.val);
    }

}
