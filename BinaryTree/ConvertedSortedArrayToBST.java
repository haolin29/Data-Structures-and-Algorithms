package BinaryTree;

/**
 * Created by Haolin on 16/6/5.
 */
public class ConvertedSortedArrayToBST {
    public TreeNode converted(int[] nums) {
        if (nums == null || nums.length == 0) {
            return null;
        }

        return helper(nums,0,nums.length - 1);
    }

    public TreeNode helper(int[] nums, int start, int end) {
        if (start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        TreeNode node = new TreeNode(nums[mid]);
        node.left = helper(nums,start, mid - 1);
        node.right = helper(nums, mid + 1, end);
        return node;

    }
}
