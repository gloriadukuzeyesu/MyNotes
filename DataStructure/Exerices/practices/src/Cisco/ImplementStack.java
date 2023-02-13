package Cisco;

public class ImplementStack {
    public static void main(String[] args) {
        // create a stack LinkedList
        StackLinkedlist stackLinkedlist = new StackLinkedlist();
        //insert elements
        stackLinkedlist.push(5);
        stackLinkedlist.push(6);
        stackLinkedlist.push(7);
        stackLinkedlist.push(8);
        stackLinkedlist.push(9);

        //print the element of the stack
        stackLinkedlist.show();

        //print the top
        System.out.println("The top element of the stack is: " + stackLinkedlist.peek());

        //delete the top element of the stack
        stackLinkedlist.pop();
        stackLinkedlist.pop();

        stackLinkedlist.show();

        // print the top element of the stack
        System.out.println("current top element of the stack: " + stackLinkedlist.peek());
    }
}
