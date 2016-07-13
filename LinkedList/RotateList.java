package LinkedList;

/**
 * Created by Haolin on 16/6/20.
 */
public class RotateList {
    public ListNode rotate(ListNode head, int k) {
        if (head == null) {
            return head;
        }

        int len = getLength(head);
        k = k % len;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        ListNode pre = dummy;
        while (k-- != 0) {
            head = head.next;
        }

        while (head.next != null) {
            head = head.next;
            pre = pre.next;
        }

        head.next = dummy.next;
        dummy.next = pre.next;
        pre.next = null;

        return dummy.next;


    }

    public int getLength(ListNode head) {
        int n = 0;
        while (head != null) {
            n++;
            head = head.next;
        }

        return n;
    }
}
