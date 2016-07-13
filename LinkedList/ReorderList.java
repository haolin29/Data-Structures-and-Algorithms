package LinkedList;

/**
 * Created by Haolin on 16/6/21.
 */
public class ReorderList {
    public void reorderList(ListNode head) {
        if (head == null || head.next == null) {
            return;
        }

        ListNode middle = findMiddle(head);

        ListNode newHead = reverse(middle.next);
        middle.next = null;

        merge(head,newHead);
    }

    public ListNode findMiddle(ListNode head) {
        ListNode slow = head, fast = head.next; // mark: 找中点

        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        return slow;
    }

    public ListNode reverse(ListNode head) {
        ListNode pre = null;

        while(head != null) {
            ListNode post = head.next;
            head.next = pre;
            pre = head;
            head = post;
        }

        return pre;
    }

    public void merge(ListNode p1, ListNode p2) {
        ListNode dummy = new ListNode(0);
        int index = 0;
        while (p1 != null && p2 != null) {
            if (index % 2 == 0) {
                dummy.next = p1;
                p1 = p1.next;
            } else {
                dummy.next = p2;
                p2 = p2.next;
            }

            dummy = dummy.next;
            index++;

        }


        if (p1 != null) {
            dummy.next = p1;
        } else {
            dummy.next = p2;
        }

    }


}
