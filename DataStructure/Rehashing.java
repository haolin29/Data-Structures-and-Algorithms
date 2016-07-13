package DataStructure;

import LinkedList.ListNode;

/**
 * Created by Haolin on 16/6/30.
 */
public class Rehashing {
    public ListNode[] rehashing(ListNode[] hashTable) {
        if (hashTable == null || hashTable.length == 0) {
            return hashTable;
        }
        int capacity = hashTable.length * 2;

        ListNode[] res = new ListNode[capacity];
        for (int i = 0; i < hashTable.length; i++) {
            while (hashTable[i] != null) {
                int newIndex = (hashTable[i].val % capacity + capacity) % capacity;
                if (res[newIndex] == null) {
                    res[newIndex] = new ListNode(hashTable[i].val);
                } else {
                    ListNode head = res[newIndex];
                    while (head.next != null) {
                        head = head.next;
                    }

                    head.next = new ListNode(hashTable[i].val);
                }
                hashTable[i] = hashTable[i].next;
            }
        }

        return res;
    }
}
