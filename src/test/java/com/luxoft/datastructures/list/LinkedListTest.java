package com.luxoft.datastructures.list;

import com.luxoft.datastructures.AbstractListTest;

public class LinkedListTest extends AbstractListTest {

    @Override
    protected List getList() {
        return new LinkedList<>();
    }
}