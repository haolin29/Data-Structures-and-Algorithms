package LinkedList;

import BinaryTree.TreeNode;
import apple.laf.JRSUIUtils;

/**
 * Created by Haolin on 16/6/21.
 */
public class CovertSortedListToBST {
    private ListNode cur;

    public TreeNode sortedListToBST(ListNode head) {
        if (head == null) {
            return null;
        }

        int n = getLength(head);

        cur = head;

        return helper(n);
    }

    public int getLength(ListNode head) {
        if (head == null) {
            return 0;
        }

        int result = 0;
        while (head != null) {
            result++;
            head = head.next;
        }
        return result;
    }

    public TreeNode helper(int size) {
        // base case
        if (size <= 0) {
            return null;
        }

        TreeNode left = helper(size / 2);
        TreeNode root = new TreeNode(cur.val);
        cur = cur.next;
        TreeNode right = helper(size - (size / 2) - 1);

        root.left = left;
        root.right = right;

        return root;

    }

}
