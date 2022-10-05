import java.util.Currency;

public class Main {
    /*
     Write a function that takes an unsigned integer and
     returns the number of '1' bits it has (also known as the Hamming weight).
     */

    /* STEPS
    1. iterate to all bits till all number is not equal to 0
    2. calculate if the last digit is 1 by n OR 1
    3. RightShift the number and divide by 2
     */


    public static int hammingWeigth(int n) {

        int CurrenntNumberOfBits = 0;
    // 1. iterate to all bits till all number is not equal to 0
        while ( n !=0 ){
    // 2. calculate if the last digit is 1 by n OR 1
            CurrenntNumberOfBits += n & 1;
    //  3. RightShift the number and divide by 2
            n = n >> 1;
        }
        return CurrenntNumberOfBits;
    }


    public static void main(String[] args) {
        int x = 00000000000000000000000000001011;
        System.out.println("Number of 1 bit in " + x + " are " + hammingWeigth(x));

       int y = 00000000000000000000000010000000;
        System.out.println("Number of 1 bit in " + y + " are " + hammingWeigth(y));

       int z  =1111111;
        System.out.println("Number of 1 bit in " + z + " are " + hammingWeigth(z));


//        int k  = 25 << 1;
//        int m = 25 << 2;
//        System.out.println("m value " + m);
//        System.out.println("k value " + k);
//
//        int n= 40 >> 2;
//        System.out.println("n value " + n);
//        int l= 40 >>> 2;
//        System.out.println("l value " + l);

    }
}