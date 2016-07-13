package LinkedList;

import java.util.HashMap;

/**
 * Created by Haolin on 16/6/21.
 */
public class CopyListWithRandomPointer {
//    public RandomListNode copy(RandomListNode head) {
//        // key point: what is deep copy
//        // what is the hard part of the question?
//        // what is check point?
//
//        // deep copy
//        HashMap<RandomListNode,RandomListNode> map = new HashMap<>();
//
//        if (head == null) {
//            return null;
//        }
//
//        RandomListNode dummy = new RandomListNode(0);
//        dummy.next = head;
//
//        while (head != null) {
//            RandomListNode node = new RandomListNode(head.label);
//            map.put(head,node);
//            head = head.next;
//
//        }
//        head = dummy.next;
//        while (head != null) {
//            RandomListNode newHead = map.get(head);
//            newHead.next = map.get(head.next);
//            newHead.random = map.get(head.random);
//            head = head.next;
//        }
//
//        return map.get(dummy.next);
//    }

    // no hashmap
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        copyNext(head);
        copyRandom(head);

        return splitList(head);
    }

    public void copyNext(RandomListNode head) {
        while (head != null) {
            RandomListNode newNode = new RandomListNode(head.label);
            newNode.random = head.random;
            newNode.next = head.next;
            head.next = newNode;
            head = head.next.next;
        }
    }

    public void copyRandom(RandomListNode head) {
        while (head != null) {
            if (head.next.random != null) {
                head.next.random = head.random.next;
            }
            head = head.next.next;
        }
    }

    public RandomListNode splitList(RandomListNode head) {
        RandomListNode newHead = head.next;

        while (head != null) {
            RandomListNode next = head.next;
            head.next = head.next.next;
            head = head.next;
            if (next.next != null) {
                next.next = next.next.next;
            }
        }

        return newHead;
    }
}
