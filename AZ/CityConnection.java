package AZ;

import java.util.*;
/**
 * Created by Haolin on 2016/11/13.
 */
public class CityConnection {
//    public static class Connection {
//        String a;
//        String b;
//        int cost;
//        public Connection(String a, String b, int cost) {
//            this.a = a;
//            this.b = b;
//            this.cost = cost;
//        }
//    }
//
//    // union find structure
//    public static class UnionFind {
//        private HashMap<String, String> map;
//        public UnionFind() {
//            map = new HashMap<>();
//        }
//
//        public String find(String s) {
//            String tmp = s;
//            while (map.containsKey(tmp) && map.get(tmp) != tmp) {
//                tmp = map.get(tmp);
//            }
//            return tmp;
//        }
//
//        public void union(String a, String b) {
//            String fa_a = find(a);
//            String fa_b = find(b);
//            if(fa_a != fa_b) {
//                map.put(fa_a, fa_b);
//            }
//        }
//
//        public boolean isAllConnected(String s) {
//            String dest = find(s);
//            for(String city : map.keySet()) {
//                if(find(city) != dest) return false;
//            }
//            return true;
//        }
//    }
//
//    public static List<Connection> getLowestCost(List<Connection> connections) {
//        List<Connection> result = new ArrayList<>();
//        if(connections == null || connections.size() == 0) {
//            return result;
//        }
//
//        // Kruskal's Minimum spanning tree algorithm
//        // sort the edges by cost in increasing order
//        Collections.sort(connections, new Comparator<Connection>() {
//            @Override
//            public int compare(Connection conn1, Connection conn2) {
//                return conn1.cost - conn2.cost;
//            }
//        });
//
//        // add the edge to union find from lowest cost to most cost
//        UnionFind uf = new UnionFind();
//        for(Connection edge : connections) {
//            String city1 = uf.find(edge.a);
//            String city2 = uf.find(edge.b);
//            if(city1 != city2) {
//                uf.union(city1, city2);
//                result.add(edge);
//            }
//        }
//
//        // check if all cities are connected
//        String city = result.get(0).a;
//        if(!uf.isAllConnected(city)) return new ArrayList<Connection>();
//
//        // sort output based on name
//        Collections.sort(result, new Comparator<Connection>() {
//            @Override
//            public int compare(Connection c1, Connection c2) {
//                if(c1.a.equals(c2.a)) {
//                    return c1.b.compareTo(c2.b);
//                } else {
//                    return c1.a.compareTo(c2.a);
//                }
//            }
//        });
//        return result;
//    }

    public static class Connection {
        String city1;
        String city2;
        int cost;

        public Connection(String a, String b, int cost) {
            city1 = a;
            city2 = b;
            this.cost = cost;
        }
    }

    public static class UnionFind {
        // key is the city, value is the set that the city belong to.
        HashMap<String, String> map;
        public UnionFind() {
            map = new HashMap<>();
        }

        public String find(String s) {
            String temp = s;
            while (map.containsKey(temp) && map.get(temp) != temp) {
                temp = map.get(temp);
            }
            return temp;
        }

        public void union(String a, String b) {
            String fa_a = find(a);
            String fa_b = find(b);
            if(fa_a != fa_b) {
                map.put(fa_a, fa_b);
            }
        }

        public boolean isAllConnected(String a) {
            String dest = find(a);
            for(String city : map.keySet()) {
                if(find(city) != dest) {
                    return false;
                }
            }
            return true;
        }
    }

    public static List<Connection> getLowestCost(List<Connection> connections) {
        // input check

        // Kruskal's algorithm
        // sort the connections by cost ascending
        Collections.sort(connections, new Comparator<Connection>() {
            @Override
            public int compare(Connection c1, Connection c2) {
                return c1.cost - c2.cost;
            }
        });

        // pick the connection that would not form a cycle and add to the result
        List<Connection> result = new ArrayList<>();
        UnionFind uf = new UnionFind();
        for(Connection conn : connections) {
            if (uf.find(conn.city1) != uf.find(conn.city2)) {
                uf.union(conn.city1, conn.city2);
                result.add(conn);
            }
        }

        // check if has a cycle
        String city = connections.get(0).city1;
        if(!uf.isAllConnected(city)) {
            return null;
        }

        // sort output based on name
        Collections.sort(result, new Comparator<Connection>(){
            @Override
            public int compare(Connection c1, Connection c2) {
                if(c1.city1.equals(c2.city1)) {
                    return c1.city2.compareTo(c2.city2);
                } else {
                    return c1.city1.compareTo(c2.city1);
                }
            }
        });

        return result;
    }

    public static void main(String[] args) {
        List<Connection> connections = new ArrayList<>(Arrays.asList(
                new Connection("A", "B", 6),
                new Connection("B", "C", 4),
                new Connection("C", "D", 5),
                new Connection("E", "F", 2),
                new Connection("E", "A", 2)
        ));

        for (Connection c : getLowestCost(connections)){
            System.out.printf("%s <-> %s (%d)\n", c.city1, c.city2, c.cost);
        }
    }
}
