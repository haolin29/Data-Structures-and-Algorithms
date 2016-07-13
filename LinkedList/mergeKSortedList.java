package LinkedList;

import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Haolin on 16/6/21.
 */
public class mergeKSortedList {
    public ListNode mergeKLists(List<ListNode> lists) {
        if (lists == null || lists.size() == 0) {
            return null;
        }

        return mergeHelper(lists,0,lists.size() - 1);
    }

    public ListNode mergeHelper(List<ListNode> lists, int start, int end) {
        if (start == end ) {
            return lists.get(start);
        }
        int middle = start + (end - start) / 2;
        ListNode left = mergeHelper(lists,start,middle);
        ListNode right = mergeHelper(lists,middle + 1, end);

        return mergeTwo(left,right);

    }

    public static ListNode mergeTwo(ListNode left, ListNode right) {
        ListNode dummy = new ListNode(0);

        ListNode cur = dummy;
        while (left != null && right != null) {
            if (left.val < right.val) {
                cur.next = left;
                left = left.next;
            } else {
                cur.next = right;
                right = right.next;
            }

            cur = cur.next;
        }

        if (left != null) {
            cur.next = left;
        } else {
            cur.next = right;
        }

        return dummy.next;
    }



    public ListNode mergeKSortedList(List<ListNode> lists) {
        if (lists.size() == 0) {
            return null;
        }

        ListNode dummy = new ListNode(0);


        Queue<ListNode> heap = new PriorityQueue<>(lists.size(), myComparator);
        for (int i = 0; i < lists.size(); i++) {
            if (lists.get(i) != null) {
                heap.add(lists.get(i));
            }
        }

        ListNode cur = dummy;

        while (!heap.isEmpty()) {
            ListNode node = heap.poll();
            cur.next = node;
            if (node.next != null) {
                heap.add(node.next);
            }
            cur = cur.next;
        }

        return dummy.next;
    }

    private Comparator<ListNode> myComparator = new Comparator<ListNode>() {
        @Override
        public int compare(ListNode left, ListNode right) {
            if (left == null) {
                return 1;
            } else if(right == null ) {
                return -1;
            }

            return left.val - right.val;
        }
    };

}
