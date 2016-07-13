package LinkedList;

/**
 * Created by Haolin on 16/6/20.
 */
public class PartitionList {
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }

        // two dummy note
        ListNode leftDummy = new ListNode(0);
        ListNode rightDummy = new ListNode(0);

        ListNode left = leftDummy, right = rightDummy;

        while (head != null) {
            if (head.val < x) {
                left.next = head;
                left = left.next;
            } else {
                right.next = head;
                right = right.next;
            }

            head = head.next;
        }

        left.next = rightDummy.next;
        right.next = null;

        return leftDummy.next;
    }
}
