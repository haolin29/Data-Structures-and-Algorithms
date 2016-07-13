package Search;

import Graph.UndirectedGraphNode;

import java.util.*;

/**
 * Created by Haolin on 16/7/7.
 */
public class SixDegrees {
    public int sixDegrees(List<UndirectedGraphNode> graph, UndirectedGraphNode s, UndirectedGraphNode t) {
        if (graph == null) {
            return -1;
        }

        if (s == t) {
            return 0;
        }


        HashMap<UndirectedGraphNode, Boolean> hash = new HashMap<>();
        for (UndirectedGraphNode node: graph) {
            hash.put(node, false);
        }

        Queue<UndirectedGraphNode> q = new LinkedList<>();

        q.offer(s);
        hash.put(s, true);

        int length  = 0;

        while (!q.isEmpty()) {
            length++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                UndirectedGraphNode current = q.poll();

                for (UndirectedGraphNode neighbor : current.neighbors) {
                    if (neighbor.equals(t)) {
                        return length;
                    }
                    if (!hash.get(neighbor)) {
                        q.offer(neighbor);
                        hash.put(neighbor, true);
                    }


                }
            }
        }

        return -1;

    }

}
