package LinkedList;

/**
 * Created by Haolin on 16/6/20.
 */
public class ListCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) {
            return false;
        }

        ListNode fast = head.next, slow = head; // cannot at the same starting point

        while (fast.next != null && fast.next.next != null) {
            if (fast == slow) {
                return true;
            }

            fast = fast.next.next;
            slow = slow.next;
        }

        return false;
    }

    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }


        ListNode slow = head, fast = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;

            if (fast == slow) {
                slow = head;
                while (fast != slow) {
                    fast = fast.next;
                    slow = slow.next;
                }
                return slow;
            }
        }

        return null;
    }
}
