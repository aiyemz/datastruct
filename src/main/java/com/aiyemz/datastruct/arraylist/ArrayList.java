package com.aiyemz.datastruct.arraylist;

/**
 * 动态数组
 */

public class ArrayList<E> {

    private E[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;
    private static final int ELEMENT_NOT_FOUND = -1;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int capacity) {
        capacity = capacity >= DEFAULT_CAPACITY ? capacity: DEFAULT_CAPACITY;
        elements = (E[]) new Object[capacity];
    }


    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean contains(E element) {
        if (element == null) {
            for (int i=0; i<elements.length; i++) {
                if (elements[i] == null) {
                    return true;
                }
            }
        } else {
            for (int i=0; i<elements.length; i++) {
                if (element.equals(elements[i])) {
                    return true;
                }
            }
        }
        return false;
    }

    public void add(E element) {
        add(size, element);
    }

    public void add(int index, E element) {
        rangeCheckForAdd(index);
        // 是否扩容
        ensureCapacity(size+1);
        System.arraycopy(elements, index, elements, index+1, size-index);
        elements[index] = element;
        size++;
    }

    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    public E set(int index, E element) {
        rangeCheck(index);
        E oldElement = elements[index];
        elements[index] = element;
        return oldElement;
    }

    public E remove(int index) {
        rangeCheck(index);
        E element = elements[index];
        System.arraycopy(elements, index+1, elements,index , size-index-1); //  2 3 5 6 7 9   index:1
        elements[--size] = null;  // 将最后一个元素设置为 null                               //  2 5 6 7 9 9
        return element;
    }

    public int indexOf(E element) {
        if (element == null) {
            for (int i=0; i<elements.length; i++) {
                if (elements[i] == null) {
                    return i;
                }
            }
        } else {
            for (int i=0; i<elements.length; i++) {
                if (element.equals(elements[i])) {
                    return i;
                }
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    public void clear() {
        size = 0;
    }

    public void rangeCheck(int index) {
        if (index<0 || index>=size) {
            outOfBounds(index);
        }
    }

    public void rangeCheckForAdd(int index) {
        if (index<0 || index>size) {
            outOfBounds(index);
        }
    }

    public void outOfBounds(int index) {
        throw new IndexOutOfBoundsException("Index:" + index + ", Size:" + size);
    }

    private void ensureCapacity(int capacity) { // 10 size:9
        int oldLength = elements.length;
        if (capacity <= oldLength) {
            return;
        }
        int newLength = oldLength + oldLength/2;
        E[] newElements = (E[])new Object[newLength];
        System.arraycopy(elements, 0, newElements, 0, size);
    }

}
