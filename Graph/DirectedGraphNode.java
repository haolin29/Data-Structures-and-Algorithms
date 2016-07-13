package Graph;

import java.util.ArrayList;

/**
 * Created by Haolin on 16/7/6.
 */
public class DirectedGraphNode {
    int label;
    ArrayList<DirectedGraphNode> neighbors;
    DirectedGraphNode(int x) {
        label = x;
        neighbors = new ArrayList<DirectedGraphNode>();
    }
}
