import java.util.Arrays;

public class Main {

    public static int largestPerimeter(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;
        for ( int i= n-1; i>1; i-- )
        {
            if ( (nums[i-2] + nums[i-1]) > nums[i] )
                return nums[i-2] + nums[i-1] + nums[i];
        }
        return 0;
    }

    public static void main(String[] args) {
        int [] numbers = new int[] { 2, 1,1};
        int [] nums  = new int[] {3,2,3,4,6,1};

        int answer = largestPerimeter(numbers);
        int resp = largestPerimeter(nums);

        System.out.println(answer);
        System.out.println(resp);

    }
}