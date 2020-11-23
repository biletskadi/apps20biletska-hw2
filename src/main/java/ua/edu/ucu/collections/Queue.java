package ua.edu.ucu.collections;

import ua.edu.ucu.collections.immutable.ImmutableLinkedList;

public class Queue {
    private ImmutableLinkedList linkedlst;

    public Queue() {
        this.linkedlst = new ImmutableLinkedList();
    }

    public Object peek() {
        return linkedlst.getFirst();
    }

    public Object dequeue() {
        Object obj = this.peek();
        linkedlst = linkedlst.removeFirst();
        return obj;
    }

    public void enqueue(Object x) {
        linkedlst = linkedlst.addLast(x);
    }

}
