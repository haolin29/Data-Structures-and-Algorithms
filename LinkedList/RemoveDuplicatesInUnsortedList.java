package LinkedList;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Haolin on 16/6/19.
 */
public class RemoveDuplicatesInUnsortedList {
    public ListNode removeDuplicates(ListNode head) {
//        if (head == null || head.next == null) {
//            return head;
//        }
//
//        Set<Integer> set = new HashSet<>();
//
//        ListNode dummy = new ListNode(0);
//
//        dummy.next = head;
//        ListNode pre = dummy;
//
//        while (head != null) {
//            if (set.contains(head.val)) {
//                pre.next = head.next;
//            } else {
//                set.add(head.val);
//                pre = head;
//            }
//
//            head = head.next;
//        }
//
//        return dummy.next;


        // without pre node, version 2
        // 其实就是用head.next 来代替head
        if (head == null || head.next == null) {
            return head;
        }

        Set<Integer> set = new HashSet<>();

        ListNode dummy = new ListNode(0);

        dummy.next = head;
        head = dummy;

        while (head.next != null) {
            if (set.contains(head.next.val)) {
                head.next = head.next.next;
            } else {
                set.add(head.val);
                head = head.next;
            }


        }

        return dummy.next;



    }


}
