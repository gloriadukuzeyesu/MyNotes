import java.util.List;

public class Result {

    public static int largestSubgrid (List<List<Integer>> grid, int maxSum)
    {
        int size = grid.size(); // size of the grid
        int maximum = 0;
        int [] [] sum = new int[size][size];

        for (int i=0; i<size; i++ )  // loop through the grid size one sequence
        {
            for ( int j=0; j<size ; j++) // loop through the other sequence
            {
                if ( i==0 && j ==0)  // if
                {
                    sum[0][j] = grid.get(0).get(0);
                }
                else if (i==0)
                {
                    sum[0][j] = sum[0][j-1] +  grid.get(0).get(j);
                }
                else if (j==0)
                {
                    sum[i][0] = sum[i-1][0] + grid.get(i).get(0);
                }
                else
                {
                    sum[i][j] = sum[i-1][j] +  sum[i][j-1] + grid.get(i).get(j)- sum [i-1][j-1];
                }
                maximum = Math.max(maximum,grid.get(i).get(j));
            }
        }

        int ans = 0;
        int z = 0;
        int y = size;

        while ( z<y )
        {
            int x = z + (y-z+1) / 2;
            int res = 0;

            for (int i = x-1; i<size ; i++)
            {
                for ( int j=x-1; j<size ; j++)
                {
                    int total = sum [i][j];
                    if ( i >=x )
                        total -= sum[i-x][j];
                    if ( j>= x )
                        total -= sum[i][j-x];
                    if( i>= x && j>= x)
                        total += sum [i-x] [j-x];
                    res = Math.max(res, total);
                }
            }

            if (maxSum >= res ) {
                z=x;
            }
            else {
                y = x-1;
            }
        }
        return y;
    }

}
