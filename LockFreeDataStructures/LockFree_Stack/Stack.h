//
// Created by Gloria Dukuzeyesu on 4/9/23.
//

#ifndef LOCKFREEDATASTRUCTURES_STACK_H
#define LOCKFREEDATASTRUCTURES_STACK_H


class Stack {


    class Node {
    public:
        Node *next;
        int data;

    };

    Node *head;

    void push(Node *in);

    bool CAS(Node **ptr, Node *expected, Node *newNode);
};


#endif //LOCKFREEDATASTRUCTURES_STACK_H
