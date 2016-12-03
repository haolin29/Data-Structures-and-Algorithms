package AZ;

import java.util.*;
/**
 * Created by Haolin on 2016/11/13.
 */
public class CompanyTree {
//    static class Node {
//        int val;
//        List<Node> children;
//        public Node(int val) {
//            this.val = val;
//            children = new ArrayList<>();
//        }
//    }
//
//    static Node result;
//    static double maxAverage = Double.MIN_VALUE;
//
//    static class Wrapper {
//        int count, sum;
//        public Wrapper(int sum, int count) {
//            this.count = count;
//            this.sum = sum;
//        }
//    }
//
//    public static Node getMaxAverageSubtree(Node root) {
//        if(root == null) return null;
//        dfs(root);
//        return result;
//    }
//
//    public static Wrapper dfs(Node root) {
//        if(root.children == null || root.children.size() == 0) {
//            return new Wrapper(root.val, 1);
//        }
//
//        int subtreeSum = root.val;
//        int subtreeCount = 1;
//
//        // post-order traverse
//
//        for(Node node : root.children) {
//            Wrapper w = dfs(node);
//            subtreeSum += w.sum;
//            subtreeCount += w.count;
//        }
//
//        double subtreeAverage = (double) subtreeSum / subtreeCount;
//
//        if(subtreeAverage > maxAverage) {
//            maxAverage = subtreeAverage;
//            result = root;
//        }
//
//        return new Wrapper(subtreeSum, subtreeCount);
//    }

    static class Node {
        int val;
        List<Node> children;
        public Node(int val) {
            this.val = val;
            children = new ArrayList<>();
        }
    }

    static class Wrapper {
        int sum;
        int count;
        public Wrapper(int sum, int count) {
            this.sum = sum;
            this.count = count;
        }
    }

    public static Node findSubtree(Node root) {
        if(root == null) return null;
        // maintain the max value
        double[] max = new double[1];
        max[0] = Double.MIN_VALUE;
        Node[] result = new Node[1];
        dfs(root, max, result);
        return result[0];
    }

    // post order traverse
    public static Wrapper dfs(Node root, double[] max, Node[] result) {
        if(root.children == null || root.children.size() == 0) {
            return new Wrapper(root.val, 1);
        }

        int curSum = root.val;
        int curCount = 1;
        for(Node node : root.children) {
            Wrapper wrapper = dfs(node, max, result);
            curSum += wrapper.sum;
            curCount += wrapper.count;
        }

        double curAverage = (double) curSum / curCount;

        if (curAverage > max[0]) {
            max[0] = curAverage;
            result[0] = root;
        }

        return new Wrapper(curSum, curCount);
    }

    public static void main(String[] args) {
        Node root = new Node(1);
        Node l1 = new Node(2);
        Node l11 = new Node(3);
        Node l12 = new Node(4);
        Node l13 = new Node(5);
        Node l14 = new Node(6);
        Node l2 = new Node(7);
        Node l22 = new Node(8);
        Node l23 = new Node(9);
        Node l231 = new Node(1);
        Node l232 = new Node(2);
        Node l3 = new Node(3);
        Node l31 = new Node(4);
        Node l32 = new Node(5);

        root.children.add(l1);
        root.children.add(l2);
        root.children.add(l3);

        l1.children.add(l11);
        l1.children.add(l12);
        l1.children.add(l13);
        l1.children.add(l14);

        l2.children.add(l22);
        l2.children.add(l23);

        l23.children.add(l231);
        l23.children.add(l232);

        l3.children.add(l31);
        l3.children.add(l32);
//        Node root = new Node(1);
//        Node l21 = new Node(2);
//        Node l22 = new Node(3);
//        Node l23 = new Node(4);
//        Node l31 = new Node(5);
//        Node l32 = new Node(5);
//        Node l33 = new Node(5);
//        Node l34 = new Node(5);
//        Node l35 = new Node(5);
//        Node l36 = new Node(5);
//
//        l21.children.add(l31);
//        l21.children.add(l32);
//
//        l22.children.add(l33);
//        l22.children.add(l34);
//
//        l23.children.add(l35);
//        l23.children.add(l36);
//
//        root.children.add(l21);
//        root.children.add(l22);
//        root.children.add(l23);


        Node ans = findSubtree(root);
        System.out.println(ans.val + " ");

    }
}
