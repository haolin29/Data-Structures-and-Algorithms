package DataStructure;

import java.util.PriorityQueue;

/**
 * Created by Haolin on 16/7/1.
 */
class DequeNode {
    int val;
    DequeNode next,prev;

    public DequeNode(int val) {
        this.val = val;
        this.next = this.prev = null;
    }
}

public class ImplementQueueByLinkedListII {
    DequeNode first,last;

    public ImplementQueueByLinkedListII() {
        first = last = null;
    }

    public void push_front(int item) {
        // Write your code here
        if (first == null) {
            first = new DequeNode(item);
            last = first;
        } else {
            DequeNode temp = new DequeNode(item);
            first.prev = temp;
            temp.next = first;
            first = first.prev;
        }
    }


    public void push_back(int item) {
        // Write your code here
        if (last == null) {
            last = new DequeNode(item);
            first = last;
        } else {
            DequeNode temp = new DequeNode(item);
            last.next = temp;
            temp.prev = last;
            last = last.next;
        }
    }

    public int pop_front() {
        // Write your code here
        if (first != null) {
            int val = first.val;
            first = first.next;
            if (first == null) {
                last = first;
            } else {
                first.prev = null;
            }

            return val;
        }

        return -1;
    }

    public int pop_back() {
        // Write your code here
        if (last != null) {
            int val = last.val;
            last = last.prev;
            if (last == null) {
                first = last;
            } else {
                last.next = null;
            }

            return val;
        }

        return -1;
    }

    public static void main(String[] args) {
        ImplementQueueByLinkedListII test = new ImplementQueueByLinkedListII();
        test.push_front(1);
        test.push_back(2);
        test.pop_back();
        test.pop_back();
        test.push_back(3);
        test.push_back(4);
        test.pop_front();
        test.pop_front();
    }
}
