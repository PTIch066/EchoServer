package com.luxoft.datastructures.list;

public class ArrayList implements List {
    private Object[] array;
    private int size = 0;

    ArrayList(){
        array = new Object[10];
    }

    @Override
    public void add(Object value) {
        if (size == array.length-1) {
            makeArray();
        }
        array[size] = value;
        size++;
    }

    @Override
    public void add(Object value, int index) {
        if (index+1 == array.length-1) {
            makeArray();
        }
        if(index > size){
            throw new IndexOutOfBoundsException("incorrect index");
        }
        for (int i = index; i < array.length-1; i++) {
            array[i+1]=array[i];
            array[index] = value;
        }
        size++;
    }

    @Override
    public Object remove(int index) {
        if(isEmpty()){
            throw new IllegalStateException("it is empty!");
        }
        Object value = array[index];
        for (int i = index; i < array.length-1; i++) {
            array[i]=array[i+1];
        }
        size--;
        return value;
    }

    @Override
    public Object get(int index) {
        if(index > size-1){
            throw new IndexOutOfBoundsException("incorrect index");
        }
        return array[index];
    }

    @Override
    public Object set(Object value, int index) {
        if(index > size-1){
            throw new IndexOutOfBoundsException("incorrect index");
        }
        array[index] = value;
        return array[index];
    }

    @Override
    public void clear() {
        for(int i = 0; i < array.length;i++){
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
        if(size == 0){
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(Object value) {
        for(int i = 0; i < array.length; i++){
            if(array[i] == value){
                return true;
            }
        }
        return false;
    }

    @Override
    public int indexOf(Object value) {
        for(int i = 0; i < array.length; i++){
            if(array[i] == value){
                return i;
            }
        }
        return 0;
    }

    @Override
    public int lastIndexOf(Object value) {
        for(int i = array.length-1; i >=0; i--){
            if(array[i] == value){
                return i;
            }
        }
        return 0;
    }

    @Override
    public String toString(){
        StringBuilder result = new StringBuilder();
        for(int i =0; array[i] != null; i++){
            result.append("№ " + i + " = " + array[i] + " " + "\n");
        }
        return result.toString();
    }

    private void makeArray(){
        int newSize = (int)(array.length *1.5);
        Object[] newArray = new Object[newSize];
        for (int i =0; i < array.length; i++) {
            newArray[i] = array[i];
        }
        array = newArray;
    }
}
