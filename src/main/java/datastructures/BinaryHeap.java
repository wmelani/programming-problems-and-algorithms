package datastructures;

import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;

public class BinaryHeap<T> {


    private final Comparator<T> comparator;
    private DynamicList<T> list;
    private int count;

    public BinaryHeap(Comparator<T> comparator) {
        this.comparator = comparator;
        this.list = new DynamicList<>();
    }

    public T pull() {
        if (isEmpty()) {
            throw new IllegalStateException("empty");
        }
        var result = this.list.get(0);

        if (this.size() == 1) {
            this.list.set(0, null);
            this.count = 0;
            return result;
        }

        this.swap(0, this.size() - 1);
        this.count--;
        this.siftDown(0);
        return result;
    }

    public T peek() {
        if (isEmpty()) {
            throw new IllegalStateException("empty");
        }
        var result = this.list.get(0);
        return result;
    }

    public void add(T entry) {
        this.list.add(entry);

        this.count++;
        this.siftUp(this.count - 1);
    }

    public void print() {

    }

    private void verify() {

    }

    private void siftDown(int idx) {
        var currentIdx = idx;
        while (this.getLeftChildIndex(currentIdx).isPresent()
                || this.getRightChildIndex(currentIdx).isPresent()) {
            var leftOption = this.getLeftChildIndex(currentIdx);
            var rightOption = this.getRightChildIndex(currentIdx);

            int favoriteChildIndex;
            if (leftOption.isPresent() && rightOption.isPresent()) {
                var left = this.get(leftOption.get());
                var right = this.get(rightOption.get());
                var compared = this.comparator.compare(left, right);
                if (compared < 0) {
                    favoriteChildIndex = leftOption.get();
                } else {
                    favoriteChildIndex = rightOption.get();
                }
            } else if (leftOption.isPresent()) {
                favoriteChildIndex = leftOption.get();
            } else {
                favoriteChildIndex = rightOption.get();
            }

            // see if worth swapping with child
            var compared = this.comparator.compare(this.get(currentIdx), this.get(favoriteChildIndex));
            if (compared > 0) {
                swap(currentIdx, favoriteChildIndex);
                currentIdx = favoriteChildIndex;
            }
        }
    }

    private void siftUp(int idx) {
        var currentIdx = idx;
        var parentIndex = this.getParentIndex(idx);
        while (parentIndex.isPresent()) {
            var current = this.get(currentIdx);
            var parent = this.get(parentIndex.get());
            var compared = this.comparator.compare(parent, current);
            if (compared == 0) {
                return;
            }
            if (compared < 0) {
                swap(parentIndex.get(), currentIdx);
                currentIdx = parentIndex.get();
                parentIndex = this.getParentIndex(currentIdx);
            } else return;
        }
    }

    public T get(int idx) {
        return this.list.get(idx);
    }

    private Optional<Integer> getLeftChildIndex(int index) {
        var res = 2 * index + 1;
        if (res > this.list.size() - 1) {
            return Optional.empty();
        }
        return Optional.of(res);
    }

    private Optional<Integer> getRightChildIndex(int index) {
        var res = 2 * index + 2;
        if (res > this.list.size() - 1) {
            return Optional.empty();
        }
        return Optional.of(res);
    }

    private Optional<Integer> getParentIndex(int index) {
        if (index <= 0 || index > this.size() - 1) {
            return Optional.empty();
        }
        return Optional.of(index / 2);
    }

    private void swap(int left, int right) {
        var temp = this.list.get(left);
        this.list.set(left, this.list.get(right));
        this.list.set(right, temp);
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public int size() {
        return this.count;
    }

    public Iterable<T> getLevelOrderIterator() {
        return new BinaryHeapLevelOrderIterator(this);
    }

    private class BinaryHeapLevelOrderIterator implements Iterable<T> {
        private final BinaryHeap<T> tBinaryHeap;
        private int count = 0;

        BinaryHeapLevelOrderIterator(BinaryHeap<T> tBinaryHeap) {

            this.tBinaryHeap = tBinaryHeap;
        }

        @Override
        public Iterator<T> iterator() {
            return new Iterator<T>() {
                @Override
                public boolean hasNext() {
                    return count < tBinaryHeap.size();
                }

                @Override
                public T next() {
                    return tBinaryHeap.list.get(count++);
                }
            };
        }
    }
}
