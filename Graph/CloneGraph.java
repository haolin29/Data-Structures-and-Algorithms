package Graph;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Haolin on 16/7/3.
 */
public class CloneGraph {
    public UndirectedGraphNode cloneGraph(UndirectedGraphNode node) {
        // write your code here
        if (node == null) {
            return node;
        }

        HashMap<UndirectedGraphNode, UndirectedGraphNode> map = new HashMap<>();
        ArrayList<UndirectedGraphNode> nodes = new ArrayList<>();

        nodes.add(node);
        map.put(node, new UndirectedGraphNode(node.label));
        int start = 0;
        while  (start < nodes.size()) {
            UndirectedGraphNode curNode = nodes.get(start++);

            for (int i = 0; i < curNode.neighbors.size(); i++) {
                UndirectedGraphNode neighbor = curNode.neighbors.get(i);
                if (!map.containsKey(neighbor)) {
                    map.put(neighbor, new UndirectedGraphNode(neighbor.label));
                    nodes.add(neighbor);
                }
            }
        }

        // clone connection
        for (int i = 0; i < nodes.size(); i++) {
            UndirectedGraphNode newNode = map.get(nodes.get(i));
            for (int j = 0; j < nodes.get(i).neighbors.size(); j++) {
                newNode.neighbors.add(map.get(nodes.get(i).neighbors.get(j)));
            }


        }

        return map.get(node);
    }
}
