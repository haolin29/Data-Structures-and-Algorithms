package BinaryTree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Created by Haolin on 16/9/8.
 */
public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<>();
        if(root == null) {
            return result;
        }

        int level = 0;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(root);

        while(!q.isEmpty()) {
            int size = q.size();
            List<Integer> list = new ArrayList<>();
            for(int i = 0; i < size; i++) {
                TreeNode node = q.poll();
                if(level % 2 == 1) {
                    list.add(0, node.val);
                } else {
                    list.add(node.val);
                }

                if(node.left != null) {
                    q.offer(root.left);
                }

                if(node.right != null) {
                    q.offer(root.right);
                }
            }

            result.add(list);
            level++;
        }
        return result;

    }
}
