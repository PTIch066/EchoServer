package com.luxoft.datastructures.queue;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class ArrayQueueTest {

    @Test
    public void testPushAndPop(){
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("Cat");
        arrayQueue.enqueue("Dog");
        arrayQueue.enqueue("Mouse");

        assertEquals("Cat", arrayQueue.dequeue());
        assertEquals("Dog", arrayQueue.dequeue());
        assertEquals("Mouse", arrayQueue.dequeue());
    }

    @Test
    public void testIsEmptyReturnFalseAfterAddFirstElement(){
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("Cat");

        assertEquals(false, arrayQueue.isEmpty());
    }

    @Test
    public void testContainsReturnFalseOnEmptyQueue(){
        ArrayQueue arrayQueue = new ArrayQueue();

        assertEquals(false, arrayQueue.contains("Cat"));
    }

    @Test
    public void testContainsReturnTrue(){
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("Cat");
        arrayQueue.enqueue("Dog");
        arrayQueue.enqueue("Mouse");

        assertEquals(true, arrayQueue.contains("Dog"));
    }

    @Test
    public void testPeekReturnTrue(){
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("Cat");

        assertEquals("Cat", arrayQueue.peek());
    }

    @Test
    public void testSizeReturnTrueOnRightSize(){
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("Cat");
        arrayQueue.enqueue("Dog");
        arrayQueue.enqueue("Mouse");


        assertEquals(3, arrayQueue.size());
    }

    @Test
    public void testClearReturnTrueIfCleared(){
        ArrayQueue arrayQueue = new ArrayQueue();
        arrayQueue.enqueue("Cat");
        arrayQueue.enqueue("Dog");
        arrayQueue.enqueue("Mouse");
        arrayQueue.clear();

        assertEquals(0, arrayQueue.size());
    }


}

