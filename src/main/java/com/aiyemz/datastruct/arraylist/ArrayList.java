package com.aiyemz.datastruct.arraylist;

import com.aiyemz.datastruct.list.AbstractList;

/**
 * 动态数组
 */

public class ArrayList<E> extends AbstractList<E> {

    private E[] elements;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList() {
        this(DEFAULT_CAPACITY);
    }

    public ArrayList(int capacity) {
        capacity = capacity >= DEFAULT_CAPACITY ? capacity: DEFAULT_CAPACITY;
        elements = (E[]) new Object[capacity];
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        // 是否扩容
        ensureCapacity(size+1);
        System.arraycopy(elements, index, elements, index+1, size-index);
        elements[index] = element;
        size++;
    }

    @Override
    public E get(int index) {
        rangeCheck(index);
        return elements[index];
    }

    @Override
    public E set(int index, E element) {
        rangeCheck(index);
        E oldElement = elements[index];
        elements[index] = element;
        return oldElement;
    }

    @Override
    public E remove(int index) {
        rangeCheck(index);
        E element = elements[index];
        System.arraycopy(elements, index+1, elements,index , size-index-1); //  2 3 5 6 7 9   index:1
        elements[--size] = null;  // 将最后一个元素设置为 null                               //  2 5 6 7 9 9
        return element;
    }

    @Override
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

    @Override
    public void clear() {
        size = 0;
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
