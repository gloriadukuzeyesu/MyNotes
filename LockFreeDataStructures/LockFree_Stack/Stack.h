//
// Created by Gloria Dukuzeyesu on 4/9/23.
//

#ifndef LOCKFREEDATASTRUCTURES_STACK_H
#define LOCKFREEDATASTRUCTURES_STACK_H

class Node {
public:
    Node *next;
    int data;

};

class Stack {
    Node *head;

    void push(Node *in);

    void pop();

    bool CAS(Node **ptr, Node *expected, Node *newNode);
};


#endif //LOCKFREEDATASTRUCTURES_STACK_H
