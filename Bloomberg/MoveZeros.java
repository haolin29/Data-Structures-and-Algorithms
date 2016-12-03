package Bloomberg;

/**
 * Created by Haolin on 2016/12/2.
 */
public class MoveZeros {
    // 把所有的0移到开头
    public static void move(int[] nums) {
        // swap
        // find fist non-zero
        int i = 0, j = 0;
        while(i < nums.length && nums[i] == 0) i++;
        for (j = i + 1; j < nums.length; j++) {
            if (nums[j] == 0) {
                swap(nums, i, j);
                i++;
            }
        }
    }

    public static void swap(int[] nums, int a, int b) {
        int temp = nums[a];
        nums[a] = nums[b];
        nums[b] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {1,0,3,4,0,0,0,0,0,1,3,3};
        move(nums);
        for (int num : nums) {
            System.out.print(num + " ");
        }
    }
}
