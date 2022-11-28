import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Stack;

public class ValidSudoku {

    public static boolean aValidSudoku(char[][] board) {
        int N=9;
        HashSet<Character> row = new HashSet<>();
        HashSet<Character> column = new HashSet<>();
        HashSet<Character> boxes = new HashSet<>();

        for( int i=0; i<9; i++) {
            for( int j=0; j<9; j++){
                char numb = board[i][j];
                if(numb != '.'){
                    // we have a number
                    // checking the rows
                  /*  if(row.contains(numb)){
                        return false;
                    }else{
                        row.add(numb);
                    }
                    */
                    if( !row.add(numb)){
                        return false;
                    }
                    if( !column.add(numb)){
                        return false;
                    }

                   /* // check the column
                    if(column.contains(numb)){
                        return false;
                    }else{
                        column.add(numb);
                    }*/
                    // check for the 3x3 box
                    int rowIndex = 3* (i/3);
                    int columIndex = 3 * (i%3);
                    char boxChars= board[rowIndex][columIndex];

                    if(!boxes.add(boxChars)){
                        return false;
                    }
/*
                    if(boxes.contains(boxChars)){
                        return false;
                    }else{
                        boxes.add(boxChars);
                    }*/
                }

            }
        }

        return true;

    }

    public boolean isValidSudoku(char[][] board) {
        HashSet<String> seen = new HashSet<>();
        for ( int i = 0; i<9; i++ ){
            for ( int j = 0;  j <9; j ++ ){
                char numb = board[i][j];
                if( numb != '.') {
                    if(!seen.add(numb+ " in row " + i ) ||
                            !seen.add(numb+ " in column " + j ) ||
                            !seen.add(numb+ " in sub box " + i )
                    )
                        return false;
                }

            }
        }
        return true;
    }

    public boolean isValid(String s) {
        Stack<Character> stack = new Stack();
        Map<Character, Character> map = new HashMap<>();
        map.put('(', ')');
        map.put('[', ']');
        map.put('{', '}');
        for (char c : s.toCharArray()) {
            if (map.containsKey(c)) {
                stack.push(map.get(c));
            }
            else if (stack.empty() || stack.pop() != c) return false;
        }
        return stack.empty();
    }


    public void main( String [] args ) {


    }
}
