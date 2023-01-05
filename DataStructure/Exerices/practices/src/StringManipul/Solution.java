package StringManipul;

import java.util.HashSet;
import java.util.Set;

public class Solution {
    /**
     * @param word a string to check if it is a valid palindrome
     * @return true, if it is a Palindrome or false if it is not
     */

    public static boolean isValidPalindrome (String word) {
        if(word.isEmpty()) {
            return true;
        }
        int forwards = 0;
        int backwards = word.length() - 1;

        while (forwards < backwards) {
            // move forward pointer if it points to non-alphabetical characters
            if (!Character.isLetterOrDigit(word.charAt(forwards))) {
                forwards++;
            }
            // move backward pointer if it points to the non-alphabetical characters
            if (!Character.isLetterOrDigit(word.charAt(backwards))) {
                backwards--;
            }

            if (Character.toLowerCase(word.charAt(forwards)) != Character.toLowerCase(word.charAt(backwards))) {
                return false;
            }
            forwards++;
            backwards--;
        }

       return true;
    }

    public static boolean tripletSum(int [] array, int sum) {
        if( array.length < 3) {
            return false;
        }

        Set<Integer> set = new HashSet<>();

        int index = 0;
        while ( index < array.length) {
            int first = array[index];
            for (int currentValue : array) {
                int temp = sum - (currentValue + first);
                if (set.contains(temp)) {
                    System.out.println(first + " " + temp + " " + currentValue);
                    return true;
                }
                else{
                    set.add(currentValue);
                }

            }
            index++;
        }
        return false;
    }

    public static void main(String[] args) {
//        var resp = isValidPalindrome("A man, a plan, a canal: Panama.");
//        var resp2 = isValidPalindrome("leveL");
//        System.out.println(resp + " " + resp2);

        int[] arr = new int[] {1,2,6};
        int sum = 9;
        var response = tripletSum(arr, sum);
        System.out.println(response);
    }
}
