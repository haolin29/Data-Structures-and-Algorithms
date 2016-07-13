package Array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

/**
 * Created by Haolin on 16/6/23.
 */
public class IntersectionofTwoArrays {
    public static int[] intersection(int[] nums1, int[] nums2) {
//        if (nums1 == null || nums2 == null) {
//            return null;
//        }
//
//        HashMap<Integer,Integer> map = new HashMap<>();
//
//        for (int i = 0; i < nums1.length; i++) {
//            if (!map.containsKey(nums1[i])) {
//                map.put(nums1[i],0);
//            }
//        }
//
//        ArrayList<Integer> res = new ArrayList<>();
//        for (int i = 0; i < nums2.length; i++) {
//            if (map.containsKey(nums2[i])) {
//                map.put(nums2[i],map.get(nums2[i])+1);
//                if (map.get(nums2[i]) == 1) {
//                    res.add(nums2[i]);
//                }
//            }
//        }
//
//        int[] arr = new int[res.size()];
//
//        for (int i = 0; i < res.size(); i++) {
//            arr[i] = res.get(i).intValue();
//        }
//
//        return arr;

        // sort, two pointer
        Arrays.sort(nums1);
        Arrays.sort(nums2);

        int i = 0, j = 0;
        int[] tmp = new int[nums1.length > nums2.length ? nums1.length : nums2.length];
        int index = 0;
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] == nums2[j]) {
                if (index == 0 || tmp[index - 1] != nums1[i]) {
                    tmp[index++] = nums1[i];
                }
                i++;
                j++;
            } else if (nums1[i] > nums2[j]) {
                j++;
            } else {
                i++;
            }
        }

        int[] result = new int[index];
        for (int k = 0; k < index; k++) {
            result[k] = tmp[k];
        }

        return result;
    }

    public static int[] intersection2(int[] nums1, int[] nums2) {
        HashSet<Integer> set1 = new HashSet<>();

        for (int i : nums1) {
            set1.add(i);
        }

        HashSet<Integer> set2 = new HashSet<>();

        for (int i: nums2) {
            if (set1.contains(i) && !set2.contains(i)) {
                set2.add(i);
            }
        }

        int[] result = new int[set2.size()];
        int index = 0;
        for (int i : set2) {
            result[index++] = i;
        }

        return result;

    }

    public static void main(String[] args) {
        int[] nums1 = new int[]{1,2,2,1};
        int[] nums2 = new int[]{2,2};

        int[] result = intersection2(nums1,nums2);

        for (int i: result) {
            System.out.println(i);
        }

    }
}
