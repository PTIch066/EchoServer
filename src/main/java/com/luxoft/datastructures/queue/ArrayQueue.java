package com.luxoft.datastructures.queue;

public class ArrayQueue implements Queue {

    private Object[] array;
    private int size = 0;

    public ArrayQueue(){
        array = new Object[10];
    }

    @Override
    public void enqueue(Object value){
        if(size == array.length - 1){
            makeArray();
        }
        array[size] = value;
        size++;
    }

    @Override
    public Object dequeue() {
        if(isEmpty()){
            throw new IllegalStateException("it is empty!");
        }
        Object result = array[0];
        for(int i = 0; i < array.length - 1; i++){
            array[i] = array[i+1];
        }
        array[array.length - 1] = null;
        return result;
    }

    @Override
    public Object peek() {
        return array[0];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        if(array[0] == null){
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object value) {
        for (int i = 0; i < array.length; i++) {
            if(array[i] == value){
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        for (int i = 0; i < array.length; i++) {
            array[i]=null;
        }
        size = 0;
    }

    private void makeArray(){
        int newSize = array.length *2;
        Object[] newArray = new Object[newSize];
        for (int i =0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
}
