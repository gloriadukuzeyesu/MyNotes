package LinkedList;

public class linkedList {

    public static  void deleteNode(ListNode node ){
        // create a temporary listnote to store the val of the current node

        ListNode nextNodeOfCurrentNode = node.next;
        // copy over the next node val to current node
        node.val = nextNodeOfCurrentNode.val;

        // update the pinter of the current node to point to next
        node.next = nextNodeOfCurrentNode.next;
        nextNodeOfCurrentNode.next = null; // null since it doesn't have anything to point  at rn
    }



 public static void main(String[] args) {
     System.out.println("Heloo");

    }
}


  class ListNode {
 int val;
 ListNode next;
 ListNode(int x) {
     val = x; }
  }
