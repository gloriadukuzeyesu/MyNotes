package LinkedListClassNOTES;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class LinkedLISTNOTES {
    public static void main( String [] args ) {
        String [] a = new String[] { "gloria", "id", "Banana"};
        Arrays.sort(a);
       String [] nb = Arrays.copyOf(a,a.length-2);
        for( String x : nb){
            System.out.print(x + " ");
        }
        System.out.println(" ");

        for( String x : a){
            System.out.print(x + " ");
        }
        System.out.println();
        List <String>list1 = Arrays.asList(a);
        list1.set(0, "tree");
        Collections.sort(list1);
        System.out.println( list1.get(1));
        System.out.println("list1 " + list1);

        Integer[] array = new Integer[]{90,9,4};
//        Arrays.sort(array);
        List <Integer>list2 = Arrays.asList(array);
        Collections.sort(list2);
        System.out.println("list2 " +list2 );

    }



}


