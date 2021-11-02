package com.luxoft.datastructures.list;


import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class LinkedListTest {

    @Test
    public void testIsEmptyReturnFalseIfNotEmpty() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(2);
        assertFalse(linkedList.isEmpty());
    }
    @Test
    public void testIsEmptyReturnTrueOnNewList() {
        LinkedList linkedList = new LinkedList();

        assertTrue(linkedList.isEmpty());
    }

    @Test
    public void testAddReturnTrueOnCorrectSize() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(3);
        linkedList.add(9);
        linkedList.add(12);
        assertEquals(3,linkedList.size());
    }

    @Test
    public void testGet() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(3);
        linkedList.add(9);
        linkedList.add(12);
        assertEquals(9, linkedList.get(1));
    }

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

    @Test
    public void testSizeReturnTrueOnCorrectSize() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");
        assertEquals(4, linkedList.size());
    }

    @Test
    public void testContainsReturnTrue() {
        LinkedList linkedList = new LinkedList();
        linkedList.add(1);
        linkedList.add(2);

        assertTrue(linkedList.contains(2));
    }

    @Test
    public void testContainsReturnFalseOnEmptyLinked() {
        LinkedList linkedList = new LinkedList();

        assertFalse(linkedList.contains("A"));
    }

    @Test
    public void testIndexOfReturnTrue() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");

        assertEquals(2, linkedList.indexOf("C"));
    }

    @Test
    public void testLastIndexOfReturnTrue() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.add("C");
        linkedList.add("D");

        assertEquals(3, linkedList.lastIndexOf("D"));
    }

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

    @Test
    public void testRemoveReturnTrueIfWorksCorrectly() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.remove(0);

        assertTrue(linkedList.isEmpty());
    }

    @Test
    public void testSetReturnTrueOnChangedValue() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.set("XXX", 1);

        assertEquals("XXX", linkedList.get(1));
    }


    @Test
    public void testAddReturnTrueIfElementAdded() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.set("XXX", 1);

        assertEquals("XXX", linkedList.get(1));
    }

    @Test
    public void testAddReturnTrueIfNextElementMoved() {
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");
        linkedList.add("B");
        linkedList.set("XXX", 1);

        assertEquals("XXX", linkedList.get(1));
    }

    @Test
    public void testSizeOnEmptyLinked(){
        LinkedList linkedList = new LinkedList();

        assertEquals(0, linkedList.size());
    }

    @Test
    public void testIsTheLinkedExpanding(){
        LinkedList linkedList = new LinkedList();
        for(int i = 0; i < 25; i++){

            linkedList.add(i);
        }

        assertTrue(linkedList.size() > 20);
    }

    @Test
    public void testToStringReturnTrueOnNotEmptyLinked(){
        LinkedList linkedList = new LinkedList();
        linkedList.add("A");

        System.out.println(linkedList.toString());
        assertTrue(linkedList.toString().isEmpty() == false);
    }
}