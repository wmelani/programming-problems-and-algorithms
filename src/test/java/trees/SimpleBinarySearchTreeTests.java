package trees;

import datastructures.Queue;
import datastructures.SimpleQueue;
import org.junit.Test;

import static org.junit.Assert.*;

public class SimpleBinarySearchTreeTests {

    @Test
    public void addAndContains() {
        var tree = new SimpleBinarySearchTree<Integer>(Integer.MIN_VALUE, Integer.MAX_VALUE);
        assertEquals(0, tree.size());
        tree.add(5);
        assertEquals(1, tree.size());
        assertTrue(tree.contains(5));
    }

    @Test
    public void addMultiple() {
        var tree = new SimpleBinarySearchTree<Integer>(Integer.MIN_VALUE, Integer.MAX_VALUE);
        assertEquals(0, tree.size());
        tree.add(5);
        tree.add(14);
        tree.add(22);
        tree.add(3);
        assertEquals(4, tree.size());
        assertTrue(tree.contains(5));
        assertTrue(tree.contains(14));
        assertTrue(tree.contains(22));
        assertTrue(tree.contains(3));
    }

    @Test
    public void inOrderIterator() {
        var tree = new SimpleBinarySearchTree<Integer>(Integer.MIN_VALUE, Integer.MAX_VALUE);
        assertEquals(0, tree.size());
        tree.add(5);
        tree.add(14);
        tree.add(22);
        Queue<Integer> expected = new SimpleQueue<>(tree.size());
        expected.push(5);
        expected.push(14);
        expected.push(22);
        for (var val : tree.getInOrderIterator()) {
            assertEquals(expected.poll(), val);
        }
        assertEquals(0, expected.size());
    }

    @Test
    public void inOrderIterator2() {
        var tree = new SimpleBinarySearchTree<Integer>(Integer.MIN_VALUE, Integer.MAX_VALUE);
        assertEquals(0, tree.size());
        tree.add(5);
        tree.add(1);
        tree.add(22);
        Queue<Integer> expected = new SimpleQueue<>(tree.size());
        expected.push(1);
        expected.push(5);
        expected.push(22);
        for (var val : tree.getInOrderIterator()) {
            assertEquals(expected.poll(), val);
        }
        assertEquals(0, expected.size());
    }

    @Test
    public void inOrderIterator3() {
        var tree = new SimpleBinarySearchTree<Integer>(Integer.MIN_VALUE, Integer.MAX_VALUE);
        assertEquals(0, tree.size());
        tree.add(10);
        tree.add(8);
        tree.add(22);
        tree.add(6);
        tree.add(18);
        tree.add(11);
        tree.print();

        // note that this bst type is still suboptimal
        Queue<Integer> expected = new SimpleQueue<>(tree.size());
        expected.push(6);
        expected.push(8);
        expected.push(10);
        expected.push(11);
        expected.push(18);
        expected.push(22);
        for (var val : tree.getInOrderIterator()) {
            assertEquals(expected.poll(), val);
        }
        assertEquals(0, expected.size());
    }

    @Test
    public void inOrderIterator4() {
        var tree = new SimpleBinarySearchTree<Integer>(Integer.MIN_VALUE, Integer.MAX_VALUE);
        assertEquals(0, tree.size());
        tree.add(8);
        tree.add(6);
        tree.add(4);
        tree.add(7);
        tree.add(14);
        tree.add(16);
        tree.add(18);
        tree.print();

        Queue<Integer> expected = new SimpleQueue<>(tree.size());
        expected.push(4);
        expected.push(6);
        expected.push(7);
        expected.push(8);
        expected.push(14);
        expected.push(16);
        expected.push(18);

        for (var val : tree.getInOrderIterator()) {
            assertEquals(expected.poll(), val);
        }
        assertEquals(0, expected.size());
    }

    @Test
    public void removeHead() {
        var tree = new SimpleBinarySearchTree<Integer>(Integer.MIN_VALUE, Integer.MAX_VALUE);
        assertEquals(0, tree.size());
        tree.add(10);
        tree.print();
        assertTrue(tree.remove(10));
        tree.print();
        assertEquals(0, tree.size());
    }

    @Test
    public void removeLeftChild() {
        var tree = new SimpleBinarySearchTree<Integer>(Integer.MIN_VALUE, Integer.MAX_VALUE);
        assertEquals(0, tree.size());
        tree.add(10);
        tree.add(6);
        tree.print();
        assertTrue(tree.remove(6));
        tree.print();
        assertEquals(1, tree.size());
    }

    @Test
    public void removeRightChild() {
        var tree = new SimpleBinarySearchTree<Integer>(Integer.MIN_VALUE, Integer.MAX_VALUE);
        assertEquals(0, tree.size());
        tree.add(10);
        tree.add(11);
        tree.print();
        assertTrue(tree.remove(11));
        tree.print();
        assertEquals(1, tree.size());
    }

    @Test
    public void removeLeftDangling() {
        var tree = new SimpleBinarySearchTree<Integer>(Integer.MIN_VALUE, Integer.MAX_VALUE);
        assertEquals(0, tree.size());
        tree.add(8);
        tree.add(6);
        tree.add(4);
        tree.add(7);
        tree.add(14);
        tree.add(16);
        tree.add(3);
        tree.print();
        assertTrue(tree.remove(4));
        tree.print();
        assertEquals(6, tree.size());
    }

    @Test
    public void removeRightDangling() {
        var tree = new SimpleBinarySearchTree<Integer>(Integer.MIN_VALUE, Integer.MAX_VALUE);
        assertEquals(0, tree.size());
        tree.add(8);
        tree.add(6);
        tree.add(4);
        tree.add(7);
        tree.add(14);
        tree.add(16);
        tree.add(18);
        tree.print();
        assertTrue(tree.remove(16));
        tree.print();
        assertEquals(6, tree.size());
    }

    @Test
    public void removeEntryNotInTree() {
        var tree = new SimpleBinarySearchTree<Integer>(Integer.MIN_VALUE, Integer.MAX_VALUE);
        assertEquals(0, tree.size());
        tree.add(8);
        tree.add(6);
        tree.add(4);
        tree.add(7);
        tree.add(14);
        tree.add(16);
        tree.add(18);
        tree.print();
        assertFalse(tree.remove(11));
        assertEquals(7, tree.size());
    }

    @Test
    public void removeNodeWithTwoChildren() {
        var tree = new SimpleBinarySearchTree<Integer>(Integer.MIN_VALUE, Integer.MAX_VALUE);
        assertEquals(0, tree.size());
        tree.add(8);
        tree.add(6);
        tree.add(4);
        tree.add(7);
        tree.add(14);
        tree.add(16);
        tree.add(18);
        tree.print();
        assertTrue(tree.remove(6));
        tree.print();
        assertEquals(6, tree.size());
    }

    @Test
    public void removeNodeWithTwoChildrenAndTreeHead() {
        var tree = new SimpleBinarySearchTree<Integer>(Integer.MIN_VALUE, Integer.MAX_VALUE);
        assertEquals(0, tree.size());
        tree.add(8);
        tree.add(6);
        tree.add(4);
        tree.add(7);
        tree.add(14);
        tree.add(16);
        tree.add(18);
        tree.print();
        assertTrue(tree.remove(8));
        tree.print();
        assertEquals(6, tree.size());
    }
}
