package LinkedList;

/**
 * Created by Haolin on 16/6/20.
 */
public class RemoveNthNodeFromEndOfList {
    public ListNode removeNth(ListNode head, int n) {
        if (head == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;
        head = dummy;

        while (n-- != 0) {
            head = head.next;
        }

        while (head.next != null) {
            pre = pre.next;
            head = head.next;
        }
        if (pre.next.next != null) {
            pre.next = pre.next.next;
        }

        return dummy.next;

    }
}
