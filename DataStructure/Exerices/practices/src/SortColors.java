import java.util.HashSet;
import java.util.Set;

public class SortColors {
    public static void sortColors(int nums[]){
        int index = 0,  start = 0, end = nums.length -1;
        while ( index <= end && start < end ) {
            if( nums[index] == 0) {
                nums[index] = nums[start];
                nums[start] = 0;
                start++;
                index++;
            } else if(nums[index] == 2){
                nums[index] = nums[end];
                nums[end] = 2;
                end--;
            }else{
                index++;
            }
        }
    }
    /**
     * Write an efficient algorithm that searches for a value target in an m x n integer matrix.
     * This matrix has the following properties :
                 *  Integers in each row are sorted from left to right.
                 * The first integer of each row is greater than the last integer of the previous row.
     * @param matrix 2D array to be searched
     * @param target a value to find
     * @return true if target exists, and false if it doesn't exist
     */
    public static boolean searchAMatrix(int[][] matrix, int target) {
        // brute force would be to go over the whole matrix and find the target. However we've been told that
        // the matrix is sorted left to right and every element in each row is greater than the last interger in
        // previous row
        // hence this can be solved using binary search
        // the tricky part is to find the index and the element of the midddle element

        int rows = matrix.length;
        int colum = matrix[0].length;
        int left = 0;
        int right = (rows * colum) - 1;
        while ( left <= right) {
            int midPoint = left + (right - left) / 2; // this formula prevents integers overflow
            int midElement = matrix[midPoint / colum][midPoint % colum];
            if( target == midElement) {
                return true;
            }
            if(target > midElement) {
                // look on the right side
                left = midPoint + 1;
            }else {
                right = midPoint - 1;
            }
        }
        return false;

    }

    public static int solution (int [] A) {
        // write your code in Java SE 8
        // create a Hashset to store all elements from A
        Set<Integer> set = new HashSet<>();
        int arrayLenght = A.length;
        for(int number : A) {
            if(number > 0) {
                set.add(number);
            }
        }
        // loop through the set and find the missing min positive element in the sequence
        for(int i = 1; i < arrayLenght + 1; i++) {
            if(!set.contains(i)) {
                return i;
            }
        }
        return -1;
    }

  public static void main(String[] args) {
        int [] nums = new int[]{2,0,2,1,1,0};
      System.out.println("before Sorting");
      for(int x : nums){
          System.out.print(x + " " );
      }
      System.out.println();
        sortColors(nums);
      System.out.println("After Sorting");
      for(int x : nums){
          System.out.print(x + " ");
      }
      System.out.println();

      int[][] matrix = new int[][]
              {
              {1,3,5,7},
              {10,11,16,17},
              {23,30,34,60}
              };
      int target = 20;
   var resp = searchAMatrix(matrix ,target);
      System.out.println(resp);

    }
}
