package LinkedList;

/**
 * Created by Haolin on 16/6/20.
 */
public class AddTwoNumbers {
    public ListNode add(ListNode l1, ListNode l2) {
        if (l1 == null && l2 == null) {
            return null;
        }

        int carry = 0;
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (l1 != null && l2 != null) {
            int sum = l1.val + l2.val + carry;

            cur.next = new ListNode(sum % 10); // mark
            carry = sum / 10;

            cur = cur.next;
            l1 = l1.next;
            l2 = l2.next;
        }


        while (l1 != null) {
            int sum = l1.val + carry;

            cur.next = new ListNode(sum % 10);
            carry = sum / 10;
            l1 = l1.next;
            cur = cur.next;
        }

        while (l2 != null) {
            int sum = l2.val + carry;

            cur.next = new ListNode(sum % 10);
            carry = sum / 10;
            l2 = l2.next;
            cur = cur.next;
        }

        if (carry != 0) {
            cur.next = new ListNode(carry);
        }

        return dummy.next;
    }
}
