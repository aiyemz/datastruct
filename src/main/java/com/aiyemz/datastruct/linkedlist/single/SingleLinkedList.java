package com.aiyemz.datastruct.linkedlist.single;

import com.aiyemz.datastruct.list.AbstractList;

/**
 * 不带头结点的单向链表
 * @param <E>
 */
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
        rangeCheckForAdd(index);
        if (index == 0) {
            head = new Node<>(element, head);
        } else {
            Node<E> prev = curNode(index - 1);
            prev.nextNode = new Node<>(element,prev.nextNode);
        }
        size++;
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
        rangeCheck(index);
        Node<E> node = head;
        if (index == 0) {
            head = head.nextNode;
        } else {
            Node<E> prev = curNode(index - 1);
            node = prev.nextNode;
            prev.nextNode = node.nextNode;
        }
        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = head;
        if (element == null) {
            for (int i=0; node != null; i++) {
                if (node.element == null) {
                    return i;
                }
                node = node.nextNode;
            }
        } else {
            for (int i=0; node != null; i++) {
                if (element.equals(node.element)) {
                    return i;
                }
                node = node.nextNode;
            }
        }
        return ELEMENT_NOT_FOUND;
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
