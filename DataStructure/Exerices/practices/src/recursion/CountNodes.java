package recursion;

import java.util.List;

public class RecursiveFunction {
    public static ListNode head_ = null;
    public static ListNode tail_ = null;


    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {};
        ListNode(int val){ this.val = val;}
        ListNode ( int val, ListNode next ) {
            this.val = val;
            this.next = next;
        }
    }

    public static void addNode( int data ){
        // create a new node
        ListNode newNode = new ListNode(data);
        if( head_ == null ){
            head_ = newNode;
            tail_ = newNode;
        }else{
            tail_.next = newNode;
            tail_ = newNode; 
        }
    }

    public static ListNode swapPairs(ListNode head){
        ListNode dummyhead = new ListNode(0);
        dummyhead.next = head;
        ListNode prevNode = dummyhead;

        while ( ( head != null ) && (head.next != null ) ){
            // nodes to swapp
            ListNode firstNode = head;
            ListNode secondNode = head.next;

            // swapp them
            prevNode.next  = secondNode;
            firstNode.next = secondNode.next;
            secondNode.next = firstNode;

            // reinitialize the head and prevenode for the next swap
            prevNode = firstNode;
            head = firstNode.next; // jump

        }
        // return the new node
        return dummyhead.next;
    }





    public static void main( String [] args){
        System.out.println("hello");

        ListNode list = new ListNode(1);
        list.next = 2;

        ListNode list1 = new ListNode(2);
        ListNode list2 = new ListNode(3);
        ListNode list3 = new ListNode(4);
        list.next = list1;
        list1.next = list2;


        list.next = new ListNode(2);
        list.next.next.next = new ListNode(3);
        list.next.next.next.next = new ListNode(4);
        System.out.println(list);
    }
}
