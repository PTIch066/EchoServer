package com.luxoft.datastructures;

import com.luxoft.datastructures.list.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Iterator;

import static org.junit.jupiter.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.assertTrue;

public abstract class AbstractListTest {
    private List<Integer> list;

    @BeforeEach
    public void before() {
        list = getList();
    }

    protected abstract List getList();

    @DisplayName("Test clear")
    @Test
    public void testClearReturnTrueOnEmptyLinked() {
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.clear();

        assertTrue(list.isEmpty());
    }

    @DisplayName("Test clear on empty list")
    @Test
    public void testClearOnEmptyList() {
        list.clear();

        assertTrue(list.isEmpty());
    }

    @DisplayName("Test of contains method when list is empty")
    @Test
    public void testContains() {
        list.add(4);
        list.add(9);
        list.add(8);

        assertTrue(list.contains(9));
    }

    @DisplayName("Test of contains method")
    @Test
    public void testContainsReturnFalseOnEmptyLinked() {
        assertFalse(list.contains(1));
    }

    @DisplayName("test set null")
    @Test
    public void testSetNull() {
        NullPointerException nullPointerException = assertThrows(NullPointerException.class, () -> {
            list.add(1);
            list.set(null, 0);
        });

        assertEquals("You can not add null", nullPointerException.getMessage());
    }

