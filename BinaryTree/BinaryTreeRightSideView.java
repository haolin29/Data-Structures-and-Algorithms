package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Haolin on 16/6/5.
 */
public class BinaryTreeRightSideView {
    public static List<Integer> rightSideView(TreeNode root) {
        List<Integer> result = new ArrayList<>();
        if (root == null) {
            return result;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int size = queue.size();

            for (int i = 0; i < size; i++) {
                TreeNode cur = queue.poll();

                if (i == (size - 1)) {
                    result.add(cur.val);
                }
                if (cur.left != null) {
                    queue.offer(cur.left);
                }
                if (cur.right != null) {
                    queue.offer(cur.right);
                }

            }
        }

        return result;

    }

    public static void main(String[] args) {
        TreeNode root = BinaryTreeSerialization.deserialize("1,2,3");
        List<Integer> result = rightSideView(root);

        for (Integer i:result) {
            System.out.println(i);
        }


    }
}
