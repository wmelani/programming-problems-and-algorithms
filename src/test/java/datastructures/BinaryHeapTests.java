package datastructures;

import org.junit.Test;

import java.util.Comparator;

import static org.junit.Assert.assertEquals;

public class BinaryHeapTests {

    @Test
    public void pull() {

    }

    @Test
    public void peek() {
        var heap = new BinaryHeap<Integer>(Comparator.comparingInt(o -> o));
        heap.add(4);
        assertEquals(4, (int) heap.peek());

    }

    @Test
    public void peekMax() {
        var heap = new BinaryHeap<Integer>(Comparator.comparingInt(o -> o));
        heap.add(4);
        heap.add(11);
        heap.add(9);
        assertEquals(11, (int) heap.peek());

    }

    @Test
    public void peekMax2() {
        var heap = new BinaryHeap<Integer>(Comparator.comparingInt(o -> o));
        heap.add(4);
        heap.add(11);
        heap.add(9);
        heap.add(22);
        assertEquals(22, (int) heap.peek());

    }

    @Test
    public void peekMax3() {
        var heap = new BinaryHeap<Integer>(Comparator.comparingInt(o -> o));
        heap.add(24);
        heap.add(11);
        heap.add(9);
        heap.add(22);
        assertEquals(24, (int) heap.peek());

    }

    @Test
    public void add() {
        var heap = new BinaryHeap<Integer>(Comparator.comparingInt(o -> o));
        assertEquals(0, heap.size());
        heap.add(4);
        assertEquals(1, heap.size());
    }

    @Test
    public void getLevelOrderIterator() {
    }
}