package com.luxoft.datastructures.list;

import com.luxoft.Iterator.Iterator;
import com.luxoft.datastructures.queue.ArrayQueue;
import com.luxoft.datastructures.stack.ArrayStack;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {

    @DisplayName("Is it not empty after adding elements")
    @Test
    public void testIsEmptyReturnFalseIfNotEmpty() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(2);
        assertFalse(arrayList.isEmpty());
    }

    @DisplayName("Is the new list empty")
    @Test
    public void testIsEmptyReturnTrueOnNewList() {
        ArrayStack arrayList = new ArrayStack();

        assertTrue(arrayList.isEmpty());
    }

    @DisplayName("Is the size correct")
    @Test
    public void testAddReturnTrueOnCorrectSize() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(3);
        arrayList.add(9);
        arrayList.add(12);
        assertEquals(3, arrayList.size());
    }

    @DisplayName("Can we correctly use get")
    @Test
    public void testGet() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(3);
        arrayList.add(9);
        arrayList.add(12);
        assertEquals(9, arrayList.get(1));
    }

    @DisplayName("Test CLEAR of method")
    @Test
    public void testClearReturnTrueOnEmptyArray() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.add(4);
        arrayList.clear();

        assertTrue(arrayList.isEmpty());
    }

    @DisplayName("Is the size correct when array is empty")
    @Test
    public void testSizeReturnTrueOnCorrectSize() {
        ArrayList arrayList = new ArrayList();
        assertEquals(0, arrayList.size());
    }

    @DisplayName("Test of CONTAINS method")
    @Test
    public void testContainsReturnTrue() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);

        assertTrue(arrayList.contains(2));
    }

    @DisplayName("Test of CONTAINS method when array is empty")
    @Test
    public void testContainsReturnFalseOnEmptyArray() {
        ArrayList arrayList = new ArrayList();

        assertFalse(arrayList.contains("A"));
    }

    @DisplayName("Test of INDEXOF method")
    @Test
    public void testIndexOfReturnTrue() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");

        assertEquals(2, arrayList.indexOf("C"));
    }

    @DisplayName("Test of LASTINDEXOF method")
    @Test
    public void testLastIndexOfReturnTrue() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");

        assertEquals(3, arrayList.lastIndexOf("D"));
    }

    @DisplayName("Test of REMOVE method")
    @Test
    public void testRemove() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");

        arrayList.remove(2);

        assertEquals("D", arrayList.get(2));
    }

    @DisplayName("Test remove last element")
    @Test
    public void testRemoveReturnTrueIfWorksCorrectly() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.remove(0);

        assertTrue(arrayList.isEmpty());
    }

    @DisplayName("Test of SET method")
    @Test
    public void testSetReturnTrueOnChangedValue() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.set("XXX", 1);

        assertEquals("XXX", arrayList.get(1));
    }


    @DisplayName("is the size changed after set")
    @Test
    public void testAddReturnTrueIfElementAdded() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.set("XXX", 0);

        assertEquals(1, arrayList.size());
    }

    @DisplayName("is the element changed after remove")
    @Test
    public void testAddReturnTrueIfNextElementMoved() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("XXX", 1);
        arrayList.remove(0);

        assertEquals("XXX", arrayList.get(0));
    }

    @DisplayName("test size on empty list")
    @Test
    public void testSizeOnEmptyArray(){
        ArrayList arrayList = new ArrayList();

        assertEquals(0, arrayList.size());
    }

    @DisplayName("test changes in size")
    @Test
    public void testIsTheArrayExpanding(){
        ArrayList arrayList = new ArrayList();
        for(int i = 0; i < 25; i++){

            arrayList.add(i);
        }

        assertTrue(arrayList.size() > 20);
    }

    @DisplayName("test of TOSTRING method")
    @Test
    public void testToStringReturnTrueOnNotEmptyArray(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");

        assertTrue(arrayList.toString().isEmpty() == false);
    }

    @DisplayName("test of TOSTRING method on empty list")
    @Test
    public void testToStringReturnTrueOnEmptyArray(){
        ArrayList arrayList = new ArrayList();

        assertTrue(arrayList.toString().isEmpty());
    }

    @DisplayName("is the iterator can see all of elements")
    @Test
    public void testIteratorReturnTrueOnCorrectSize() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.set("XXX", 1);
        arrayList.add("C");
        arrayList.add("D");
        arrayList.add("E");
        arrayList.add("F");
        arrayList.add("G");
        int counter = 0;
        Iterator iterator = arrayList.getIterator();
        while (iterator.hasNext()){
            counter++;
            iterator.next();
        }
        assertEquals(arrayList.size(), counter);
    }

    @DisplayName("test of HASNEXT method on empty list")
    @Test
    public void testIteratorReturnFalseOnEmptyList() {
        ArrayList arrayList = new ArrayList();
        Iterator iterator = arrayList.getIterator();
        assertFalse(iterator.hasNext());
    }

    @DisplayName("test of HASNEXT method on not empty list")
    @Test
    public void testIteratorReturnFalseOnNotEmptyList() {
        ArrayList arrayList = new ArrayList();
        Iterator iterator = arrayList.getIterator();
        arrayList.add("A");
        assertTrue(iterator.hasNext());
    }

}

//    String toString();