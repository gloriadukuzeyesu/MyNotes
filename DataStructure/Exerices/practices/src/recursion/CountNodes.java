package recursion;

public class CountNodes {
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

        public  void addNode( int data ){
            // create a new node
            ListNode newNode = new ListNode(data);
            if( head_ == null ){
                // if listnode is empty, both head and tail will point to a new node
                head_ = newNode;
                tail_ = newNode;
            }else{
                // otherwise add it at the end of the tail. let the tail point to it and make the new node the new tail
                tail_.next = newNode;
                tail_ = newNode;
            }
        }
    }

    public ListNode swapPairs(ListNode head){

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



    public void printNode(){
        ListNode currentHead = head_;
        if( head_ == null) {
            System.out.println("list is empty");
            return;
        }
        System.out.println("Nodes for singly linkedList");
        while ( currentHead != null ){
            // prints each node
            System.out.print(currentHead.val + " -> " );
            currentHead = currentHead.next;
        }
        System.out.println();
    }

    public static void main( String [] args){
        System.out.println("hello");
        ListNode newListNode = new ListNode();

        newListNode.addNode(1);
        newListNode.addNode(2);
        newListNode.addNode(3);
        newListNode.addNode(4);
        newListNode.addNode(3);

    }
}
