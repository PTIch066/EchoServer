package com.luxoft.datastructures.list;

import com.luxoft.datastructures.queue.ArrayQueue;
import com.luxoft.datastructures.stack.ArrayStack;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayListTest {
    @Test
    public void testIsEmptyReturnFalseIfNotEmpty() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(2);
        assertFalse(arrayList.isEmpty());
    }
    @Test
    public void testIsEmptyReturnTrueOnNewList() {
        ArrayStack arrayList = new ArrayStack();

        assertTrue(arrayList.isEmpty());
    }

    @Test
    public void testAddReturnTrueOnCorrectSize() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(3);
        arrayList.add(9);
        arrayList.add(12);
        assertEquals(3, arrayList.size());
    }

    @Test
    public void testGet() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(3);
        arrayList.add(9);
        arrayList.add(12);
        assertEquals(9, arrayList.get(1));
    }

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

    @Test
    public void testSizeReturnTrueOnCorrectSize() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");
        assertEquals(4, arrayList.size());
    }

    @Test
    public void testContainsReturnTrue() {
        ArrayList arrayList = new ArrayList();
        arrayList.add(1);
        arrayList.add(2);

        assertTrue(arrayList.contains(2));
    }

    @Test
    public void testContainsReturnFalseOnEmptyArray() {
        ArrayList arrayList = new ArrayList();

        assertFalse(arrayList.contains("A"));
    }

    @Test
    public void testIndexOfReturnTrue() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");

        assertEquals(2, arrayList.indexOf("C"));
    }

    @Test
    public void testLastIndexOfReturnTrue() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");

        assertEquals(3, arrayList.lastIndexOf("D"));
    }

    @Test
    public void testRemoveReturnTrueOnEmptyArray() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("C");
        arrayList.add("D");

        arrayList.remove(2);

        assertEquals("D", arrayList.get(2));
    }

    @Test
    public void testRemoveReturnTrueIfWorksCorrectly() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.remove(0);

        assertTrue(arrayList.isEmpty());
    }

    @Test
    public void testSetReturnTrueOnChangedValue() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.set("XXX", 1);

        assertEquals("XXX", arrayList.get(1));
    }


    @Test
    public void testAddReturnTrueIfElementAdded() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("XXX", 1);

        assertEquals("XXX", arrayList.get(1));
    }

    @Test
    public void testAddReturnTrueIfNextElementMoved() {
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");
        arrayList.add("B");
        arrayList.add("XXX", 1);

        assertEquals("B", arrayList.get(2));
    }

    @Test
    public void testSizeOnEmptyArray(){
        ArrayList arrayList = new ArrayList();

        assertEquals(0, arrayList.size());
    }

    @Test
    public void testIsTheArrayExpanding(){
        ArrayList arrayList = new ArrayList();
        for(int i = 0; i < 25; i++){

            arrayList.add(i);
        }

        assertTrue(arrayList.size() > 20);
    }

    @Test
    public void testToStringReturnTrueOnNotEmptyArray(){
        ArrayList arrayList = new ArrayList();
        arrayList.add("A");

        System.out.println(arrayList.toString());
        assertTrue(arrayList.toString().isEmpty() == false);
    }

    @Test
    public void testToStringReturnTrueOnEmptyArray(){
        ArrayList arrayList = new ArrayList();

        System.out.println(arrayList.toString());
        assertTrue(arrayList.toString().isEmpty());
    }

}

//    String toString();