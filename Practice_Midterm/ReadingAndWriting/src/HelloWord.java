public class HelloWord {
    static int num = 10;
    public static void main( String [] args ) {
        int  x = 130;
        byte b = (byte)x;  // bytes bounds are  -128 to 127
        System.out.println( b );
        /*
        * the int x is represented in the machine as 0 {24} 10000010
        * byte b is represented with only the last 8bits on int x which is 10000010
        * then find its relatively Decimal from signed 2's complement
        * the 2's complement of 10000010 is 01111110 which is 126 decimal
        * then cast it into int
        * casting always preserves the sign of a number, then it is -126
        * */

        /*
        * a byte is always signed in java
        * you may get it unsigned by adding binary and with  0xFF
        */

        //convert the byte back to in and binary and with 0xFF
        int b2 = b & 0xFF;
        System.out.println(b2);


        int k = 126; // within the bytes bounds of  -128 to 127
        byte k_byte = (byte) k;
        System.out.println("k_byte: " + k_byte);


        System.out.println( "num is: " + num );



    }
}


