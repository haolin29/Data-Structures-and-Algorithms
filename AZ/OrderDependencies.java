package AZ;

import java.util.*;
/**
 * Created by Haolin on 2016/11/13.
 */
public class OrderDependencies {
    //Order和OrderDependency都是照着面经猜测，应该是给好的class。
//    static class Order{
//        String order = "";
//        public Order(String string){
//            this.order = string;
//        }
//    }
//    static class OrderDependency{
//        Order cur;
//        Order pre;
//        public OrderDependency(Order o1, Order o2){
//            cur = o1;
//            pre = o2;
//        }
//    }
//
//    public static List<Order> getOrder(List<OrderDependency> orderDependencies){
//        List<Order> result = new ArrayList<>();
//        if(orderDependencies == null || orderDependencies.size() == 0) {
//            return result;
//        }
//        // convert the edge list to adjacent lists and calcualte the indegree
//        HashMap<Order, List<Order>> map = new HashMap<>();
//        HashMap<Order, Integer> indegree = new HashMap<>();
//
//        HashSet<Order> set = new HashSet<>();
//
//        for(OrderDependency o : orderDependencies) {
//            // skip invalid input
//            if(o.pre.order.equals(o.cur.order)) continue;
//
////            set.add(o.cur);
////            set.add(o.pre);
//            if(!map.containsKey(o.pre)) {
//                map.put(o.pre, new ArrayList<>());
//            }
//            if(!map.containsKey(o.cur)) {
//                map.put(o.cur, new ArrayList<>());
//            }
//            if(!indegree.containsKey(o.pre)) {
//                indegree.put(o.pre, 0);
//            }
//            if(!indegree.containsKey(o.cur)) {
//                indegree.put(o.cur, 0);
//            }
//
//            map.get(o.pre).add(o.cur);
//            indegree.put(o.cur, indegree.get(o.cur) + 1);
//
//        }
//
//        // BFS, find the start point
//        Queue<Order> q = new LinkedList<>();
//        for(Order o : indegree.keySet()) {
//            if(indegree.get(o) == 0) {
//                q.offer(o);
//            }
//        }
//
//        while(!q.isEmpty()) {
//            Order order = q.poll();
//            result.add(order);
//
//            for(Order child : map.get(order)) {
//                indegree.put(child, indegree.get(child) - 1);
//                if(indegree.get(child) == 0) {
//                    q.offer(child);
//                }
//            }
//        }
//
//        //if(result.size() != set.size()) return new ArrayList<Order>();
//        for(int count : indegree.values()) {
//            if(count > 0) {
//                System.out.println("There isn't exist topological order");
//                return new ArrayList<>();
//            }
//        }
//
//        return result;
//    }

    static class Order {
        String order = "";
        public Order(String s) {
            order = s;
        }
    }

    static class OrderDependency {
        Order cur;
        Order pre;
        public OrderDependency(Order cur, Order pre) {
            this.cur = cur;
            this.pre = pre;
        }
    }

    public static List<Order> getOrderDependency(List<OrderDependency> orderDependencies) {
        // input check
        // ...

        HashMap<Order, List<Order>> map = new HashMap<>();
        HashMap<Order, Integer> indegree = new HashMap<>();

        // convert graph representation from the edge list to adjacent list
        for (OrderDependency od : orderDependencies) {
            if(od.pre.order.equals(od.cur.order)) continue;
            if (!map.containsKey(od.cur)) {
                map.put(od.cur, new ArrayList<>());
            }
            if (!map.containsKey(od.pre)) {
                map.put(od.pre, new ArrayList<>());
            }
            map.get(od.pre).add(od.cur);

            if(!indegree.containsKey(od.cur)) {
                indegree.put(od.cur, 1);
            } else {
                indegree.put(od.cur, indegree.get(od.cur) + 1);
            }
            // we need to find the start point
            if(!indegree.containsKey(od.pre)) {
                indegree.put(od.cur, 0);
            }
        }

        // start bfs
        Queue<Order> q = new LinkedList<>();

        // put the order that indegree == 0 in queue
        for(Order order : indegree.keySet()) {
            if(indegree.get(order) == 0) {
                q.offer(order);
            }
        }

        // BFS find next Order
        List<Order> result = new ArrayList<>();
        while (!q.isEmpty()) {
            Order cur = q.poll();
            result.add(cur);
            for(Order next : map.get(cur)) {
                // update indegree
                indegree.put(next, indegree.get(next) - 1);
                if(indegree.get(next) == 0) {
                    q.offer(next);
                }
            }
        }

        // check if there is a cycle
        for (int num : indegree.values()) {
            if(num > 0) {
                return new ArrayList<Order>();
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Order o1 = new Order("A");
        Order o2 = new Order("B");
        Order o3 = new Order("C");
        Order o4 = new Order("D");
        OrderDependency od1 = new OrderDependency(o1, o2);
        OrderDependency od2 = new OrderDependency(o2, o3);
        //成环的情况就是把o4，改成o2，看看输出。
        OrderDependency od3 = new OrderDependency(o3, o4);
        List<OrderDependency> list = new ArrayList<>();
        list.add(od1);
        list.add(od2);
        list.add(od3);

        for (Order o : getOrderDependency(list)){
            System.out.println(o.order);
        }
    }
}

