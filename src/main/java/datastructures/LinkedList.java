package datastructures;


import java.util.Iterator;
import java.util.Objects;
import java.util.Optional;

/**
 * was a pain to implement real list interface, not helpful while practicing algorithms...
 * <p>
 * Add O(1)
 * Delete O(N)
 * Find O(N)
 *
 * @param <T>
 */
public class LinkedList<T> implements Iterable<T> {

    private int count;
    private LinkedListNode<T> start;
    private LinkedListNode<T> end;

    public void add(T entry) {
        if (count == 0) {
            this.start = new LinkedListNode<>(entry);
            this.end = this.start;
            this.count++;
            return;
        }
        if (count > 0) {
            var newNode = new LinkedListNode<>(entry);
            this.end.next = newNode;
            newNode.prev = this.end;
            this.end = newNode;
            this.count++;
        }
    }

    public boolean remove(T entry) {
        var node = this.findNode(entry);
        if (!node.isPresent()) {
            return false;
        }
        var entryNode = node.get();
        if (count == 1) {
            this.start = null;
            this.end = null;
            this.count = 0;
            return true;
        }

        // removing the head
        if (Objects.equals(this.start, entryNode)) {
            this.start = this.start.next;
        }
        // removing the tail
        if (Objects.equals(this.end, entryNode)) {
            this.end = this.end.prev;
        }
        // removing a middle element
        entryNode.prev.next = entryNode.next;
        count--;
        return true;
    }

    private Optional<LinkedListNode<T>> findNode(T entry) {
        if (count == 0) {
            return Optional.empty();
        }
        if (count == 1) {
            return Optional.of(this.start);
        }
        LinkedListNode<T> current = this.start;
        while (current != null) {
            if (Objects.equals(current.entry, entry)) {
                return Optional.of(current);
            }
            current = current.next;
        }
        return Optional.empty();
    }

    public int size() {
        return this.count;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    /**
     * Not looking to implement java iterator, so this terrible perf loop instead!
     */
    public T getByIndex(int index) {
        if (index < 0 || index >= this.count) {
            throw new IndexOutOfBoundsException("index");
        }
        int i = 0;
        var current = this.start;
        while (i < index) {
            current = current.next;
            i++;
        }
        return current.entry;
    }

    public Iterator<T> iterator() {
        return new LinkedListIterator<T>(this);
    }

    private static class LinkedListNode<T> {
        T entry;
        LinkedListNode<T> prev;
        LinkedListNode<T> next;

        LinkedListNode(T entry) {
            this.entry = entry;
        }
    }

    private static class LinkedListIterator<T> implements Iterator<T> {

        private final LinkedList<T> tLinkedList;
        private LinkedListNode<T> it;

        public LinkedListIterator(LinkedList<T> tLinkedList) {
            this.tLinkedList = tLinkedList;
            this.it = tLinkedList.start;
        }

        @Override
        public boolean hasNext() {
            return this.it.next != null;
        }

        @Override
        public T next() {
            var entry = it.entry;
            this.it = it.next;
            return entry;
        }
    }

}
