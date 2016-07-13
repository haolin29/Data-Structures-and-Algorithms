package DataStructure;

import LinkedList.ListNode;

/**
 * Created by Haolin on 16/7/1.
 */
public class ImplementQueueByLinkedList {

    ListNode dummy, head;

    public ImplementQueueByLinkedList() {
        dummy = new ListNode(0);
        head = dummy;
    }

    public void enqueue(int item) {
        // Write your code here
        head.next = new ListNode(item);
        head = head.next;

    }

    public int dequeue() {
        // Write your code here
        if (dummy.next != null) {
            int item = dummy.next.val;
            dummy.next = dummy.next.next;
            if(dummy.next == null) {  // corner case
                head = dummy;
            }
            return item;
        }
        return -1;
    }
}
