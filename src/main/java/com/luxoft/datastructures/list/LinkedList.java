package com.luxoft.datastructures.list;

import java.util.Iterator;
import java.util.StringJoiner;

public class LinkedList<T> implements List<T> {

    private Node<T> head;
    private Node<T> tail;
    private int size = 0;

    @Override
    public void add(T value) {
        add(value, size);
    }

    @Override
    public void add(T value, int index) {
        verifyIsNull(value);
        if (index < 0) {
            throw new IndexOutOfBoundsException("Your index is below zero");
        }
        if (index > size) {
            throw new IndexOutOfBoundsException("Your index is bigger than available size");
        }

        Node<T> newNode = new Node<>(value);

        if (isEmpty()) {
            head = tail = newNode;
        } else if (index == 0) {
            head.prev = newNode;
            newNode.next = head;
            head = newNode;
        } else if (index == size) {
            newNode.prev = tail;
            tail.next = newNode;
            tail = newNode;
        } else {
            Node<T> current = getNode(index);

            newNode.next = current;
            newNode.prev = current.prev;
            (current.prev).next = newNode;
            current.prev = newNode;
        }
        size++;
    }

    @Override   public T remove(int index) {
        verifyBounds(index);
        Node<T> res = new Node<>(null);
        if (size == 1) {
            res = head;
            clear();
        } else if (index == 0) {
            res = head;
            head = head.next;
            head.prev = null;
        } else if (index == size - 1) {
            res = tail;
            tail = tail.prev;
            tail.next = null;
        } else {
            Node<T> current = getNode(index);
            current.prev.next = current.next;
            current.next.prev = current.prev;
        }
        size--;
        return res.getValue();
    }

    @Override
    public T get(int index) {
        verifyBounds(index);
        return getNode(index).value;
    }

    @Override
    public T set(T value, int index) {
        verifyIsNull(value);
        verifyBounds(index);
        Node<T> current = getNode(index);
        current.value = value;

        return current.getValue();
    }

    @Override
    public void clear() {
        for (T value : this) {
            value = null;
        }

        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(T value) {
        return indexOf(value) != -1;
    }

    @Override
    public int indexOf(T value) {
        Node<T> current = head;
        for (int i = 0; i < size; i++) {
            if (current.value.equals(value)) {
                return i;
            } else {
                current = current.next;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T value) {
        Node<T> current = tail;
        for (int i = size - 1; i >= 0; i--) {
            if (current.value.equals(value)) {
                return i;
            } else {
                current = current.prev;
            }
        }
        return -1;
    }

    @Override
    public String toString() {
        if (isEmpty()) {
            return "";
        }

        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        for (T current : this) {
            stringJoiner.add(String.valueOf(current));
        }

        return stringJoiner.toString();
    }

    private void verifyBounds(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Your index is bigger than available size");
        }
        if (index < 0) {
            throw new IndexOutOfBoundsException("Your index is below zero");
        }
    }

    private void verifyIsNull(T value) {
        if (value == null) {
            throw new NullPointerException("You can not add null");
        }
    }

    private static class Node<T> {
        private T value;
        private Node<T> next;
        private Node<T> prev;

        Node(T value) {
            this.value = value;
        }

        private T getValue() {
            return value;
        }

    }

    private Node<T> getNode(int index) {
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current;
    }

    @Override
    public Iterator<T> iterator() {
        return new LinkedIterator();
    }

    private class LinkedIterator implements Iterator<T> {
        private Node<T> current = head;
        private int index = 0;

        @Override
        public void remove() {

            if(hasNext()) {
                current = current.next;
            } else if (size != 1){
                current = current.prev;
            }
            LinkedList.this.remove(index);
            index--;
        }

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            T value = current.value;
            current = current.next;
            index++;
            return value;
        }
    }
}
