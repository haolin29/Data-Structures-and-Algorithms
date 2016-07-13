package DataStructure;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

/**
 * Created by Haolin on 16/7/2.
 */
public class TopKLargestNumbers {
    Comparator<Integer> myComparator = new Comparator<Integer>() {
        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        }
    };
    public int[] topk(int[] nums, int k) {
        // Write your code here
        if (nums == null || nums.length == 0 || nums.length < k) {
            return nums;
        }

        int[] topK = new int[k];
        Queue<Integer> heap = new PriorityQueue<>(nums.length, myComparator);

        for (int num : nums) {
            heap.offer(num);
        }

        for (int i = 0; i < k; i++) {
            topK[i] = heap.poll();
        }

        return topK;
    }
}
