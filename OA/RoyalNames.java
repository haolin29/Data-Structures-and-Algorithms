package OA;

import java.util.*;

/**
 * Created by Haolin on 16/9/8.
 */
public class RoyalNames {
    static class Person {
        String name;
        int num;
        Person(String name, int num) {
            this.name = name;
            this.num = num;
        }
    }

    static String[] getSortedList(String[] names) {
        if(names.length < 2) {
            return names;
        }

        List<Person> persons = new ArrayList<>();
        HashMap<Person, String> map = new HashMap<>();
        String[] result = new String[names.length];

        for(String name : names) {
            String[] split = name.split(" ");
            int order = romanToInt(split[1]);
            Person person = new Person(split[0], order);
            map.put(person, name);
            persons.add(person);
        }

        // sort persons
        Collections.sort(persons, new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                if(p1.name.equals(p2.name)) {
                    return p1.num - p2.num;
                } else {
                    return p1.name.compareTo(p2.name);
                }
            }
        });

        for(int i = 0; i < names.length; i++) {
            result[i] = map.get(persons.get(i));
        }

        return result;


    }

    private static int romanToInt(String s) {
        HashMap<Character, Integer> map = new HashMap<>();

        map.put('I',1);
        map.put('V',5);
        map.put('X',10);
        map.put('L',50);
        map.put('C',100);
        map.put('D',500);
        map.put('M',1000);

        if(s == null || s.length() == 0) {
            return 0;
        }

        int result = 0;
        for(int i = s.length() - 1; i >= 0; i--) {
            char c = s.charAt(i);

            if(i != s.length() - 1 &&  map.get(c) < map.get(s.charAt(i + 1)) ) {
                result -= map.get(c);
            } else {
                result += map.get(c);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        String[] arr = {"Pound IV", "Pound III", "Louis IX", "Louis VIII"};

        String[] sortedList = getSortedList(arr);

        System.out.println(Arrays.toString(sortedList));
    }

}
