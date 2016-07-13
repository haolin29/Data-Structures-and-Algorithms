package LinkedList;

/**
 * Created by Haolin on 16/6/22.
 */
public class SortList {

    // key point: base case
    public ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null) { // basecase: one node
            return head;
        }

        ListNode mid = findMid(head);

        ListNode right = mergeSort(mid.next);
        mid.next = null; // downsizing
        ListNode left = mergeSort(head);

        return mergeKSortedList.mergeTwo(left,right);

    }

    public ListNode findMid(ListNode head){
        ListNode fast = head.next, slow = head;

        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }

        return slow;
    }



}
