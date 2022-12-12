package QuickSelect;

import java.util.Random;

public class QuickSelect {
    /* Given an integer array nums and an integer k, return the kth largest element in the array.
    * Note that it is the kth largest element in the sorted order, not the kth distinct element.
    * You must solve it in O(n) time complexity.
    * Example1: Input: nums = [3,2,1,5,6,4], k = 2
       Output: 5
    * Example2: Input: nums = [3,2,3,1,2,4,5,5,6], k = 4
       Output: 4
    * */

    static int[] nums_;

    public static void swap( int index1, int index2){
        int temp = nums_[index1];
        nums_[index1] = nums_[index2];
        nums_[index2] = temp;
    }

    private static int partition(int left, int right, int pivotIndex) {
        // step1: get the pivot
        int pivot = nums_[pivotIndex];

        // step2: put the pivot on the end
        swap(right,pivotIndex);

        int storeIndex= left;
        // step3: iterate over the array. if you find a number less than the pivot, swap its index with the store index, and advance the storeIndex
        for ( int i=left; i<=right; i++){
            if( nums_[i] < pivot){
                swap(storeIndex, i);
                storeIndex++;
            }
        }
        // step 4:  place the pivot in its sorted position. only the pivot is in a sorted position
        swap(storeIndex, right);
        return storeIndex;
    }

    public static int quickSelect( int left, int right, int k_small_value) {
        Random rand = new Random();

        int pivot = rand.nextInt(right - left) + left;

        int pivot_Index = partition( left, right, pivot);

        if( pivot_Index == k_small_value ){
            return nums_[k_small_value];
            // go left
        } else if (pivot_Index > k_small_value) {
            return quickSelect(left, pivot_Index-1, k_small_value);
        } else{
            return quickSelect(pivot_Index + 1, right, k_small_value);
        }

    }

    public static int finalKLargest( int [] nums, int K ){
        nums_ = nums;
        int size = nums_.length;
        return quickSelect(0, size-1, size - K);
    }

    public static void main ( String [] args ) {
        int nums[] = new int[] {3,2,3,1,2,4,5,5,6};

        int K = 4;
        int m = finalKLargest(nums, K);
        System.out.println(m);
    }

}
