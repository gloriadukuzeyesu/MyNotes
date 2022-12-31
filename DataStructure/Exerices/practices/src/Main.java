import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class Main {

    public static boolean isValidSudoku(char[][] board) {
        Set seen = new HashSet();
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                char number = board[i][j];
                if (number != '.') {
                    if (!seen.add(number + " in row " + i) ||
                            !seen.add(number + " in column" + j) ||
                            !seen.add(number + "in block " + i / 3 + " -" + j / 3)) ;
                    return false;
                }

            }
        }
        return true;
    }
    public static void main(String[] args) {

        /* Two dimensional Arrays */
        int[][] integers = {{3, 5, 7}, {10, 2, 9}};

        System.out.print(integers[0][0] + " ");
        System.out.print(integers[0][1] + " ");
        System.out.print(integers[0][2] + " ");

        System.out.print("\n");

        System.out.print(integers[1][0] + " ");
        System.out.print(integers[1][1] + " ");
        System.out.println(integers[1][2] + " ");


        System.out.println("new method. printing row by row");
        // outer loop is the rows and the inner loop is the columns
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 3; j++) {
                System.out.print(integers[i][j] + " ");
            }
            System.out.println();
        }

        System.out.println("printing column by column");
        // outer loop is for the columns and the inner loop is for the rows
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 2; j++) {
                System.out.print(integers[j][i] + " ");
            }
            System.out.println();
        }

        String twoDRepresation = Arrays.deepToString(integers);
        System.out.println(twoDRepresation);

        System.out.println("Ragged array: array with rows with different length ");

        int[][] raggedArray = {
                {1, 2, 3},
                {5, 6},
                {6, 7, 9, 0, 11}
        };
//        printArray(raggedArray);
    }
}