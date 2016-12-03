package Bloomberg;

import java.util.HashMap;

/**
 * Created by Haolin on 2016/12/2.
 */
public class LRUCache {
    class Node {
        int key;
        int value;
        Node prev;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
        }
    }

    private HashMap<Integer, Node> map = new HashMap<>();
    // least used node
    private Node dummyHead = new Node(-1, -1);
    // most used node
    private Node dummyTail = new Node(-1, -1);
    private int capacity;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        dummyHead.next = dummyTail;
        dummyTail.prev = dummyHead;
    }

    public int get(int key) {
        if (!map.containsKey(key)) {
            return -1;
        }

        Node cur = map.get(key);

        // move the node to tail
        if (cur.next != dummyTail) {
            // disjoint from linkedlist
            cur.next.prev = cur.prev;
            cur.prev.next = cur.next;
            moveToTail(cur);
        }

        return cur.value;
    }

    public void moveToTail(Node node) {
        // connect four pointer
        node.next = dummyTail;
        node.prev = dummyTail.prev;
        node.prev.next = node;
        dummyTail.prev = node;
    }

    public void set(int key, int value) {
        // have to update hashmap
        if (get(key) != -1) {
            map.get(key).value = value;
            return;
        }

        // before add new node, need to check the capacity
        if (map.size() == capacity) {
            // remove first
            dummyHead.next = dummyHead.next.next;
            dummyHead.next.prev = dummyHead;
            // update map
            map.remove(key);
        }

        Node newNode = new Node(key, value);
        moveToTail(newNode);
        // update hashmap
        map.put(key, newNode);
    }

}
