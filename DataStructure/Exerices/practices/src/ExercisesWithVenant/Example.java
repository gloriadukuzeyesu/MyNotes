package ExercisesWithVenant;

import java.util.HashSet;
import java.util.Set;

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

    public static void main(String[] args) {
        int [] nums = new int[] {1,2,3,4,1};
        var resp = containsDuplicate(nums);
        System.out.println(resp);
    }
}
