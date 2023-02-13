package Cisco;

public class Permutations {
    /**
     * permutation function
     *
     * @param str   string to calculate the permutation from
     * @param start start index
     * @param end   end index
     */

    public void permute(String str, int start, int end) {
        if (start == end) {
            System.out.println(str);
        } else {
            for (int i = start; i < end; i++) {
                str = swap(str, start, end);
                permute(str, start + 1, end);
                str = swap(str, start, end);
            }
        }
    }

    private String swap(String str, int start, int end) {
        char temp;
        char[] charArray = str.toCharArray();
        temp = charArray[start];
        charArray[start] = charArray[end];
        charArray[end] = temp;
        return String.valueOf(charArray);
    }

    public static void main(String[] args) {

    }

}
