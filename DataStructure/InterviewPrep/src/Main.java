import java.util.HashMap;
import java.util.Map;

public class Main {
    /*
    * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.

You may assume that each input would have exactly one solution, and you may not use the same element twice.

You can return the answer in any order.*/

    public static int [] find( int[] nums, int target) {
        Map<Integer,Integer> map = new HashMap<>();
//        int [] result = new int[2];
        for( int i = 0; i< nums.length; i++) {
            int temp = target - nums[i];
            if(map.containsKey(temp)){
                int indicesForTem= map.get(temp);
                return new int[]{indicesForTem, i};
            } else{
                map.put(nums[i], i);
            }

        }
        return null;
    }


    public static void main(String[] args) {
        int []nums =new int[]{2,7,11,15};
        int target = 9;
        var result = find(nums,target);
//        System.out.println(result);
        for(int x : result){
            System.out.println(x);
        }


    }
}