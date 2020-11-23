package ua.edu.ucu.collections.immutable;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableLinkedListTest {
    private ImmutableLinkedList linkedList;
    private ImmutableLinkedList linkedEmpty;
    @Before
    public void setUp() {
        linkedList = new ImmutableLinkedList(new Object[] {"button", 6, 'b'});
        linkedEmpty = new ImmutableLinkedList();
    }


    @Test
    public void testPrint() {
        assertEquals(linkedList.toString(), "button, 6, b");
    }

    @Test
    public void testAdd() {
        ImmutableLinkedList new_lst = linkedList.add("fashion");
        assertEquals(new_lst.toString(), "button, 6, b, fashion");
    }

    @Test
    public void testAddToEmpty() {
        ImmutableLinkedList new_lst = linkedEmpty.add("red");
        new_lst = new_lst.add("orange");
        new_lst = new_lst.add("blue");
        assertEquals(new_lst.toString(), "red, orange, blue");
    }

    @Test
    public void testAddAt() {
        ImmutableLinkedList new_lst = linkedList.add(1, "Second");
        System.out.println(new_lst);
        assertEquals(new_lst.toString(), "button, Second, 6, b");
    }

    @Test
    public void testAddAtEmpty() {
        ImmutableLinkedList new_lst = linkedEmpty.add(0,"red");
        new_lst = new_lst.add(1,"orange");
        new_lst = new_lst.add(2,"blue");
        assertEquals(new_lst.toString(), "red, orange, blue");
    }

    @Test
    public void testAddAllTo() {
        ImmutableLinkedList new_lst = linkedList.addAll(new Object[] {"red", 5, "skirt"});
        assertEquals(new_lst.toString(), "button, 6, b, red, 5, skirt");
    }

    @Test
    public void testAddAllEmpty() {
        ImmutableLinkedList empty = linkedEmpty.addAll(new Object[] {"red", 5, "skirt"});
        assertEquals(empty.toString(), "red, 5, skirt");
    }

    @Test
    public void testAddAllByIndex() {
        ImmutableLinkedList new_lst = linkedList.addAll(2, new Object[] {"red", 5, "skirt"});
        assertEquals(new_lst.toString(), "button, 6, red, 5, skirt b");
    }

    @Test
    public void testAddAllByIndexEmpty() {
        ImmutableLinkedList empty = linkedEmpty.addAll(0, new Object[] {"red", 5, "skirt"});
        assertEquals(empty.toString(), "red, 5, skirt");
    }

    @Test
    public void testGet() {
        assertEquals(linkedList.get(2), 'b');
    }

    @Test
    public void testRemove() {
        ImmutableLinkedList new_lst = linkedList.remove(1);
        assertEquals(new_lst.toString(), "button, b");
    }

    @Test
    public void testSet() {
        ImmutableLinkedList new_lst = linkedList.set(1, 7.5);
        assertEquals(new_lst.toString(), "button, 7.5, b");
    }

    @Test
    public void testIndexOf() {
        int index = linkedList.indexOf('b');
        assertEquals(index, 2);
    }

    @Test
    public void testSize() {
        int size = linkedList.size();
        assertEquals(size, 3);
    }

    @Test
    public void testSizeAfterAdding() {
        ImmutableLinkedList new_lst =  linkedList.add(4);
        new_lst = new_lst.addAll(new Object[] {1,2,3,4});
        int size = new_lst.size();
        assertEquals(size, 8);
    }

    @Test
    public void testSizeAfterAddingAndRemoving() {
        ImmutableLinkedList new_lst =  linkedList.addAll(new Object[] {1,2,3,4});
        new_lst = new_lst.remove(1);
        new_lst = new_lst.remove(2);
        new_lst = new_lst.remove(3);
        int size = new_lst.size();
        assertEquals(size, 4);
    }

    @Test
    public void testClear() {
        ImmutableLinkedList new_lst = linkedList.clear();
        int size = new_lst.size();
        assertEquals(size, 0);
    }

    @Test
    public void testIsEmpty() {
        boolean empty = linkedList.isEmpty();
        assertFalse(empty);
    }

    @Test
    public void testIsEmptyTrue() {
        boolean empty = linkedEmpty.isEmpty();
        assertTrue(empty);
    }

    @Test
    public void testToArray() {
        Object[] arr = linkedList.toArray();
        assertArrayEquals(arr, new Object[] {"button", 6, 'b'});
    }

    @Test
    public void testAddFisrt() {
        ImmutableLinkedList new_lst = linkedList.addFirst("First");
        assertEquals(new_lst.toString(), "First, button, 6, b");
    }

    @Test
    public void testAddLast() {
        ImmutableLinkedList new_lst = linkedList.addLast("Last");
        assertEquals(new_lst.toString(), "button, 6, b, Last");
    }

    @Test
    public void testGetFirst() {
        assertEquals(linkedList.getFirst(), "button");
    }

    @Test
    public void testGetLast() {
        assertEquals(linkedList.getLast(), 'b');
    }

    @Test
    public void testRemoveFirst() {
        ImmutableLinkedList list = linkedList.removeFirst();
        assertEquals(list.toString(), "6, b");
    }

    @Test
    public void testRemoveLast() {
        ImmutableLinkedList list = linkedList.removeLast();
        assertEquals(list.toString(), "button, 6");
    }
}
