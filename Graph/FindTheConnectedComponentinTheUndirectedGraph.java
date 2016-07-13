package Graph;

import java.util.*;

/**
 * Created by Haolin on 16/7/6.
 */
public class FindTheConnectedComponentinTheUndirectedGraph {
    public List<List<Integer>> connectedSet(ArrayList<UndirectedGraphNode> nodes) {
        // Write your code here
        List<List<Integer>> result = new ArrayList<>();
        HashSet<UndirectedGraphNode> set = new HashSet<>();

        for (UndirectedGraphNode node : nodes) {
            if (!set.contains(node)) {
                BFSHelper(node, set, result);
            }
        }

        return result;

    }

    public void BFSHelper(UndirectedGraphNode node, HashSet<UndirectedGraphNode> set, List<List<Integer>> result) {
        List<Integer> connected = new ArrayList<>();
        Queue<UndirectedGraphNode> q = new LinkedList<>();

        q.offer(node);
        set.add(node);
        while (!q.isEmpty()) {
            UndirectedGraphNode temp = q.poll();
            connected.add(temp.label);
            for (UndirectedGraphNode n : temp.neighbors) {
                if (!set.contains(n)) {
                    q.offer(n);
                    set.add(n);
                }
            }
        }
        Collections.sort(connected);
        result.add(connected);

    }
}
