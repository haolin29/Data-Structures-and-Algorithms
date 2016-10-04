package Test;

/**
 * Created by Haolin on 16/9/13.
 */
public class QuickSelect {

    public static int findKthSmallest(int[] nums, int k) {
        int left = 0;
        int right = nums.length - 1;
        k = k - 1;
        return quickSelect(nums, left, right, k);
    }

    public static int quickSelect(int[] nums, int left, int right, int k) {
        if(left == right) {
            return nums[left];
        }

        int pivotIndex = right;
        pivotIndex = partition(nums, left, right, pivotIndex);

        if(k == pivotIndex) {
            return nums[k];
        } else if (k < pivotIndex) {
            return quickSelect(nums, left, pivotIndex - 1, k);
        } else {
            return quickSelect(nums, pivotIndex + 1, right, k);
        }
    }

    public static int partition(int[] nums, int left, int right, int pivotIndex) {
        int pivotVal = nums[pivotIndex];
        int start = left;
        for(int i = left; i < right; i++) {
            if(nums[i] < pivotVal) {
                swap(nums, i, start);
                start++;
            }
        }
        swap(nums, right, start);
        return start;
    }

    public static void swap(int[] nums, int n1, int n2) {
        int temp = nums[n1];
        nums[n1] = nums[n2];
        nums[n2] = temp;
    }

    public static void main(String[] args) {
        int[] nums = {11111,111111,1111111,1,11,111,1111};
        int k = 3;
        System.out.println(findKthSmallest(nums, k));
    }
}
