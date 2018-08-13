package datastructures;

import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleQueueTests {
    @Test
    public void canBeCreatedDefaultCtor() {
        var queue = new SimpleQueue<Boolean>();
        assertEquals(0, queue.size());
    }

    @Test
    public void canBeCreatedExistingArrayCtor() {
        var queue = new SimpleQueue<>(new Boolean[]{true});
        assertEquals(1, queue.size());
    }

    @Test
    public void canAddTo() {
        var list = new SimpleQueue<Boolean>();
        list.push(true);
        assertEquals(1, list.size());
    }

    @Test
    public void canPeek() {
        var queue = new SimpleQueue<Boolean>();
        assertTrue(queue.push(true));
        assertTrue(queue.push(false));
        assertTrue(queue.push(false));
        assertTrue(queue.peek());
        assertEquals(3, queue.size());
    }

    @Test
    public void canPoll() {
        var queue = new SimpleQueue<Boolean>();
        assertTrue(queue.push(true));
        assertTrue(queue.push(false));
        assertTrue(queue.push(false));
        assertTrue(queue.poll());
        assertEquals(2, queue.size());
    }

    @Test
    public void canClearQueue() {
        var queue = new SimpleQueue<Object>();
        var one = new Object();
        var two = new Object();
        var three = new Object();
        assertTrue(queue.push(one));
        assertTrue(queue.push(two));
        assertTrue(queue.push(three));
        assertTrue(queue.push(two));
        assertEquals(one, queue.poll());
        assertEquals(two, queue.poll());
        assertEquals(three, queue.poll());
        assertEquals(two, queue.poll());
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

    @Test
    public void queueCanStartWithEntries() {
        var queue = new SimpleQueue<Integer>(new Integer[]{1, 2, 3, 4, 5, 6, 7, 8});
        assertEquals(1, (int) queue.poll());
        assertEquals(2, (int) queue.poll());
        assertEquals(3, (int) queue.poll());
        assertEquals(4, (int) queue.poll());
        assertEquals(5, (int) queue.poll());
        assertEquals(6, (int) queue.poll());
        assertEquals(7, (int) queue.poll());
        assertEquals(8, (int) queue.poll());
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }


    @Test
    public void queueCanFillUp() {
        var queue = new SimpleQueue<Integer>(4);
        assertTrue(queue.push(1));
        assertTrue(queue.push(2));
        assertTrue(queue.push(3));
        assertTrue(queue.push(4));
        assertFalse(queue.push(5));
        assertEquals(1, (int) queue.poll());
        assertEquals(2, (int) queue.poll());
        assertEquals(3, (int) queue.poll());
        assertEquals(4, (int) queue.poll());
        assertTrue(queue.isEmpty());
        assertEquals(0, queue.size());
    }

}
