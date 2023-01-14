import java.util.*;

public class Exercises {

    public static String longestCommonPrefix(String[] strings) {
        int index = 0;
        String longestCommonPrefix = ""; // response string to be returned
        if (strings.length == 0) {
            return longestCommonPrefix;
        }

        // compare the characters in the first string with every character in other strings
        for (char c : strings[0].toCharArray()) {
            for (int i = 1; i < strings.length; i++) {
                if (index >= strings[i].length() || c != strings[i].charAt(index)) {
                    return longestCommonPrefix;
                }
            }

            longestCommonPrefix += c;
            index++;
        }

        return longestCommonPrefix;
    }

    /*
     * Given a string, return whether it uses capitalization correctly.
     * A string correctly uses capitalization if all
     * letters are capitalized, no letters are capitalized,
     * or only the first letter is capitalized.*/

    public static boolean isCapitalizationCorrect(String str) {

        if (str.length() == 0) {
            return true;
        }

        if (str.equals(str.toLowerCase())) {
            return true;
        } else if (str.equals(str.toUpperCase())) {
            return true;
        } else return str.length() > 1 &&
                Character.isUpperCase(str.charAt(0)) &&
                str.substring(1).equals(str.substring(1).toLowerCase());

    }

    public static boolean CapitalizationCorrect(String str) {
        // error check
        if (str.length() == 0) {
            return true;
        }
        // check if the first letter is capital. If it is. Check the rest of the letters are lower case.
        // if they are, return true

        if (str.charAt(0) == Character.toUpperCase(str.charAt(0))) {
            for (int i = 1; i < str.length(); i++) {
                if (!Character.isLowerCase(str.charAt(i))) {
                    return false;
                }
            }
        }
        // if the first letter is not capital. check if all letters are lower case. If yes, return true.
        // Otherwise, false example: rWANDA. output false. if it is rwanda
        else {
            for (int i = 1; i < str.length(); i++) {
                if (Character.isUpperCase(str.charAt(i))) {
                    return false;
                }
            }
        }
        return true;
    }

    /**
     * function that adds two binary strings together and return their sum
     *
     * @param firstString  first binary string
     * @param secondString second binary string
     * @return sum of two binary strings
     */
    public static String sumOfBinaryString(String firstString, String secondString) {
        //"100" + "1", return "101"
        int carry = 0;
        StringBuilder sb = new StringBuilder();
        // iterates from the back of the strings
        int i = firstString.length() - 1;
        int j = secondString.length() - 1;
        while (i >= 0 || j >= 0) {
            int sum = carry;
            // add the value of i at firsString and value of j at secondString
            if (i >= 0) {
                sum += firstString.charAt(i) - '0'; // convert to integer
                i--;
            }
            if (j >= 0) {
                sum += secondString.charAt(j) - '0';
                j--;
            }

            sb.insert(0, sum % 2); // use insert instead of append. With append, you'd have to reverse the string at the end
            carry = sum / 2;
        }
        // in case there is a carry remaining at the end of the while loop. Add it to sb

        if (carry > 0) {
            sb.insert(0, 1);
        }
        return sb.toString();
    }

    public static boolean twoSum(int[] array, int target) {
        Set<Integer> set = new HashSet<>();
        for (int j : array) {
            int compliment = target - j;
            if (set.contains(compliment)) {
                System.out.println(compliment + " + " + j);
                return true;
            }
            set.add(j);
        }
        return false;
    }

    /**
     * @param stones string representing stones
     * @param jewels string representing jewels
     * @return return the number of stones that are also jewels
     */
    public static int numOfStonesThatAreInJewels(String stones, String jewels) {
        Set<Character>set = new HashSet<>();
        for(char c : jewels.toCharArray()) {
            set.add(c);
        }
        int count = 0;
        for(char c: stones.toCharArray()) {
            if(set.contains(c)) {
                count++;
            }
        }
        return count;
    }

    public static boolean isValidAnagram(String a, String b) {
        if(a.length() != b.length()) {
            return false;
        }
        int[] charCounter = new int[26];
        for(int i = 0; i < a.length(); i++) {
            charCounter[a.charAt(i) - 'a']++;
            charCounter[b.charAt(i) - 'a']--;
        }
        for(int count : charCounter) {
            if(count != 0) {
                return false;
            }
        }
        return true;
    }

    public static int indexOfFirstUniqueCharacter(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for(int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            map.put(c, map.getOrDefault(c,0) + 1);
        }

        for(int i = 0; i < str.length(); i++) {
            if(map.containsKey(str.charAt(i)) && map.get(str.charAt(i)) == 1) {
                return i;
            }
        }
        return -1;

    }

    public static char letterAdded(String s, String t) {
        char resp = ' ';
        Set<Character> set = new HashSet<>();
        for(char c: s.toCharArray()) {
            set.add(c);
        }
        for(char c : t.toCharArray()) {
            if(!set.contains(c)) {
                resp = c;
            }
        }
        return resp;
    }

    public static void main(String[] args) {
        String name = "ide";
        String t = "idea";
        System.out.println(letterAdded(name, t));

    }
}
