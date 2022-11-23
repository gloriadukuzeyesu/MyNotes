import java.util.Arrays;

public class Main {

    public static int nearestValidPoint( int x, int y, int[][] points) {
        int minValue = Integer.MAX_VALUE;
        int index = -1;
        for (int i=0; i<points.length; i++ ){
            if ( x == points[i][0] || y == points[i][1]) {
                int distance = Math.abs(x - points[i][0]) + Math.abs(y - points[i][1]);

                if ( distance < minValue) {
                    minValue = distance;
//                    System.out.println("distance is " + distance);
//                    System.out.println("minValue is " + minValue);
                    index = i;
                }
            }
        }
        return index;
    }

    public  static  int arraySign ( int [] nums ) {
        int arrSing = 1;

        for (int i=0; i<nums.length; i++)
        {
            if( nums [i]== 0)
            {
                return 0;
            }
            else if(nums[i] < 0)
            {
                arrSing=-arrSing;
            }
        }
        return arrSing;
    }


    public  static  boolean canMakeArithmeticProgression ( int [] arr )
    {
        Arrays.sort(arr);
        int difference = arr[1] - arr[0];

        for ( int i =1; i < arr.length; i ++)
        {
            if ( arr[i]- arr[i-1] != difference)
            {
                return  false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int x = 3;
        int y = 4;

        int [] [] points = new int[] [] { {1,2},{3,1}, {2,4},{2, 3},{4,4}};
        int [] [] mypoint = new int[][] { {3,4}, {2,3} };
        int [] [] point = new int [] [] { { 2,3} };

        int resp = nearestValidPoint(x, y, points);
        int resp1 = nearestValidPoint(x, y, mypoint);
        int resp2 = nearestValidPoint(x, y, point);

        System.out.println(resp);
        System.out.println(resp1);
        System.out.println(resp2);

        System.out.println("**************** 2nd question ****************");

        int []  nums = new int[] {-1,-2,-3,-4,3,2,1};
        int answer = arraySign(nums);
        System.out.println(answer);

        int [] sol = new int[] {-1,1,-1,1,-1 };
        int solution = arraySign(sol);
        System.out.println(solution);

        System.out.println("**************** 3rd question ****************");




    }
}