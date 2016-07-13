package DataStructure;

import java.util.*;

/**
 * Created by Haolin on 16/7/2.
 */
class Element {
    int val,col,row;

    Element(int v, int r, int c) {

        this.val = v;
        this.row = r;
        this.col = c;

    }
}

public class MergeKSortedArrays {

    static Comparator<Element> myComparator = new Comparator<Element>() {
        @Override
        public int compare(Element e1, Element e2) {
            return e1.val - e2.val;
        }
    };

    public static List<Integer> mergekSortedArrays(int[][] arrays) {
        // Write your code here
        List<Integer> result = new ArrayList<>();
        if (arrays == null || arrays.length == 0 || arrays[0].length == 0) {
            return result;
        }


        Queue<Element> heap = new PriorityQueue<>(arrays.length, myComparator);

        for (int i = 0; i < arrays.length; i++) {
            if (arrays[i].length > 0) {
                Element element = new Element(arrays[i][0], i , 0);
                heap.offer(element);
            }
        }

        while (!heap.isEmpty()) {
            Element elem = heap.poll();
            result.add(elem.val);
            if (elem.col + 1 < arrays[elem.row].length) {
                elem.col++;
                elem.val = arrays[elem.row][elem.col];
                heap.offer(elem);
            }
        }

        return result;



    }

    public static void main(String[] args) {
        int[][] A = new int[][]{{1,3,5,7},{2,4,6},{0,8,9,10,11}};
        List<Integer> result = mergekSortedArrays(A);
        for (int i : result) {
            System.out.println(i);
        }

    }
}
