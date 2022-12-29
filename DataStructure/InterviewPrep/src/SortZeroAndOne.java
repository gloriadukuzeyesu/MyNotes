public class SortZeroAndOne {
    // 1,1,0,0,1,0
    // 0,0,0,1,1,1
    // loop over, find how many zeros we have
    // insert the zeros from 0 position of array to the number of zeros
    // insert  1 from k + 1 to N,

    public static int [] sortZeroAndOne(int []nums) {
        // count the zeros present in the array
        int zeroCount = 0;
        for( int x : nums) {
            if (x == 0) {
                zeroCount ++; // 2
            }
        }
        // insert the 0 from the 0th position to zeroCount
        int insertIndex = 0;
        for(int i = 0; i < zeroCount; i++) {
            nums[insertIndex] = 0;
            insertIndex ++; // 2
        }
        // insert 1s to from insertIndex to the nums length
        for( int j = insertIndex; j < nums.length; j++) {
            nums[j] = 1;
        }
        return nums;
    }

    public static void sortNumbers(int [] nums) {
        int N = nums.length;
        int indexToInsetZero = 0;
        for ( int i = 0 ; i < N; i++) {
            if( nums[i] == 0) {
                nums[indexToInsetZero] = 0;
                indexToInsetZero ++;
            }
            nums[i] = 1;
        }
    }

    public static void main(String[] arg) {
        int [] nums = new int[] {1,1,0,0,1,1};
        int [] response = sortZeroAndOne(nums);
        for( int x : response) {
            System.out.print(x + " ");
        }
        System.out.println();

        int [] array = new int[] {1,1,0,0,1,1};
        sortNumbers(array);
        for( int x : array) {
            System.out.print(x + " ");
        }
    }
}
