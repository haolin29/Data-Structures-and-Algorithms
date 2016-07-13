package BinaryTree;

/**
 * Created by Haolin on 16/6/5.
 */
public class ClosestBinarySearchTreeValue {
    public int closetValue(TreeNode root, double target) {
        double closest = root.val;
        while (root != null) {
            closest = (Math.abs(root.val - target) > Math.abs(root.val - closest)) ? closest : root.val;
            if (closest == target) {
                return (int)closest;
            }
            root = target > root.val ? root.right : root.left;
        }

        return (int)closest;
    }
}
