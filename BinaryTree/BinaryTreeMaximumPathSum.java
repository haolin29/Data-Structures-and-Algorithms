package BinaryTree;

/**
 * Created by Haolin on 16/6/4.
 */

class ResultType {
    int singlePath;
    int maxPath;
    ResultType(int singlePath, int maxPath) {
        this.singlePath = singlePath;
        this.maxPath = maxPath;
    }

}
public class BinaryTreeMaximumPathSum {
    public int MaxPathSum(TreeNode root) {
        return helper(root).maxPath;
    }

    ResultType helper(TreeNode root) {
        if (root == null) {
            return new ResultType(0, Integer.MIN_VALUE);
        }

        // divide
        ResultType left = helper(root.left);
        ResultType right = helper(root.right);


        // conquer
        int singlePath = Math.max(0, Math.max(left.singlePath, right.singlePath) + root.val);

        int maxPath = Math.max(Math.max(left.maxPath, right.maxPath), left.singlePath + right.singlePath + root.val);

        return new ResultType(singlePath, maxPath);
    }

}
