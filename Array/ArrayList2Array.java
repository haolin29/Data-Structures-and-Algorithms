package Array;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Haolin on 2016/10/8.
 */
public class ArrayList2Array {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        Object[] arr;
        arr = list.toArray();
    }
}
