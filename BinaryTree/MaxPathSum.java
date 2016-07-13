package BinaryTree;

import java.util.Arrays;
import java.util.Collections;

/**
 * get a path from an arbitrary node to another arbitrary node which
 * the sum of node's value along the path is the maximum in the tree
 */
public class MaxPathSum {
    static class Maxes {
        public final long maxWithRoot;
        public final long maxWithoutRoot;
        public Maxes(long maxWithRoot, long maxWithoutRoot) {
            this.maxWithRoot = maxWithRoot;
            this.maxWithoutRoot = maxWithoutRoot;
        }
    }

    static final Maxes MINS = new Maxes(Integer.MIN_VALUE, Integer.MIN_VALUE);

    public int fix(long num) {
        if (num > Integer.MAX_VALUE) {
            return Integer.MAX_VALUE;
        } else if (num < Integer.MIN_VALUE) {
            return Integer.MIN_VALUE;
        }
        return (int) num;
    }

    public int maxPathSum(TreeNode root) {
        Maxes maxes = maxPathSumWithAndWithoutRoot(root);
        return Math.max(fix(maxes.maxWithRoot), fix(maxes.maxWithoutRoot));
    }

    public Maxes maxPathSumWithAndWithoutRoot(TreeNode root) {
        if (root == null) { return MINS; }
        Maxes lmaxes = maxPathSumWithAndWithoutRoot(root.left);
        Maxes rmaxes = maxPathSumWithAndWithoutRoot(root.right);

        long maxWithRoot = Collections.max(Arrays.asList(
                lmaxes.maxWithRoot + root.val,
                rmaxes.maxWithRoot + root.val,
                (long) root.val
        ));

        long maxWithoutRoot = Collections.max(Arrays.asList(
                lmaxes.maxWithRoot,
                rmaxes.maxWithRoot,
                lmaxes.maxWithoutRoot,
                rmaxes.maxWithoutRoot,
                lmaxes.maxWithRoot + root.val + rmaxes.maxWithRoot
        ));
        return new Maxes(maxWithRoot, maxWithoutRoot);
    }
}
