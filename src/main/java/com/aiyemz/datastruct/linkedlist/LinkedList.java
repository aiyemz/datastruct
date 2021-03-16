package com.aiyemz.datastruct.linkedlist;

import com.aiyemz.datastruct.list.AbstractList;

/**
 * 双向链表
 */
public class LinkedList<E> extends AbstractList<E> {

    private Node<E> head;
    private Node<E> last;

    private class Node<E> {
        private Node<E> prev;
        private E element;
        private Node<E> next;

        public Node(Node<E> prev, E element, Node<E> next) {
            this.prev = prev;
            this.element = element;
            this.next = next;
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
        Node<E> node = head;
        if (element == null) {
            for (int i=0; node != null; i++) {
                if (node.element == null) {
                   return i;
                }
                node = node.next;
            }
        } else {
            for (int i=0; node != null; i++) {
                if (element.equals(node.element)) {
                    return i;
                }
                node = node.next;
            }
        }
        return ELEMENT_NOT_FOUND;
    }

    @Override
    public void clear() {
        size = 0;
        head = null;
        last = null;
    }

    public Node<E> curNode(int index) {
        rangeCheck(index);
        if (index < size/2) {
            Node<E> node = head;
            for (int i=0; i<index; i++) {
                head = head.next;
            }
            return node;
        } else {
            Node<E> node = last;
            for (int i=size-1; i>index; i--) {
                node = node.prev;
            }
            return node;
        }
    }
}
