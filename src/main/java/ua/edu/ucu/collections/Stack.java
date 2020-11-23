package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Stack {
    private ImmutableLinkedList linkedlst;

    public Stack() {
        linkedlst = new ImmutableLinkedList();
    }

    Object peek() {
        return linkedlst.getLast();
    }

    Object pop() {
        Object obj = this.peek();
        linkedlst = linkedlst.removeLast();
        return obj;
    }

    void push(Object x) {
        linkedlst = linkedlst.addLast(x);
    }
}
