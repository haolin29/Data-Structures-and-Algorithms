package LinkedList;

/**
 * Created by Haolin on 16/6/20.
 */
public class SwapTwoNodesInList {
    public ListNode swapNodes(ListNode head, int v1, int v2) {
        if (head == null) {
            return null;
        }

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        head = dummy;

        ListNode preV1 = null;
        ListNode preV2 = null;
        while (head.next != null) {
            if (head.next.val == v1) {
                preV1 = head;
            }

            if (head.next.val == v2) {
                preV2 = head;
            }

            head = head.next;
        }


        // if we dont find
        if (preV1 == null || preV2 == null) {
            return dummy.next;
        }

        // make sure v1 is before v2
        if (preV2.next == preV1) {
            ListNode t = preV1;
            preV1 = preV2;
            preV2 = t;
        }

        // swap nodes
        ListNode node1 = preV1.next;
        ListNode node2 = preV2.next;
        ListNode nextV2 = node2.next;
        if (preV1.next == preV2) {
            node2.next = node1;
            node1.next = nextV2;
            preV1.next = node2;
        } else {
            node2.next = node1.next;
            node1.next = nextV2;
            preV1.next = node2;
            preV2.next = node1;
        }


        return dummy.next;
    }
}
