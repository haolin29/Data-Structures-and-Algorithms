package Search;

import java.util.*;

/**
 * Created by Haolin on 16/7/7.
 */
public class WordLadder {
    public  int ladderLength(String start, String end, Set<String> dict) {
        // write your code here
        if (dict == null) {
            return 0;
        }

        // BFS in Graph: HashSet, Queue
        HashSet<String> set = new HashSet<>();
        Queue<String> queue = new LinkedList<>();

        //dict.add(start);
        dict.add(end);

        set.add(start);
        queue.add(start);


        int length = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            length++;
            for (int i = 0; i < size; i++) {
                String word = queue.poll();
                ArrayList<String> nextWord = getNextWord(word, dict);
                for (String next : nextWord) {
                    if (next.equals(end)) {
                        return length;
                    }
                    if (!set.contains(next)) {
                        set.add(next);
                        queue.offer(next);
                    }
                }
            }
        }

        return 0;
    }

    ArrayList<String> getNextWord(String start, Set<String> dict) {
        ArrayList<String> result = new ArrayList<>();
        for (int i = 0; i < start.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                String newWord = replace(start, i, c);
                if (dict.contains(newWord)) {
                    result.add(newWord);
                }
            }
        }

        return result;
    }

    String replace(String start, int index, char c) {
        char[] chars = start.toCharArray();
        chars[index] = c;
        return new String(chars);
    }


    public static void main(String[] args) {
        String start = "hit";
        String end = "cog";
        Set<String> dict = new HashSet<>(Arrays.asList("hot","dot","dog","lot","log"));

        int result = new WordLadder().ladderLength(start, end, dict);



    }
}
