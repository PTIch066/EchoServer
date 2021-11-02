package com.luxoft.datastructures.list;

public class Node {
    private Object value;
    private Node next;
    private Node prev;

    Node(Object value){
        this.value = value;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    public void setPrev(Node prev) {
        this.prev = prev;
    }
    public void setValue(Object value) {
        this.value = value;
    }

    public Node getNext(){
        return next;
    }
    public Node getPrev(){
        return prev;
    }
    public Object getValue(){
        return value;
    }
}
