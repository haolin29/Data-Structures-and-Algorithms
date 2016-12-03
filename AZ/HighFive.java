package AZ;

import java.util.*;

/**
 * Created by Haolin on 2016/11/13.
 */

class Result{
    int id;
    int value;
    public Result(int id, int value){
        this.id = id;
        this.value = value;
    }
}

public class HighFive {
    public static Map<Integer, Double> getHighFive(Result[] results){
        if(results == null || results.length == 0) {
            return new HashMap<>();
        }

        HashMap<Integer, List<Integer>> scores = new HashMap<>();
        HashMap<Integer, Double> highFive = new HashMap<>();

        for(Result res : results) {
            if(!scores.containsKey(res.id)) {
                scores.put(res.id, new ArrayList<>());
            }
            scores.get(res.id).add(res.value);
        }

        for(int id : scores.keySet()) {
            double sum = 0.0;
            List<Integer> list = scores.get(id);
            Collections.sort(list, Collections.reverseOrder());
            for(int i = 0; i < 5; i++) {
                sum += list.get(i);
            }
            highFive.put(id, sum / 5.0);
        }

        return highFive;

    }

    public static void main(String[] args) {
        Result r1 = new Result(1, 95);
        Result r2 = new Result(1, 95);
        Result r3 = new Result(1, 91);
        Result r4 = new Result(1, 91);
        Result r5 = new Result(1, 93);
        Result r6 = new Result(1, 105);

        Result r7 = new Result(2, 6);
        Result r8 = new Result(2, 6);
        Result r9 = new Result(2, 7);
        Result r10 = new Result(2, 6);
        Result r11 = new Result(2, 6);
        Result[] arr = {r1, r2, r3, r4, r5, r6, r7, r8, r9, r10, r11};
        Map<Integer, Double> res = getHighFive(arr);

        System.out.println(res.get(1) + " " +res.get(2));
    }
}
