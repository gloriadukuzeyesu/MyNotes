public class Solution {

    public static int subtractProductAndSum(int n){
        int sum = 0;
        int product = 1;

        while ( n!= 0 ){
            int remainder = n % 10 ;
            sum += remainder;
            product *= remainder;

            // create a new value of n to start with
            n/=10;
        }

        return  product-sum;

    }

    public static void main(String[] args) {
        int k = 255;
        System.out.println(" the substration of product and sum of that compose " + k + " is " + subtractProductAndSum(k));

        /*
        subtractProductAndSum(k) // 38
        sum is 2 + 5 + 5 = 12
        product = 2 * 5 * 5 = 50
        difference = 50 - 12 = 38
         */
    }

}