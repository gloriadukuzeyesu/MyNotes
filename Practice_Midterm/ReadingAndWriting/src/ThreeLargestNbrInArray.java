import java.util.Arrays;

public class ThreeLargestNbrInArray {

    public static void threeLargestNumbers(int[] numbers, int arraySize) {

        int first = Integer.MIN_VALUE;
        int second = Integer.MIN_VALUE;
        int third = Integer.MIN_VALUE;

        /*there should be at least three elements */
        if(arraySize < 3 ) {
            System.out.println("Invalid input, the array size is less than 3");
            return;
        }

        for ( int i=0; i< arraySize ; i++ ) {
            /* if current element is greater than first, assign first to second, second to third, and current to first, order matters */
            if ( numbers[i] > first ) {
                third = second;
                second = first;
                first = numbers[i];
            }
            /*If above step is not true then current element might be a candidate of second highest element,
            so check if current>second, if yes then assign second value to third and assign current to second.*/
            else if (numbers[i] > second) {
                third = second;
                second = numbers[i];
            }
            /*If above step is not true then current element might be a candidate of third highest element, so
            check if current>third, if yes then assign current to third*/
            else if ( numbers[i] > third) {
                third = numbers[i];
            }
        }
        System.out.println("Three largest elements are " + first + " " + second + " " + third);
    }

    public static void printLargest( int[] arr, int arr_size){
        Arrays.sort(arr);
        if ( arr_size < 3 ) {
            System.out.println("Invalid input, The array size is less than 3");
            return;
        }
        arr_size = arr.length;
        int x, y, z;
        x = arr [arr_size -1];
        y = arr [arr_size -2];
        z = arr [arr_size -3];

        System.out.println("The Largest three elements are " + x + " " + y + " " + z);
    }

    public  static int [] choose3largestNumbers ( int [] arr ){
        Arrays.sort(arr);
        int [] res = new int[3];
        for (int i=0; i< 3; i++ ) {
            res[i] = arr[arr.length-1-i];
        }
        return res;
    }


    public static void main ( String [] args ) {
        /* With array size less than 3 */
        int [] myarr = new int[] { 7,10};
        int arraySize = myarr.length;
        threeLargestNumbers(myarr, arraySize);
        printLargest(myarr, arraySize);

        /* With array size greater than 3 */
        int [] myArray = new int[] { 7, 10, 2, 5, 10, 45, 23, 1};
        int array_size = myArray.length;
        threeLargestNumbers(myArray, array_size);
        printLargest(myArray, array_size);

        // new method
        int [] newArr = new int[] {1,5,-9};
        ;
        System.out.println(Arrays.toString(choose3largestNumbers(newArr)));



    }

}
