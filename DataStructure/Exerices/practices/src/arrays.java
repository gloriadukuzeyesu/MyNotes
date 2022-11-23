import java.util.ArrayList;
import java.util.List;

public class arrays {
    public static List<Integer> plusOne (List<Integer> A) {
        int n = A.size() - 1;  // index of the last element
        System.out.println("A" + A);

        A.set(n, A.get(n)+1);  // at the last element add 1
        System.out.println("A" + A);
        for( int i=n; i>0 && A.get(i) ==10; i-- ){
            A.set(i, 0) ;
            A.set(i-1, A.get(i-1) + 1);
        }
        System.out.println("A" + A);


        if(A.get(0) ==10) {
            A.set(0,0);
            A.add(0,1);
        }
        return A ;
    }

    public static int[] addOne (int [] A) {
        int n = A.length;
        int last = A[n-1];
        A[n-1] = last + 1;

        for( int i = A.length -1; i>0 ; i--){
            if( A[n-1] == 10){
                A[i] = 0;
                A[i-1] = A[i-1] + 1;
            }
        }
        return A;
    }


    public static int[] plus_One(int[] digits) {
        int n = digits.length;
        for( int i= n-1; i>=0; i--) {
            if( digits[i]==9){
                digits[i] = 0;
            }else{
                digits[i] +=1;
                return digits;
            }
        }

        // when all digits are 9
        digits = new int[n+1]; // space: O(n) , time complexity : O(n)

//        digits[0] =1;
        return digits;
    }

    public static void main( String[] args) {

 /*       List<Integer> myList = new ArrayList<>(List.of(1,2,9));
        var resp = arrays.plusOne(myList);
        System.out.println(resp);*/

        int [] arr = new int[] {7,8,9};
        var answer = arrays.plus_One(arr);
        for ( int x: answer) {
            System.out.println(x);
        }

    }
}
