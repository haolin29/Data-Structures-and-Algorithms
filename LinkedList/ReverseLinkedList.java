package LinkedList;

/**
 * Created by Haolin on 16/6/20.
 */
public class ReverseLinkedList {
    public ListNode reverse(ListNode head) {
        if (head == null) {
            return head;
        }

        ListNode pre = null;
        ListNode cur = head;

        while (cur != null) {
            ListNode post = cur.next;
            cur.next = pre;
            pre = cur;
            cur = post;

        }

        return pre;
    }

    public ListNode reverseRec(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode next = head.next;
        ListNode newHead = reverseRec(next);
        next.next = head;
        head = null;

        return newHead;
    }

    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || m >= n) {
            return head;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        for (int i = 1; i < m; i++) {
            if (head == null) {
                return null;
            }
            head = head.next;
        }

        ListNode preM = head;
        ListNode mNode = head.next;
        ListNode nNode = mNode;
        ListNode postN = nNode.next;

        for (int i = m; i < n; i++) { // 退出的时候,nNode 在n上
            if (postN == null) {
                return null;
            }

            ListNode tmp = postN.next;
            postN.next = nNode;
            nNode = postN;
            postN = tmp;

        }

        mNode.next = postN;
        preM.next = nNode;

        return dummy.next;

    }
}
