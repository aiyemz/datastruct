package com.aiyemz.datastruct.arraylist;

/**
 * 动态数组
 */

public class ArrayList<E> {

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


    public int size() {
        return 0;
    }

    public boolean isEmpty() {
        return true;
    }

    public boolean contains(E element) {
        return true;
    }

    public void add(E element) {

    }

    public void add(int index, E element) {

    }

    public E get(int index) {
        return null;
    }

    public E set(int index, E element) {
        return null;
    }

    public E remove(int index) {
        return null;
    }

    public int indexOf(E element) {
        return 0;
    }

    public void clear() {

    }

}
