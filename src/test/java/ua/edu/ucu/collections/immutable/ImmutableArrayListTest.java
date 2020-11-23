package ua.edu.ucu.collections.immutable;


import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ImmutableArrayListTest {
    private ImmutableArrayList array_lst;
    private ImmutableArrayList array_empty;
    @Before
    public void setUp() throws Exception {
        array_lst = new ImmutableArrayList(new Object[] {"button", 6, 'b'});
        array_empty = new ImmutableArrayList();

    }

    @Test
    public void testSomeMethod() {
    }

    @Test
    public void testToString() {
        ImmutableArrayList array_lst = new ImmutableArrayList(new Object[] {"button", 6});
        assertEquals(array_lst.toString(), "button, 6");
    }

    @Test
    public void testAddWithExisting() {
        ImmutableArrayList array_lst = new ImmutableArrayList(new Object[] {"button", 6});
        ImmutableArrayList list = array_lst.add('b');
        assertEquals(list.toString(), "button, 6, b");
    }

    @Test
    public void testAddToEmpty() {
        ImmutableArrayList array_lst = new ImmutableArrayList();
        ImmutableArrayList array_lst2 = array_lst.add('b');
        ImmutableArrayList array_lst3 = array_lst2.add("fashion");
        ImmutableArrayList array_lst4 = array_lst3.add(25.07);
        assertEquals(array_lst.toString(), "b, fashion, 25.07");
    }

    @Test
    public void testAddAtIndex() {
        ImmutableArrayList arraylst = array_lst.add(2, "Java");
        assertEquals(arraylst.toString(), "button, 5, Java, b");
    }

    @Test
    public void testAddAtIndexEmpty() {
        ImmutableArrayList empty_lst = array_empty.add(0, 6);
        assertEquals(empty_lst.toString(), "6");
    }

    @Test
    public void testAddAllEmpty() {
        ImmutableArrayList empty_lst = array_empty.addAll(new Object[] {"red", 5, "skirt"});
        assertEquals(empty_lst.toString(), "red, 5, skirt");
    }

    @Test
    public void testAddAllTo() {
        ImmutableArrayList arraylst = array_lst.addAll(new Object[] {"red", 5, "skirt"});
        assertEquals(arraylst.toString(), "button, 6, b, red, 5, skirt");
    }

    @Test
    public void testAddAllByIndex() {
        ImmutableArrayList arraylst = array_lst.addAll(2, new Object[] {"red", 5, "skirt"});
        assertEquals(arraylst.toString(), "button, 6, red, 5, skirt, b");
    }

    @Test
    public void testGet() {
        Object elem = array_lst.get(1);
        assertEquals(elem, 6);
    }

    @Test
    public void testRemove() {
        ImmutableArrayList arraylst = array_lst.remove(1);
        assertEquals(arraylst.toString(), "button, b");
    }

    @Test
    public void testSet() {
        ImmutableArrayList arraylst = array_lst.set(1, 8.9);
        assertEquals(arraylst.toString(), "button, 8.9, b");
    }

    @Test
    public void testIndexOf() {
        int index = array_lst.indexOf('b');
        assertEquals(index, 2);
    }

    @Test
    public void testSize() {
        int size = array_lst.size();
        assertEquals(size, 3);
    }

    @Test
    public void testSizeAfterAdding() {
        ImmutableArrayList arraylst = array_lst.add(4);
        int size = arraylst.size();
        assertEquals(size, 4);
    }

    @Test
    public void testClear() {
        ImmutableArrayList arraylst = array_lst.clear();
        int size = arraylst.size();
        assertEquals(size, 0);
    }

    @Test
    public void testIsEmpty() {
        boolean empty = array_lst.isEmpty();
        assertFalse(empty);
    }

    @Test
    public void testIsEmptyTrue() {
        ImmutableArrayList arraylst = new ImmutableArrayList();
        boolean empty = arraylst.isEmpty();
        assertTrue(empty);
    }

    @Test
    public void testToArray() {
        Object[] arr = array_lst.toArray();
        assertArrayEquals(arr, new Object[] {"button", 6, 'b'});
    }

}
