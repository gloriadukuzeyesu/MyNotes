package Cisco;

import static java.lang.System.exit;

/**
 * A program to create a stack using LinkedList
 */

public class StackLinkedlist {
    private class Node {
        int data_;
        Node next_;
    }

    Node top;

    public StackLinkedlist() {
        this.top = null;
    }

    /**
     * function to add in on the stack
     */
    public void push(int i) {
        Node t = new Node();
        if (t == null) {
            System.out.println("Stack overFlow");
            return;
        }
        t.data_ = i;
        t.next_ = top;
        // update the top
        top = t;
    }

    /**
     * function to check if the stack is empty
     *
     * @return true if the stack is empty, false otherwise
     */
    public boolean isEmpty() {
        return top == null;
    }

    /**
     * function to return the top most element of the stack
     */

    public int peek() {
        if (!isEmpty()) {
            return top.data_;
        } else {
            System.out.println("Stack is empty");
            return -1;
        }

    }

    /**
     * function to remove the top most element of the stack
     */
    public void pop() {
        // check for the under flow
        if (top == null) {
            System.out.println("Stack is underFlow");
            return;
        }
        // update the top pointer to point to the next node
        top = (top).next_;
    }

    public void show() {
        if (top == null) {
            System.out.println("Stack is underFlow");
            exit(1);
        } else {
            Node temp = top;
            while (temp != null) {
                System.out.print(temp.data_ + "--->");
                temp = temp.next_;
            }
            System.out.println();
        }
    }
}

