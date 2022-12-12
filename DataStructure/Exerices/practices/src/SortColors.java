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

    }
}
