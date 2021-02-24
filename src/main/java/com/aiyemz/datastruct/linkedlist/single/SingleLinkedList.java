package com.aiyemz.datastruct.linkedlist.single;

import com.aiyemz.datastruct.list.AbstractList;

public class SingleLinkedList<E> extends AbstractList<E> {

    private Node<E> head;

    private class Node<E> {
        private E element;
        private Node<E> nextNode;

        public Node(E element, Node<E> nextNode) {
            this.element = element;
            this.nextNode = nextNode;
        }
    }


    @Override
    public void add(int index, E element) {

    }

    @Override
    public E get(int index) {
        return curNode(index).element;
    }

    @Override
    public E set(int index, E element) {
        Node<E> node = curNode(index);
        E oldElement = node.element;
        node.element = element;
        return oldElement;
    }

    @Override
    public E remove(int index) {
        return null;
    }

    @Override
    public int indexOf(E element) {
        if (element == null) {

        } else {

        }
        return 0;
    }

    @Override
    public void clear() {
        head = null;
        size = 0;
    }

    private Node<E> curNode(int index) {
        rangeCheck(index);
        Node<E> node = head;
        for (int i=0; i<index; i++) {
            node = node.nextNode;
        }
        return node;
    }
}
