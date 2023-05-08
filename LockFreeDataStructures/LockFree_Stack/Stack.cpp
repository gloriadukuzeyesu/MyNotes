//
// Created by Gloria Dukuzeyesu on 4/9/23.
//

#include "Stack.h"

void Stack::push(Node *in) {
    Node *expectedNode;
    do {
        expectedNode = head;
        in->next = expectedNode; // push to the top
    } while (!CAS(&head, expectedNode, in));

}

void Stack::pop() {
    Node *ret;
    Node *nextNode;
    do {
        ret = head;
        nextNode = ret->next;
    } while (!CAS(&head, ret, nextNode));
}

bool Stack::CAS(Node **ptr, Node *expected, Node *newNode) {
    if (*ptr == expected) {
        *ptr = newNode;
        return true;
    }
    return false;
}