    @DisplayName("method set with index below 0")
    @Test
    public void testSetBelowZero() {
        IndexOutOfBoundsException indexOutOfBoundsException = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(1);
            list.set(2, -1);

        });

        assertEquals("Your index is below zero", indexOutOfBoundsException.getMessage());
    }

    @DisplayName("method set index == size")
    @Test
    public void testSetInSize() {
        IndexOutOfBoundsException indexOutOfBoundsException = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(1);
            list.set(2, list.size());
        });

        assertEquals("Your index is bigger than available size", indexOutOfBoundsException.getMessage());
    }

    @DisplayName("test srt on correct replacing")
    public void testSet() {
        list.add(1);
        list.set(2, 0);

        assertEquals(2, list.get(0));
    }

    @DisplayName("test on correct changes in size")
    @Test
    public void testIsTheLinkedExpanding() {
        for (int i = 0; i < 25; i++) {

            list.add(i);
        }

        assertEquals(25, list.size());
    }

    @DisplayName("test size on empty list")
    @Test
    public void testSizeOnEmptyList() {

        assertEquals(0, list.size());
    }

    @DisplayName("test of isEmpty method")
    @Test
    public void testIsEmptyWhenNotEmpty() {
        list.add(2);
        assertFalse(list.isEmpty());
    }

    @DisplayName("test of isEmpty method with new List")
    @Test
    public void testIsEmptyWithNewList() {
        assertTrue(list.isEmpty());
    }

    @DisplayName("test of toString method with empty array")
    @Test
    public void testToStringWithEmptyList() {
        list.add(1);

        assertTrue(list.toString().isEmpty() == false);
    }

    @DisplayName("test of toString method")
    @Test
    public void testToString() {

        System.out.println(list.toString());
        assertTrue(list.toString().isEmpty() == true);
    }

    @DisplayName("test remove element which index is below zero")
    @Test
    public void testRemoveElementBelowZero() {
        IndexOutOfBoundsException indexOutOfBoundsException = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(4);
            list.add(9);
            list.add(8);
            list.add(24);
            list.add(1);

            list.remove(-1);
        });

        assertEquals("Your index is below zero", indexOutOfBoundsException.getMessage());
    }

    @DisplayName("test remove last element")
    @Test
    public void testRemoveElement() {
        list.add(4);
        list.add(9);
        list.add(8);
        list.add(24);
        list.add(1);

        list.remove(4);
        assertEquals(4, list.size());
        assertEquals(24, list.get(list.size() - 1));
    }

    @DisplayName("test remove first element")
    @Test
    public void testRemoveFirstElement() {
        list.add(4);
        list.add(9);
        list.add(8);
        list.add(24);
        list.add(1);

        list.remove(0);
        assertEquals(4, list.size());
        assertEquals(9, list.get(0));
    }

    @DisplayName("test remove with incorrect index")
    @Test
    public void testRemoveNotExistElement() {
        IndexOutOfBoundsException indexOutOfBoundsException = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(4);
            list.add(9);
            list.add(8);
            list.add(24);
            list.add(1);

            list.remove(30);
        });

        assertEquals("Your index is bigger than available size", indexOutOfBoundsException.getMessage());
    }

    @DisplayName("test add null")
    @Test
    public void testAddNull() {
        NullPointerException nullPointerException = assertThrows(NullPointerException.class, () -> {
            list.add(null);
        });

        assertEquals("You can not add null", nullPointerException.getMessage());
    }

    @DisplayName("test add")
    @Test
    public void testAdd() {
        list.add(4);

        assertEquals(1, list.size());
    }

    @DisplayName("test add index below zero")
    @Test
    public void testAddWithIndexBelowZero() {
        IndexOutOfBoundsException indexOutOfBoundsException = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(4, -1);
        });

        assertEquals("Your index is below zero", indexOutOfBoundsException.getMessage());
    }


    @DisplayName("test add by index with bigger index")
    @Test
    public void testAddWithIncorrectIndex() {
        IndexOutOfBoundsException indexOutOfBoundsException = assertThrows(IndexOutOfBoundsException.class, () -> {
            list.add(4, 20);
        });

        assertEquals("Your index is bigger than available size", indexOutOfBoundsException.getMessage());
    }

    @DisplayName("test add by index with correct index")
    @Test
    public void testAddWithCorrectIndex() {
        list.add(4);
        list.add(9);
        list.add(24);
        list.add(100, 2);

        assertEquals(100, list.get(2));
    }

    @DisplayName("test add by index in first place")
    @Test
    public void testAddInStart() {
        list.add(4);
        list.add(9);
        list.add(24);
        list.add(100, 0);

        assertEquals(100, list.get(0));
    }

    @DisplayName("test add by index in last place")
    @Test
    public void testAddInEnd() {
        list.add(4);
        list.add(9);
        list.add(24);
        list.add(100, 3);

        assertEquals(100, list.get(3));
    }

    @DisplayName("test of lastIndexOf with correct value")
    @Test
    public void testLastIndexOfCorrect() {
        list.add(4);
        list.add(9);
        list.add(24);
        list.add(12);

        assertEquals(0, list.lastIndexOf(4));
    }

    @DisplayName("test of lastIndexOf with incorrect value")
    @Test
    public void testLastIndexOfIncorrect() {
        list.add(4);
        list.add(9);
        list.add(24);
        list.add(12);

        assertEquals(-1, list.lastIndexOf(55));
    }

    @DisplayName("test of indexOf with correct value")
    @Test
    public void testIndexOfWithCorrectValue() {
        list.add(4);
        list.add(9);
        list.add(24);
        list.add(12);

        assertEquals(2, list.indexOf(24));
    }

    @DisplayName("test of indexOf with incorrect value")
    @Test
    public void testIndexOfWithIncorrectValue() {
        list.add(4);
        list.add(9);
        list.add(24);
        list.add(12);

        assertEquals(-1, list.lastIndexOf(67));
    }

    @DisplayName("test of Iterator")
    @Test
    public void testIterator() {
        list.add(4);
        list.add(9);
        Iterator iterator = list.iterator();
        assertTrue(iterator.hasNext());
        assertEquals(4, iterator.next());
        assertTrue(iterator.hasNext());
        assertEquals(9, iterator.next());
    }

    @DisplayName("test of hasNext method on empty list")
    @Test
    public void testIteratorReturnFalseOnEmptyList() {
        Iterator iterator = list.iterator();
        assertFalse(iterator.hasNext());
    }

    @DisplayName("test of hasNext method on not empty list")
    @Test
    public void testIteratorReturnFalseOnNotEmptyList() {
        list.add(4);
        Iterator iterator = list.iterator();
        assertTrue(iterator.hasNext());
    }

}
