package AZ;

import java.util.*;
/**
 * Created by Haolin on 2016/11/13.
 */
public class CityTest {
    static class Connection {
        String a, b;
        int cost;
        Connection(String a, String b, int cost) {
            this.a = a;
            this.b = b;
            this.cost = cost;
        }
    }

    // Union-Find structure
    static class UF {
        Map<String, String> map;
        UF() {
            map = new HashMap<>();
        }
        String find(String s) {
            String tmp = s;
            while (map.containsKey(tmp) && map.get(tmp) != tmp) {
                tmp = map.get(tmp);
            }
            return tmp;
        }

        void union(String a, String b) {
            String rootA = find(a), rootB = find(b);
            if (rootA != rootB) {
                map.put(rootA, rootB);
            }
        }

        boolean allConnected(String start) {
            String dest = find(start);
            for (String s : map.keySet()) {
                if (find(s) != dest) return false;
            }
            return true;
        }
    }

    public static List<Connection> getLowCost(List<Connection> connections) {
        List<Connection> result = new ArrayList<>();
        if (connections == null || connections.isEmpty()) return result;

        // Kruskal's algorithm
        Collections.sort(connections, new Comparator<Connection>(){
            public int compare(Connection a, Connection b) {
                return a.cost - b.cost;
            }
        });

        UF uf = new UF();
        for (Connection c : connections) {
            String a = c.a, b = c.b;
            if (uf.find(a) != uf.find(b)) {
                uf.union(a, b);
                result.add(c);
            }
        }

        // Check if all cities are connected
        String start = result.get(0).a;
        if (!uf.allConnected(start)) return new ArrayList<Connection>(); // OR null

        // Sort output based on name
        Collections.sort(result, new Comparator<Connection>(){
            public int compare(Connection a, Connection b) {
                if (a.a.equals(b.a)) {
                    return a.b.compareTo(b.b);
                } else {
                    return a.a.compareTo(b.a);
                }
            }
        });

        return result;
    }

    // Test
    public static void main(String[] args) {
        List<Connection> connections = new ArrayList<>(Arrays.asList(
                new Connection("A", "B", 6),
                new Connection("B", "C", 4),
                new Connection("C", "D", 5),
                new Connection("E", "F", 2),
                new Connection("E", "A", 2)
        ));

        for (Connection c : getLowCost(connections)){
            System.out.printf("%s <-> %s (%d)\n", c.a, c.b, c.cost);
        }
    }
}
