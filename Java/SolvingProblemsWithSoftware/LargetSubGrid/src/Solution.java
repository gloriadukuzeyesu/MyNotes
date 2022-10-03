import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Solution {

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int gridRows = Integer.parseInt(bufferedReader.readLine().trim());
        int gridColumns = Integer.parseInt(bufferedReader.readLine().trim());

        List<List<Integer>> grid = new ArrayList<>();

        for (int i = 0; i < gridRows; i++) {
            String[] gridRowTempItems = bufferedReader.readLine().replaceAll("\\s+$", "").split(" ");

            List<Integer> gridRowItems = new ArrayList<>();

            for (int j = 0; j < gridColumns; j++) {
                int gridItem = Integer.parseInt(gridRowTempItems[j]);
                gridRowItems.add(gridItem);
            }

            grid.add(gridRowItems);
        }

        int maxSum = Integer.parseInt(bufferedReader.readLine().trim());

        int result = Result.largestSubgrid(grid, maxSum);

        bufferedWriter.write(String.valueOf(result));
        bufferedWriter.newLine();

        bufferedReader.close();
        bufferedWriter.close();
    }



}
