package Array;

/**
 * Created by Haolin on 16/6/25.
 */
public class PartitionArray {
    public static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    public static int partitionArray(int[] nums, int k) {
        // how to handle corner case ?
        // if all numbers smaller than k

        if (nums == null || nums.length == 0) {
            return 0;
        }

        int start = 0;
        int end = nums.length - 1;

        while (true) {
            while (start < end && nums[start] < k) {
                start++;
            }
            while (start < end && nums[end] >= k) {
                end--;
            }

            if (start == end) break; // mark

            swap(nums, start, end);

        }

        // 单独讨论start或者end没有动过的情况，start没有动过的情况还是return start, end没有动过的情况return end+1
        if (end == nums.length - 1 && nums[end] < k) return end + 1;
        return start;


    }

    public static void main(String[] args) {
        int[] nums = new int[]{7,7,9,8,6,6,8,7,9,8,6,6};
        int result = partitionArray(nums, 10);
    }

}
