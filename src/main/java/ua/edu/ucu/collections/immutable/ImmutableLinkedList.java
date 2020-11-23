package ua.edu.ucu.collections.immutable;

public class ImmutableLinkedList implements ImmutableList {
    public ImmutableLinkedList() {
        head = null;
        size = 0;
    }

    ImmutableLinkedList(Object[] c) {
        if (c.length != 0) {
            head = new Node(c[0]);
            Node curnode = head;
            for (int i = 1; i < c.length; i++) {
                curnode.next = new Node(c[i]);
                curnode = curnode.next;
            }
        }
        size = c.length;
    }

    private ImmutableLinkedList(Node n) {
        head = n;
    }

    static class Node {
        Object value;
        Node next;

        Node(Object o) {
            value = o;
            next = null;
        }
    }

    private Node head;
    private int size = 0;


    private ImmutableLinkedList copyList(ImmutableLinkedList orig) {
        if (orig.head == null) {
            return new ImmutableLinkedList();
        }
        ImmutableLinkedList new_lst = new ImmutableLinkedList();
        new_lst.size = size;
        new_lst.head = new Node(orig.head.value);
        Node orig_node = orig.head.next;
        Node new_node = new_lst.head;
        while (orig_node != null) {
            new_node.next = new Node(orig_node.value);
            new_node = new_node.next;
            orig_node = orig_node.next;
        }
        return new_lst;
    }

    public ImmutableLinkedList add(Object e) {
        return add(size, e);
    }

    public ImmutableLinkedList add(int index, Object e) {
        if (index < 0 || index > size + 1) {
            throw new IndexOutOfBoundsException();
        }
        int counter = 0;
        ImmutableLinkedList new_lst = copyList(this);
        Node curnode = new_lst.head;
        Node newnode = new Node(e);
        if (curnode == null) {
            new_lst.head = new Node(e);
        } else if (index == 0) {
            newnode.next = curnode;
            ImmutableLinkedList linkedlst = new ImmutableLinkedList(newnode);
            linkedlst.size = size + 1;
            return linkedlst;
        } else {
            while (curnode != null) {
                if (counter == index - 1) {
                    Node node1 = curnode.next;
                    curnode.next = newnode;
                    curnode.next.next = node1;
                }
                curnode = curnode.next;
                counter++;
            }
        }
        new_lst.size++;
        return new_lst;
    }

    public ImmutableLinkedList addAll(Object[] c) {
        return addAll(size, c);
    }

    public ImmutableLinkedList addAll(int index, Object[] c) {
        ImmutableLinkedList new_lst = copyList(this);
        for (int i = 0; i < c.length; i++) {
            new_lst = new_lst.add(index + i, c[i]);
        }
        return new_lst;
    }

    public Object get(int index) {
        if (index < 0 || index > size + 1) {
            throw new IndexOutOfBoundsException();
        }
        ImmutableLinkedList new_lst = copyList(this);
        Node curnode = new_lst.head;
        while (index-- != 0) {
            curnode = curnode.next;
        }
        return curnode.value;
    }


    public ImmutableLinkedList remove(int index) {
        if (index < 0 || index > size + 1) {
            throw new IndexOutOfBoundsException();
        }
        ImmutableLinkedList new_lst = copyList(this);
        Node curnode = new_lst.head;
        int counter = 0;
        if (index == 0) {
            ImmutableLinkedList lst = new ImmutableLinkedList(curnode.next);
            lst.size = this.size - 1;
            return lst;
        }
        while (counter != index - 1) {
            curnode = curnode.next;
            counter++;
        }
        Node prev = curnode;
        Node next = curnode.next.next;
        prev.next = next;
        new_lst.size--;
        return new_lst;
    }

    public ImmutableLinkedList set(int index, Object e) {
        if (index < 0 || index > size + 1) {
            throw new IndexOutOfBoundsException();
        }
        ImmutableLinkedList new_lst = copyList(this);
        Node curnode = new_lst.head;
        while (index-- != 0) {
            curnode = curnode.next;
        }
        curnode.value = e;
        return new_lst;
    }

    public int indexOf(Object e) {
        ImmutableLinkedList newlinkedlst = copyList(this);
        Node curnode = newlinkedlst.head;
        int counter = 0;
        while (curnode != null && !curnode.value.equals(e)) {
            curnode = curnode.next;
            counter++;
        }
        if (counter == newlinkedlst.size && newlinkedlst.getLast() != e) {
            return -1;
        }
        return counter;
    }

    public int size() {
        return size;
    }

    public ImmutableLinkedList clear() {
        return new ImmutableLinkedList();
    }

    public boolean isEmpty() {
        return size <= 0;
    }

    public Object[] toArray() {
        ImmutableLinkedList newlinkedlst = copyList(this);
        Object[] arraylst = new Object[size];
        Node curnode = newlinkedlst.head;
        int i = 0;
        while (curnode != null) {
            arraylst[i] = curnode.value;
            curnode = curnode.next;
            i++;
        }
        return arraylst;
    }

    public ImmutableLinkedList addFirst(Object e) {
        return add(0, e);
    }

    public ImmutableLinkedList addLast(Object e) {
        return add(e);
    }

    public Object getFirst() {
        return get(0);
    }

    public Object getLast() {
        return get(size - 1);
    }

    public ImmutableLinkedList removeFirst() {
        return remove(0);
    }

    public ImmutableLinkedList removeLast() {
        return remove(size - 1);
    }


    @Override
    public String toString() {
        ImmutableLinkedList newlinkedlst = copyList(this);
        Node curnode = newlinkedlst.head;
        StringBuilder txt = new StringBuilder();
        txt.append(curnode.value.toString());
        curnode = curnode.next;
        while (curnode.next != null) {
            txt.append(",").append(curnode.value.toString());
            curnode = curnode.next;
        }
        txt.append(",").append(curnode.value.toString());
        return txt.toString();
    }
}