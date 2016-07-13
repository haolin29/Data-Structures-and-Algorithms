package LinkedList;

/**
 * Created by Haolin on 16/6/20.
 */
public class RemoveDuplicatesFromSortedList {
    public ListNode removeDuplicates(ListNode head) {

        // key point: remove the first duplicate element
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        while (head.next != null) {
            if (head.val == head.next.val) {
                pre.next = head.next;
            } else {
                pre = pre.next;
            }

            head = head.next;
        }

        return dummy.next;
    }

    // just keep the distinct elements
    public ListNode removeDuplicatesII(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        while (head.next != null && head.next.next != null) {
            if (head.next.val == head.next.next.val ) {
                int dVal = head.next.val;
                while (head.next != null && head.next.val == dVal) {
                    head.next = head.next.next;
                }
            } else {  // mark
                head = head.next;
            }
        }

        return dummy.next;
    }
}
