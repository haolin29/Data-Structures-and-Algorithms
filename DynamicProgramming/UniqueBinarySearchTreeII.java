package DynamicProgramming;

import BinaryTree.TreeNode;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Haolin on 16/7/20.
 */
public class UniqueBinarySearchTreeII {
    public List<TreeNode> generateTrees(int n) {
        return generate(1,n);
    }

    public List<TreeNode> generate(int left, int right) {
        List<TreeNode> res = new ArrayList<>();
        // base case
        if (left > right) {
            res.add(null);
            return res;
        }

        for (int i = left; i <= right; i++) {
            List<TreeNode> leftList = generate(left, i - 1);
            List<TreeNode> rightList = generate(i + 1, right);

            for (TreeNode leftNode : leftList) {
                for (TreeNode rightNode : rightList) {
                    TreeNode root = new TreeNode(i);
                    root.left = leftNode;
                    root.right = rightNode;
                    res.add(root);
                }
            }


        }

        return res;
    }
}
