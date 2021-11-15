package com.luxoft.datastructures.list;

import java.util.Iterator;
import java.util.StringJoiner;

public class ArrayList<T> implements List<T> {
    private T[] array;
    private int size = 0;

    ArrayList() {
        array = (T[]) new Object[10];
    }

    @Override
    public void add(T value) {
        add(value, size);
    }

    @Override
    public void add(T value, int index) {
        verifyIsNull(value);
        verifyIndexBelowZero(index);
        if (index > size) {
            throw new IndexOutOfBoundsException("Your index is bigger than available size");
        }
        if (size == array.length) {
            resizeArray();
        }

        System.arraycopy(array, index, array, index + 1, size - index);
        array[index] = value;
        size++;
    }

    @Override
    public T remove(int index) {
        verifyIndexOutOfSize(index);
        verifyIndexBelowZero(index);
        T value = array[index];

        System.arraycopy(array, index + 1, array, index, size - index);

        array[--size] = null;
        return value;
    }

    @Override
    public T get(int index) {
        verifyIndexOutOfSize(index);
        verifyIndexBelowZero(index);
        return array[index];
    }

    @Override
    public T set(T value, int index) {
        verifyIndexOutOfSize(index);
        verifyIndexBelowZero(index);

        verifyIsNull(value);

        array[index] = value;
        return array[index];
    }

    @Override
    public void clear() {
        for (int i = 0; i < size; i++) {
            array[i] = null;
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
        verifyIsNull(value);
        for (int i = 0; i < size; i++) {
            if (array[i] == value) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(T value) {
        verifyIsNull(value);
        for (int i = size; i >= 0; i--) {
            if (array[i] == value) {
                return i;
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
        for (T value : this) {
            stringJoiner.add(value.toString());
        }

        return stringJoiner.toString();
    }

    private void resizeArray() {
        int size = (int) (array.length * 1.5);
        T[] newArray = (T[]) new Object[size];
        for (int i = 0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }

    private void verifyIndexOutOfSize(int index) {
        if (index >= size) {
            throw new IndexOutOfBoundsException("Your index is bigger than available size");
        }
    }

    private void verifyIndexBelowZero(int index) {
        if (index < 0) {
            throw new IndexOutOfBoundsException("Your index is below zero");
        }
    }

    private void verifyIsNull(T value) {
        if (value == null) {
            throw new NullPointerException("You can not add null");
        }
    }

    @Override
    public Iterator iterator() {
        return new listIterator();
    }

    private class listIterator implements Iterator {

        private int index;

        @Override
        public boolean hasNext() {
            return index < size;
        }

        @Override
        public T next() {
            index++;
            return get(index - 1);
        }
    }
}
