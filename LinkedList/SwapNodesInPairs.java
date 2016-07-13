package LinkedList;

/**
 * Created by Haolin on 16/6/19.
 */
public class SwapNodesInPairs {
    public ListNode swapNodes(ListNode head) {
        // idea: use pre.next.next to control edge
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode pre = dummy;

        while (pre.next != null && pre.next.next != null) {
            ListNode n1 = pre.next;
            ListNode n2 = pre.next.next;
            n1.next = n2.next;
            n2.next = n1;
            pre.next = n2;

            // move the caret
            pre = n1;
        }

        return dummy.next;

    }
}
