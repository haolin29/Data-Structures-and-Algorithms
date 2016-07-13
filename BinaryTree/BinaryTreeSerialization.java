package BinaryTree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Created by Haolin on 16/6/4.
 */
public class BinaryTreeSerialization {
    public static String serialize(TreeNode root) {
        if (root == null) {
            return "";
        }

        Queue<TreeNode> queue = new LinkedList<>();
        StringBuilder sb = new StringBuilder();
        queue.offer(root);

        while (!queue.isEmpty()) {
            TreeNode cur = queue.poll();
            if (cur == null) {
                sb.append("#,");
                continue;
            }
            sb.append(cur.val + ",");
            queue.offer(cur.left);
            queue.offer(cur.right);

        }

        return sb.substring(0,sb.length() - 1);

    }

    public static TreeNode deserialize(String data) {
        if (data.equals("") || data.length() == 0) {
            return null;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        String[] nodes = data.split(",");
        TreeNode root = new TreeNode(Integer.parseInt(nodes[0]));
        queue.offer(root);

        for (int i = 1; i < nodes.length; i++) {
            TreeNode cur = queue.poll();
            if (!nodes[i].equals("#")) {
                TreeNode left = new TreeNode(Integer.parseInt(nodes[i]));
                cur.left = left;
                queue.add(left);
            }

            if (!nodes[++i].equals("#")) {
                TreeNode right = new TreeNode(Integer.parseInt(nodes[i]));
                cur.right = right;
                queue.add(right);
            }
        }

        return root;


    }

    public static void main(String[] args) {
        String data = "2,1,3,4,5,6,7";

        String output = serialize(deserialize(data));

        System.out.println(output);

    }


}
