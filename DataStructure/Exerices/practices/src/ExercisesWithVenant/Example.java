package ExercisesWithVenant;

import java.util.*;

public class Example {

    public static boolean containsDuplicate(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for (int num : nums) {
            if (set.contains(num)) {
                return true;
            } else {
                set.add(num);
            }
        }
        return false;
    }

    /*
    Given a string " Java is my favorite language "
    could you write a program to count number of occurrences of each character?
     */

    public static void countCharacters (String str) {
        // key -> character and value -> occurrence
        Map<Character, Integer> map = new HashMap<>();
        String newStr = str.replace(" ", ""); // O(n)

        for (int i = 0; i < newStr.length(); i++) {
            char c = newStr.charAt(i);
            if(map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else{
                map.put(c, 1);
            }

        }
        System.out.println(map);
    }

    public static int countWords(String str) {
        String[]  arr= str.split("my");

        for(String xx : arr) {
            System.out.println(xx);
        }

        return arr.length;
    }

    public static void main(String[] args) {
        String str = "Java is  my favorite my language my ";
//        countCharacters(str);
        var x = countWords(str);
        System.out.println(x);
    }
}
