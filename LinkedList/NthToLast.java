package LinkedList;

/**
 * Created by Haolin on 16/6/20.
 */
public class NthToLast {
    public ListNode nthToLast(ListNode head, int n) {
        if (head == null) {
            return null;
        }

        ListNode cur = head;
        while (n-- != 0) {
            cur = cur.next;
        }

        ListNode node = head;
        while (cur != null) {
            node = node.next;
            cur = cur.next;
        }

        return node;
    }
}
