import java.util.Scanner;

public class MyResults {

    int largestsubgrid(int[][] grid, int maxSum ) {
        int i, j, pos, x, z, sum;
        boolean SumIsLessThanOrEqualMaxSum;

       int  gridLength = grid.length;
        // gridLength of the array

        for ( z = 1; z <= gridLength; z++){

            SumIsLessThanOrEqualMaxSum = true; // for every grid gridLength, set SumIsLessThanOrEqualMaxSum to true

            for ( i = 0; i <gridLength - z + 1; i++ )   // loop through the array of the gridLength S
            {
                for (j =0; j< gridLength - z + 1; j++)
                {
                    sum =0;

                    if (!SumIsLessThanOrEqualMaxSum) // if lag is false means the grid gridLength where maxsum is exceeded
                        break;

                    for (pos = 0; pos < z; pos++ )
                    { // for every position create a grid of gridLength z stating from there and find sum
                        for (x= 0; x<z; x++ )
                        {
                            sum = sum + grid[i +pos] [j+x];
                        }
                    }

                    if (sum > maxSum) // if SumIsLessThanOrEqualMaxSum is false, it means we have a grid gridLength where mazsum is exceeded
                        SumIsLessThanOrEqualMaxSum = false;
                }

                if (!SumIsLessThanOrEqualMaxSum)
                    break;
            }



                 if (!SumIsLessThanOrEqualMaxSum)
                    break;
        }
        return z-1; // as grid gridLength has maxsum exceeding, z-1 will be the answer
    }



    public static void main(String[] args)
    {

        MyResults ob = new MyResults();
        Scanner scan = new Scanner(System.in);


        int row = scan.nextInt();
        int column = scan.nextInt();

        int arr[][] = new int[row][column];

        for (int i = 0; i< row ; i++){
            for (int j =0; j< column; j++)
                arr[i][j] = scan.nextInt();
        }

        int ms = scan.nextInt();

        scan.close();


        System.out.println(ob.largestsubgrid(arr,ms));
    }
}