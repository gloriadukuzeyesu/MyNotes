import java.util.*;

public class Main {

    public static int[] findErrorNums(int[] nums) {
         int dup=0, miss =0;
        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {
            if (set.contains(num))
                dup = num;
            set.add(num);
        }

        //find missing
        for( int i=1; i<= nums.length; i++ ){
            if (!set.contains(i)) {
                miss = i;
                break;
            }
        }

        return new int[]{dup, miss};
    }

    public  static  String[] sortPeople( String [] names, int[] heights) {
        HashMap<Integer, String> map = new HashMap<>();
        for ( int i= 0; i < names.length; i++ ){
            map.put(heights[i], names[i]);
        }
        Arrays.sort(heights);

        String[] result = new String[heights.length];
        int index = 0;
        for (int i= heights.length-1; i>=0; i--) {
            result[index] = map.get(heights[i]);
        }
        return result;
    }




    public static void main(String[] args) {




        }

}