package LinkedList;

/**
 * Created by Haolin on 16/6/19.
 */
public class InsertionList {
    public ListNode insertionSort(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummy = new ListNode(0);

        // put the node after head insert to dummy
        while (head != null) {
            ListNode next = head.next;
            ListNode cur = dummy;
            while (cur.next != null && cur.next.val < head.val) {
                cur = cur.next;
            }
            head.next = cur.next;
            cur.next = head;
            head = next;
        }
        return dummy.next;
    }
}
