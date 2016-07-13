package LinkedList;

/**
 * Created by Haolin on 16/6/18.
 */
public class RemoveLinkedListElements {
    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;

        ListNode pre = dummy;

        while (head != null) {
            if (val == head.val) {
                pre.next = head.next;
            } else {
                pre = head;
            }

            head = head.next;
        }

        return dummy.next;
    }
}
