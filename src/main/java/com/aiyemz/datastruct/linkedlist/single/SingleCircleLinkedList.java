package com.aiyemz.datastruct.linkedlist.single;

import com.aiyemz.datastruct.list.AbstractList;

/**
 * 单向循环链表
 * @param <E>
 */
public class SingleCircleLinkedList<E> extends AbstractList<E> {

    private Node<E> head;

    private class Node<E> {
        private E element;
        private Node<E> nextNode;

        public Node(E element, Node<E> nextNode) {
            this.element = element;
            this.nextNode = nextNode;
        }

        @Override
        public String toString() {
            StringBuilder sb = new StringBuilder();
            sb.append(element).append("_").append(nextNode.element);
            return sb.toString();
        }
    }


    @Override
    public void add(int index, E element) {
        rangeCheckForAdd(index);
        if (index == 0) {
            Node<E> newHead = new Node<>(element, head);
            // 查找最后一个元素
            Node<E> last = size==0? newHead: curNode(size-1);
            last.nextNode = newHead;
            head = newHead;
        } else {
            Node<E> prev = curNode(index - 1);
            prev.nextNode = new Node<>(element, prev.nextNode);
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
            if (size == 1) {
                head = null;
            } else {
                Node<E> last = curNode(size - 1);
                head = head.nextNode; // 删除元素
                last.nextNode = head;
            }
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
            for (int i=0; node!=null; i++) {
                if (node.element == null) {
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
        Node<E> node = head;
        for (int i=0; i<index; i++) {
            node = node.nextNode;
        }
        return node;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        string.append("size=").append(size).append(", [");
        Node<E> node = head;
        for (int i = 0; i < size; i++) {
            if (i != 0) {
                string.append(", ");
            }
            string.append(node);
            node = node.nextNode;
        }
        string.append("]");
        return string.toString();
    }

    public static void main(String[] args) {
        SingleCircleLinkedList<String> stringSingleCircleLinkedList = new SingleCircleLinkedList<>();
        stringSingleCircleLinkedList.add("1");
        stringSingleCircleLinkedList.add("3");
        stringSingleCircleLinkedList.add("7");
        stringSingleCircleLinkedList.add("5");
        stringSingleCircleLinkedList.add(0, "10");
        System.out.println(stringSingleCircleLinkedList);
    }

}
