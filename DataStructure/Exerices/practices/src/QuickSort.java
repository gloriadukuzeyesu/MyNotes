import java.util.Random;

public class QuickSort {

    public static void main(String[] args) {
        //  generationg a random numbers 
        Random rand = new Random();
        int [] numbers = new  int[] { 3,5,6,1,-6}; // array with ten spaces
//        int [] numbers = new  int[10];

      /*  for ( int i= 0; i< numbers.length; i++ ) {
            numbers[i] = rand.nextInt(100); // puting numbers in the array from randomilized
        }*/
        System.out.println("Before Quick Sorting");
        printArray(numbers); // print the  array  before sorting
        
//        quicksort(numbers, 0, numbers.length-1); // quick sort the array
        quicksort(numbers);

        System.out.println("After Quick sort: "); // print the  array after being sorted
        printArray(numbers);
    }

    private static void quicksort(int [] array) {
        quicksort(array, 0, array.length-1); // quick sort the array

    }
    private static void quicksort(int[] array, int lowIndex, int highIndex) {
        // base case . an array of just one number is already sorted
        if ( lowIndex >= highIndex){
            return;
        }

        int pivot = chooseLastElementAsPivot(array, lowIndex, highIndex);
//        int pivot = chooseFirstElementAsPivot(array, lowIndex, highIndex);
//        int pivot = chooseRandomElementAsPivot(array, lowIndex, highIndex);
//        int pivot = chooseMedianAsPivot(array, lowIndex, highIndex);


        int leftPointer = partition(array, lowIndex, highIndex, pivot);
        // leftPointer here is the indexOf the Pivot after partitioning

        // recursively sort our left side later recursively sort the right side of the pivot
        quicksort(array, lowIndex, leftPointer-1);
        quicksort(array, leftPointer + 1, highIndex);

    }


    // methods to choose pivot

    public static int chooseFirstElementAsPivot(int[] array, int lowIndex, int highIndex){
        int pivot = array[lowIndex];
        swap(array,lowIndex, highIndex); // place it at the end. every code will proceed the same.
        return pivot;
    }

    public static int chooseLastElementAsPivot(int[] array, int lowIndex, int highIndex){
       //1. the last element in the array
//        int pivot = array[highIndex] ;
        return array[highIndex] ;
    }

    public static int chooseRandomElementAsPivot(int[] array, int lowIndex, int highIndex){
        // choosing the random index for the pivot in the array. Then swap it with the element at the last position. Everything should then proceed the same
        int randomPivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = array[randomPivotIndex];
        swap(array, randomPivotIndex, highIndex); //swap pivot with the right
        // with the random pivot choosing, the algorithm works better in the average case
        return pivot;
    }
    public static int chooseMedianAsPivot(int[] array, int lowIndex, int highIndex) {
        // put all elements in order
        // grab the element at index at array.length/2
        // swap with the rightMost element
        // return the pivot
        insertionSort(array);
        int medianIndex = ( array.length + 1 ) / 2;
        int pivot = array[medianIndex];
        swap(array ,medianIndex, highIndex);

        return pivot ;
    }

    private static void insertionSort(int[] array) {

        /*
           for ( int i = 1; i< inputArrayList.size(); i++ ) {
            T temp = inputArrayList.get(i);
            int j = i-1;
            while ( j >= 0 && comparator.compare( inputArrayList.get(j), temp ) > 0 ) {
                inputArrayList.set( j+1, inputArrayList.get(j) ); // move the value to the right if it is found to be greater than temp
                j--;
            }
            inputArrayList.set(j+1, temp);
        }
        * */

        int N = array.length;
        for ( int i= 1; i<N; i++) {
            int temp = array[i];
            int j= i-1;
            while( j>=0 && array[j] > temp) {
                array[j+1] = array[j];
                j--;
            }
            array[j+1] = temp;
        }
    }

    private static int choosePivot(int[] array, int lowIndex, int highIndex) {



        /*// 2. choosing the random index for the pivot in the array. Then swap it with the element at the last position. Everything should then proceed the same
        int randomPivotIndex = new Random().nextInt(highIndex - lowIndex) + lowIndex;
        int pivot = array[randomPivotIndex];
        swap(array, randomPivotIndex, highIndex);
        // with the random pivot choosing, the algorithm works better in the average case
        */

        //3. choose the first element in the array
        int pivot = array[lowIndex];
        swap(array,lowIndex, highIndex); // place it at the end every code will proceed the same.

        return pivot;
    }

    private static int partition(int[] array, int lowIndex, int highIndex, int pivot) {
        // portioning
        // create pointers: left and right pointer. move leftpointer around the number
        int leftPointer = lowIndex;
        int rightPointer = highIndex;

        while ( leftPointer < rightPointer ) { // when right and left pointer is hit each other. knocks out of the loop

            // walk the left the pointer left to right until you find larger number than pivot  or when you hit the right pointer
            while ( array[ leftPointer] <= pivot && leftPointer < rightPointer) {
                leftPointer++;
            }


            while ( array[rightPointer] >= pivot && leftPointer < rightPointer) {
                rightPointer--;
            }

            // next step is to swap elements at the left pointer with the element at the right elements
            swap(array, leftPointer, rightPointer);
//            int leftPointer = partition( array ,lowIndex, highIndex, pivot);
        }

        // swap the element being pointed by both leftPointer and rightPointer with the pivot
        swap(array, leftPointer, highIndex);  // chose high index because out pivot at this point is sitting at the high index of the array
        return leftPointer;
    }

    // helper method will allow us to swap elements at which left and right pointers are pointing at
    private static void swap ( int[] array, int index1, int index2 ) {
        int temp = array[index1];
        array[index1] = array[index2];
        array[index2] = temp;
    }

    private static void printArray(int[] numbers) {
        for ( int i : numbers) {
            System.out.println(i);
        }
    }
}
