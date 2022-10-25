import java.util.LinkedList;
import java.util.ListIterator;

public class ListTester {

    public static void main(String[] args ){
        LinkedList <String> staff = new LinkedList<String>();
        staff.addLast("Diana");
        staff.addLast("Gloria");
        staff.addLast("Ange");
        staff.addLast("Tom");
        staff.addLast("Romeno");

        ListIterator<String> iterator = staff.listIterator(); // iterator
        iterator.next(); // D|GATR
        iterator.next(); // DG|ATR

        // add more element after second element
        iterator.add("Julie"); // DGJ|ATR
        iterator.add("Nina"); // DGJN/ATR

        iterator.next(); //DGJNA/TR

        // remove the last traversed element
        iterator.remove(); //DGJN/TR

        for (String s : staff) {
            System.out.println( s + " ");
        }

    }
}
