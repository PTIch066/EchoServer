package com.luxoft.datastructures.list;

import java.sql.SQLOutput;
import java.util.StringJoiner;

public class LinkedList implements List{

    Node head;
    Node tail;
    int size = 0;

    @Override
    public void add(Object value) {
        if(isEmpty()) {
            Node newNode = new Node(value);
            head = tail = newNode;
        } else {
            Node newNode = new Node(value);
            newNode.setPrev(tail);
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    @Override
    public void add(Object value, int index) {
        if (index == size) {
            add(value);
        } else {
            Node newNode = new Node(value);
            Node current = head;
            for (int i = 0; i < index; i++) {
                current = current.getNext();
            }
            newNode.setNext(current.getNext());
            newNode.setPrev(current);
            size++;
        }
    }

    @Override
    public Object remove(int index) {
        if(index > size){
            throw new IndexOutOfBoundsException("incorrect index");
        }
        if(size == 1){
            Node res = head;
            clear();
            return res;
        }
        if(index == 0){
            Node res = head;
            head = head.getNext();
            head.setPrev(null);
            size--;
            return res;
        }
        if(index == size -1){
            Node res = tail;
            tail = tail.getPrev();
            tail.setNext(null);
            size--;
            return res;
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        current.getPrev().setNext(current.getNext());
        current.getNext().setPrev(current.getPrev());
        size--;
        return current;
    }

    @Override
    public Object get(int index) {
        if(index >= size){
            throw new IndexOutOfBoundsException("incorrect index");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        return current.getValue();
    }

    @Override
    public Object set(Object value, int index) {
        if(index > size){
            throw new IndexOutOfBoundsException("incorrect index");
        }
        Node current = head;
        for (int i = 0; i < index; i++) {
            current = current.getNext();
        }
        current.setValue(value);

        return current;
    }

    @Override
    public void clear() {
        Node current = head;
        while (current != tail){
            current = current.getNext();
            current.setPrev(null);
        }
        head.setNext(null);
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
    public boolean contains(Object value) {
        if(isEmpty()){
            return false;
        }
        Node current = head;
        for (int i = 0; i < size; i++){
            if (current.getValue() == value) {
                return true;
            }
            current = current.getNext();
        }
        return false;
    }

    @Override
    public int indexOf(Object value) {
        Node current = head;
        for (int i = 0; i < size; i++){

            if (current.getValue() == value) {
                return i;
            } else {
                current = current.getNext();
            }
        }
        return 0;
    }

    @Override
    public int lastIndexOf(Object value) {
        Node current = tail;
        for (int i = size -1; i >= 0; i--){
            if (current.getValue() == value) {
                return i;
            } else {
                current = current.getPrev();
            }
        }
        return 0;
    }

    @Override
    public String toString() {
        StringJoiner stringJoiner = new StringJoiner(", ", "[", "]");
        Node current = head;
        while (current != null) {
            stringJoiner.add(current.getValue().toString());
            current = current.getNext();
        }

        return stringJoiner.toString();
    }
}
