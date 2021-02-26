package com.aiyemz.datastruct.linkedlist.single;

import com.aiyemz.datastruct.list.AbstractList;

/**
 * 带头结点的单向循环链表
 * @param <E>
 */
public class SingleLinkedListWithHead<E> extends AbstractList<E> {

    private Node<E> head;

    private class Node<E> {
        private E element;
        private Node<E> nextNode;

        public Node(E element, Node<E> nextNode) {
            this.element = element;
            this.nextNode = nextNode;
        }
    }

    public SingleLinkedListWithHead() {
        head = new Node<>(null, null);
    }

    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        Node<E> prev = index == 0? head:curNode(index - 1);
        prev.nextNode = new Node<>(element, prev.nextNode);
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
        Node<E> prev = index==0? head: curNode(index - 1);
        Node<E> node = prev.nextNode;
        prev.nextNode = node.nextNode;
        size--;
        return node.element;
    }

    @Override
    public int indexOf(E element) {
        Node<E> node = head.nextNode;
        if (element == null) {
            for (int i=0; node!=null; i++) {
                if (element == null) {
                    return i;
                }
                node = node.nextNode;
            }
        } else {
            for (int i=0; node!=null; i++) {
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
        Node<E> node = head.nextNode;
        for (int i=0; i<index; i++) {
            node = node.nextNode;
        }
        return node;
    }
}
