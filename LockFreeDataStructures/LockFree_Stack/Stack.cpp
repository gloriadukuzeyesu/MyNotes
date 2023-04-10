//
// Created by Gloria Dukuzeyesu on 4/9/23.
//

#include "Stack.h"

void Stack::push(Stack::Node *in) {
    Node *expectedNode;
    do {
        expectedNode = head;
        in->next = expectedNode; // push to the top
    } while (!CAS(&head, expectedNode, in));

}

bool Stack::CAS(Stack::Node **ptr, Stack::Node *expected, Stack::Node *newNode) {
    if (*ptr == expected) {
        *ptr = newNode;
        return true;
    }
    return false;
}

