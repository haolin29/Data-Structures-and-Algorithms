package Bloomberg;

import java.util.*;

/**
 * Created by Haolin on 2016/11/29.
 */
public class VerticalArray {
    public static List<Integer> vertical(Integer[][] array) {
        // use a iterator queue
        Queue<Iterator<Integer>> q = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            q.offer(Arrays.asList(array[i]).iterator());
        }

        List<Integer> result = new ArrayList<>();
        // poll out one element, if it has next, put back to queue
        while (!q.isEmpty()) {
            Iterator<Integer> temp = q.poll();
            if (temp.hasNext()) {
                result.add(temp.next());
                q.offer(temp);
            }

        }

        return result;
    }

    public static void main(String[] args) {
        Integer[][] array = {
                {1,1,1,},
                {2},
                {3,3},
                {4,4,4,4,4}
        };

        for (int i : vertical(array)) {
            System.out.println(i);
        }
    }
}
