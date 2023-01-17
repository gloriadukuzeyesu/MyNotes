package LinkedListClassNOTES;

public class LinkedList {
    Node head;

    class Node {
        int data_;
        Node next_;

        Node (int d) {
            data_ = d;
            next_ = null;
        }
    }

    public void removeNthFromEnd (LinkedList list, int n ) {
        Node slow = head;
        Node fast = head;
        for ( int i = 0 ; i < n; i++) {
            fast = fast.next_;
        }

        if( fast == null) {
//            assert head != null;
            head = head.next_;
            return;
        }

        while  (fast.next_ != null) {
            slow = slow.next_;
            fast = fast.next_;

        }
        slow.next_ = slow.next_.next_;

    }

}
