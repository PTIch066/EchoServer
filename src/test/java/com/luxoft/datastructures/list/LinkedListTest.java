package com.luxoft.datastructures.list;


import com.luxoft.Iterator.Iterator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinkedListTest {

    @DisplayName("Is it not empty after adding elements")
    @Test
    public void testIsEmptyReturnFalseIfNotEmpty() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(2);
        assertFalse(linkedList.isEmpty());
    }

    @DisplayName("Is the new list empty")
    @Test
    public void testIsEmptyReturnTrueOnNewList() {
        LinkedList linkedList = new LinkedList();

        assertTrue(linkedList.isEmpty());
    }

    @DisplayName("Is the size correct")
    @Test
    public void testAddReturnTrueOnCorrectSize() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(3);
        linkedList.add(9);
        linkedList.add(12);
        assertEquals(3,linkedList.size());
    }

    @DisplayName("Can we correctly use get")
    @Test
    public void testGet() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(3);
        linkedList.add(9);
        linkedList.add(12);
        assertEquals(9, linkedList.get(1));
    }

    @DisplayName("Test CLEAR of method")
    @Test
    public void testClearReturnTrueOnEmptyLinked() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.add(4);
        linkedList.clear();

        assertTrue(linkedList.isEmpty());
    }

    @DisplayName("Is the size correct when array is empty")
    @Test
    public void testSizeReturnTrueOnCorrectSize() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
        assertEquals(4, linkedList.size());
    }

    @DisplayName("Test of CONTAINS method")
    @Test
    public void testContainsReturnTrue() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);

        assertTrue(linkedList.contains(2));
    }

    @DisplayName("Test of CONTAINS method when list is empty")
    @Test
    public void testContainsReturnFalseOnEmptyLinked() {
        LinkedList linkedList = new LinkedList();

        assertFalse(linkedList.contains("A"));
    }

    @DisplayName("Test of INDEXOF method")
    @Test
    public void testIndexOfReturnTrue() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");

        assertEquals(2, linkedList.indexOf("C"));
    }

    @DisplayName("Test of LASTINDEXOF method")
    @Test
    public void testLastIndexOfReturnTrue() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");

        assertEquals(3, linkedList.lastIndexOf("D"));
    }

    @DisplayName("Test of REMOVE method")
    @Test
    public void testRemoveReturnTrueOnEmptyLinked() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");

        linkedList.remove(2);

        assertEquals("D", linkedList.get(2));
    }

    @DisplayName("Test remove last element")
    @Test
    public void testRemoveReturnTrueIfWorksCorrectly() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.remove(0);

        assertTrue(linkedList.isEmpty());
    }

    @DisplayName("Test of SET method")
    @Test
    public void testSetReturnTrueOnChangedValue() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.set("XXX", 1);

        assertEquals("XXX", linkedList.get(1));
    }

    @DisplayName("is the size changed after set")
    @Test
    public void testAddReturnTrueIfElementAdded() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.set("XXX", 0);

        assertEquals(1, linkedList.size());
    }

    @DisplayName("is the element changed after remove")
    @Test
    public void testAddReturnTrueIfNextElementMoved() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.set("XXX", 1);
        linkedList.remove(0);

        assertEquals("XXX", linkedList.get(0));
    }

    @DisplayName("test size on empty list")
    @Test
    public void testSizeOnEmptyLinked(){
        LinkedList linkedList = new LinkedList();

        assertEquals(0, linkedList.size());
    }

    @DisplayName("test changes in size")
    @Test
    public void testIsTheLinkedExpanding(){
        LinkedList linkedList = new LinkedList();
        for(int i = 0; i < 25; i++){

            linkedList.add(i);
        }

        assertTrue(linkedList.size() > 20);
    }

    @DisplayName("test of TOSTRING method")
    @Test
    public void testToStringReturnTrueOnNotEmptyLinked(){
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");

        System.out.println(linkedList.toString());
        assertTrue(linkedList.toString().isEmpty() == false);
    }

    @DisplayName("is the iterator can see all of elements")
    @Test
    public void testIteratorReturnTrueOnCorrectSize() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.set("XXX", 1);
        linkedList.add("C");
        linkedList.add("D");
        linkedList.add("E");
        linkedList.add("F");
        linkedList.add("G");
        int counter = 0;
        Iterator iterator = linkedList.getIterator();
        while (iterator.hasNext()){
            counter++;
            iterator.next();
        }
        assertEquals(linkedList.size(), counter);
    }

    @DisplayName("test of HASNEXT method on empty list")
    @Test
    public void testIteratorReturnFalseOnEmptyList() {
        LinkedList linkedList = new LinkedList();
        Iterator iterator = linkedList.getIterator();
        assertFalse(iterator.hasNext());
    }

    @DisplayName("test of HASNEXT method on not empty list")
    @Test
    public void testIteratorReturnFalseOnNotEmptyList() {
        LinkedList linkedList = new LinkedList();
        Iterator iterator = linkedList.getIterator();
        linkedList.add("A");
        assertTrue(iterator.hasNext());
    }
}