package datastructures;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class LinkedListTests {


    @Test
    public void addWorks() {
        var linkedList = new LinkedList<Integer>();
        assertEquals(0, linkedList.size());
        linkedList.add(4);
        assertEquals(1, linkedList.size());
        assertEquals(4, (int) linkedList.getByIndex(0));
    }

    @Test
    public void iteratorWorks() {
        var linkedList = new LinkedList<Integer>();
        assertEquals(0, linkedList.size());
        linkedList.add(4);
        linkedList.add(5);
        var results = new int[]{4, 5};
        int idx = 0;
        for (var entry : linkedList) {
            assertEquals(results[idx++], (int) entry);
        }
    }

    @Test
    public void removeHead() {
        var linkedList = new LinkedList<Integer>();
        linkedList.add(4);
        assertTrue(linkedList.remove(4));
        assertTrue(linkedList.isEmpty());
        assertEquals(0, linkedList.size());

    }

    @Test
    public void removeTail() {
        var linkedList = new LinkedList<Integer>();
        linkedList.add(4);
        linkedList.add(5);
        assertTrue(linkedList.remove(5));
        assertEquals(1, linkedList.size());
        assertEquals(4, (int) linkedList.getByIndex(0));
    }

    @Test
    public void removeMiddle() {
        var linkedList = new LinkedList<Integer>();
        linkedList.add(4);
        linkedList.add(5);
        linkedList.add(6);
        assertTrue(linkedList.remove(5));
        assertEquals(2, linkedList.size());
        assertEquals(4, (int) linkedList.getByIndex(0));
        assertEquals(6, (int) linkedList.getByIndex(1));
    }
}