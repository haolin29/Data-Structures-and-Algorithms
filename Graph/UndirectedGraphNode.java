package Graph;

import java.util.ArrayList;

/**
 * Created by Haolin on 16/7/3.
 */
public class UndirectedGraphNode {
    public int label;
    public ArrayList<UndirectedGraphNode> neighbors;

    public UndirectedGraphNode (int x) {
        label = x;
        neighbors = new ArrayList<>();
    }
}
