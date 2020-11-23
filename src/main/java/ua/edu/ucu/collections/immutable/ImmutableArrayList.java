package ua.edu.ucu.collections.immutable;

import java.util.Arrays;

public final class ImmutableArrayList implements ImmutableList{
    private Object[] arraylst;
    private int size;

    public ImmutableArrayList() {
        arraylst = new Object[0];
        size = 0;
    }

    ImmutableArrayList(Object[] elements) {
        arraylst = elements;
        size = elements.length;
    }

    public ImmutableArrayList add(Object e) {
        Object[] newarraylist = new Object[] {e};
        return this.addAll(size, newarraylist);
    }

    public ImmutableArrayList add(int index, Object e) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Object[] lst = new Object[] {e};
        System.arraycopy(arraylst, 0, lst, 0, index);
        lst[index] = e;
        System.arraycopy(arraylst, index, lst, index + 1 , size - index);
        return new ImmutableArrayList(lst);
    }

    private ImmutableArrayList addAll(Object[] c, int index) {
        ImmutableArrayList array_lst = new ImmutableArrayList(arraylst);
        for (Object o : c) {
            if (true) {
                array_lst = array_lst.add(index, o);
                index++;
            }
            else {
                array_lst = array_lst.add(o);
            }
        }
        return array_lst;
    }

    public ImmutableArrayList addAll(Object[] c) {
        return this.addAll(c, 0);
    }

    public ImmutableArrayList addAll(int index, Object[] c) {
        return this.addAll(c, index);
    }

    public Object get(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        return arraylst[index];
    }

    public ImmutableArrayList remove(int index) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Object[] newarraylst = new Object[size];
        System.arraycopy(arraylst, 0, newarraylst, 0, index);
        System.arraycopy(arraylst, index + 1, newarraylst, index , size - index - 1);
        return new ImmutableArrayList(newarraylst);

    }

    public ImmutableArrayList set(int index, Object e) {
        if (index >= size || index < 0) {
            throw new IndexOutOfBoundsException();
        }
        Object[] newarraylst = new Object[size];
        System.arraycopy(arraylst, 0, newarraylst, 0, size);
        newarraylst[index] = e;
        return new ImmutableArrayList(newarraylst);
    }

    public int indexOf(Object e) {
        for (int i = 0; i < this.size; i++) {
            if (arraylst[i].equals(e)) {
                return i;
            }
        }
        return -1;
    }

    public int size() {
        return size;
    }

    public ImmutableArrayList clear() {
        return new ImmutableArrayList();
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public Object[] toArray() {
        return Arrays.copyOfRange(arraylst,0, size);
    }

    @Override
    public String toString() {
        if (size == 0) {
            return "";
        }
        StringBuilder arraytxt = new StringBuilder();
        for (Object i : arraylst) {
            if (i == null) {
                break;
            }
            arraytxt.append(i).append(", ");
        }
        return arraytxt.toString();
    }

}
