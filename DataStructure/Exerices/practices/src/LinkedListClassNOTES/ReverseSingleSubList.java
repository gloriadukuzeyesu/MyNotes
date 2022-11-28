package LinkedListClassNOTES;

public class ReverseSingleSubList {
    private static class ListNode<T> {
        public T data;
        public ListNode<T> next;

        ListNode () {
        }
    }
    /**
     * @param L listNode to be reversed
     * @param start start node to be reversed
     * @param finish end node of the sublist to be reversed
     * @return a list node with a sublist reversed
     * */
    public static ListNode<Integer> reverseSublist(ListNode<Integer> L, int start, int finish ){
        // find the head of the node to start the reversing

        if( start == finish ){
            return L; // no need to reverse
        }

        // create a dumy head
        ListNode<Integer> dummyHead = new ListNode<Integer>();
        // create the sublist head
        ListNode<Integer> subListHead = dummyHead;

        // find where the subList Head is. It using the start position

        int k =1; // the first node is head. Not indexing here
        while( k < start){
            subListHead = subListHead.next;
            k++;
        }

        ListNode<Integer> subListIter = subListHead.next;
        while ( start < finish ) {
            ListNode<Integer> temp = subListIter.next;
            subListIter.next = temp.next;
            temp.next = subListHead.next;
            subListHead.next = temp;
            start++;
        }

        return dummyHead.next;
    }



    public static void main( String [] args ) {
        ListNode <Integer> head = new ListNode<> ();



    }
}
