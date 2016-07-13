package BinaryTree;

import java.util.ArrayList;

/**
 * Created by Haolin on 16/6/4.
 */
public class SearchRangeinBST {

    ArrayList<Integer> result = new ArrayList<>();

    public ArrayList<Integer> searchRange(TreeNode root, int k1, int k2) {
        if (root == null) {
            return result;
        }

        helper(root, k1, k2);

        return result;
    }

    public void helper(TreeNode root, int k1, int k2) {
        if (root == null) {
            return;
        }

        helper(root.left, k1, k2);

        if (root.val >= k1 && root.val <= k2) {
            result.add(root.val);
        }

        helper(root.right, k1,k2);
    }

}
