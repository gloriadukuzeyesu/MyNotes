package recursion;

public class Recursion {

public static void main( String[] args ){

//    sayhi(100);
//    System.out.println(sum(2));


    System.out.println(factorial(6));


}

    private static int factorial(int i) {
        if ( i == 0)
            return 1;
        else
            return i * factorial(i-1);
    }

    private static int sum(int n ) {
        if(n < 0) {
            System.out.println("Error");
            return -1;
        }else {
            System.out.println("continue");
            return sumRecursive(n);
        }
    }

    private static int sumRecursive(int n) {
        if(n == 1) {
            return 1;
        }
        return n + sumRecursive(n-1);
    }

    private static void sayhi(int count ) {
        System.out.println("sayhi");
        if ( count <=1 ){return;} // base case
        sayhi(count -1);
    }

}
