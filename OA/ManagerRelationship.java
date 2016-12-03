package OA;

import java.util.*;

/**
 * Created by Haolin on 2016/10/29.
 */

public class ManagerRelationship {
    static class Node {
        List<Node> children;
        String name;

        public Node(String s){
            this.name = s;
            children = new ArrayList<>();
        }
    }
    private static Set<String> root;

    public static void main(String[] args) {
        String input = "Sam->Pete,Pete->Nancy,Sam->Katie,Mary->Bob,Frank->Mary,Mary->Sam,Bob->John,Sam,John";
        String[] relations = input.split(",");
        String emp1 = relations[relations.length-2];
        String emp2 = relations[relations.length-1];
        relations = Arrays.copyOf(relations,relations.length-2);

        HashMap<String, Node> nodes = new HashMap<>();

        // built the graph
        for(String s : relations) {
            String[] emps = s.split("->");
            if(!nodes.containsKey(emps[0])) {
                nodes.put(emps[0], new Node(emps[0]));
            }
            if (!nodes.containsKey(emps[1])) {
                nodes.put(emps[1], new Node(emps[1]));
            }
            nodes.get(emps[0]).children.add(nodes.get(emps[1]));
        }

        String root = findRoot(nodes);
        Node manager = findManager(nodes.get(emp1), nodes.get(emp2), nodes.get(root));

        System.out.println(manager.name);
    }

    public static String findRoot(HashMap<String, Node> nodes) {
        HashSet<String> set = new HashSet<>();

        for(String s : nodes.keySet()) {
            for (Node node : nodes.get(s).children) {
                set.add(node.name);
            }
        }
        // find the node doesn't in the set
        for (String s : nodes.keySet()) {
            if(!set.contains(s)) {
                return s;
            }
        }
        return null;
    }

    // dfs recursive find the lowest common ancestor
    public static Node findManager(Node p1, Node p2, Node root) {
        if (p1 == root || p2 == root) {
            return root;
        }
        int count = 0;

        Node result = null;
        for (Node cur : root.children) {
            Node next = findManager(p1, p2, cur);
            if (next != null) {
                count++;
                result = next;
            }
        }
        if (count == 2) {
            return root;
        }
        return result;
    }
}
