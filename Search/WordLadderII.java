package Search;

import java.util.*;

/**
 * Created by Haolin on 16/7/7.
 */
public class WordLadderII {
    public List<List<String>> findLadders(String start, String end, Set<String> dict) {
        // write your code here
        // find all shortest path
        // bfs find the shortest path
        // dfs follow the shortest path
        List<List<String>> ladders = new ArrayList<>();
        HashMap<String, ArrayList<String>> map = new HashMap<>();
        HashMap<String, Integer> distance = new HashMap<>();

        dict.add(start);
        dict.add(end);
        // find the shortest path
        bfs(start, end, dict, map, distance);

        ArrayList<String> path = new ArrayList<>();
        dfs(end, start, map, distance, path, ladders);

        return ladders;
    }

    public void bfs(String start, String end, Set<String> dict,
                    HashMap<String, ArrayList<String>> map, HashMap<String, Integer> distance) {
        Queue<String> q = new LinkedList<>();
        q.offer(start);
        distance.put(start, 0);
        for (String s: dict) {
            map.put(s, new ArrayList<String>());
        }

        // 两层循环就可以了,因为不需要区分层数,只是记录位置和距离
        while (!q.isEmpty()) {
            String word = q.poll();
            List<String> nextList = getNextWord(word, dict);
            for (String next : nextList) {
                map.get(next).add(word);
                if (!distance.containsKey(next)) {
                    distance.put(next, distance.get(word) + 1);
                    q.offer(next);
                }

            }
        }

    }

    public List<String> getNextWord(String word, Set<String> dict) {
        List<String> result = new ArrayList<>();

        for (int i = 0; i < word.length(); i++) {
            for (char c = 'a'; c <= 'z'; c++) {
                String newWord = replace(word, i, c);
                if (dict.contains(newWord)) {
                    result.add(newWord);
                }
            }
        }

        return result;
    }

    public String replace(String word, int i, char c) {
        char[] chars = word.toCharArray();
        chars[i] = c;
        return new String(chars);
    }

    public void dfs(String current, String start,
                    HashMap<String, ArrayList<String>> map, HashMap<String, Integer> distance,
                    ArrayList<String> path, List<List<String>> ladders) {
        path.add(current);
        // base case
        if (current.equals(start)) {
            Collections.reverse(path);
            ladders.add(new ArrayList<>(path));
            Collections.reverse(path);
            return;
        } else {
            for (String next : map.get(current)) {
                if (distance.containsKey(next) && distance.get(current) == distance.get(next) + 1) {
                    dfs(next, start, map, distance, path, ladders);
                }
            }
        }
        path.remove(path.size() - 1);
    }
}
