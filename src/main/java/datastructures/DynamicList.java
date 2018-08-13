package datastructures;

import lombok.Getter;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

/**
 * Missing a lot of other things like serialization, concurrency, ...
 *
 * @param <T>
 */
public class DynamicList<T> implements List<T> {


    public static final double RESIZE_FACTOR = 2;
    public static final int DEFAULT_SIZE = 10;
    private int _size = 0;
    @Getter
    private int resizeCount;
    private Object[] _underlying;

    public DynamicList() {
        _underlying = new Object[DEFAULT_SIZE];
    }

    public DynamicList(int limit) {
        if (limit < 0) {
            throw new IllegalArgumentException("limit");
        }
        this._underlying = new Object[limit];
    }

    public DynamicList(T[] elements) {
        super();
        this._underlying = elements;
        this._size = this._underlying.length;
    }

    private void resizeIfNeeded() {
        if (this._size == this._underlying.length) {
            this.resizeCount++;
            var temp = new Object[this._size * (int) RESIZE_FACTOR];
            this.toArray(temp);
            this._underlying = temp;
        }
    }

    @Override
    public int size() {
        return this._size;
    }

    public int capacity() {
        return this._underlying.length;
    }

    @Override
    public boolean isEmpty() {
        return this._size == 0;
    }

    @Override
    public boolean contains(Object o) {
        for (Object entry : this._underlying) {
            if (entry == o) {
                return true;
            }
        }
        return false;
    }

    @Override
    public Iterator<T> iterator() {
        return new DynamicListIterator<>(this);
    }

    @Override
    public Object[] toArray() {
        var newArray = new Object[this._underlying.length];
        System.arraycopy(
                this._underlying,
                0,
                newArray,
                0,
                this._underlying.length);
        return newArray;
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        if (a.length < this._underlying.length) {
            throw new IllegalArgumentException("parameter is not big enough");
        }
        System.arraycopy(
                this._underlying,
                0,
                a,
                0,
                this._underlying.length);
        return a;
    }

    @Override
    public boolean add(T t) {
        this.resizeIfNeeded();
        this._underlying[this._size++] = t;
        return true;
    }

    @Override
    public boolean remove(Object o) {
        int index = this.indexOf(o);
        if (index == -1) {
            return false;
        }
        this.removeIndexImpl(index);
        return true;
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        // different data structure could reduce this complexity
        for (var entry : c) {
            if (!this.contains(entry)) {
                return false;
            }
        }
        return true;
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        c.forEach(this::add);
        return true;
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return false;
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        for (var entry : c) {
            this.remove(entry);
        }
        return true;
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return false;
    }

    @Override
    public void clear() {
        this._underlying = null;
        this._size = 0;
        this._underlying = new Object[DynamicList.DEFAULT_SIZE];
    }

    @Override
    public T get(int index) {
        return (T) this._underlying[index];
    }

    @Override
    public T set(int index, T element) {
        this._underlying[index] = element;
        return element;
    }

    @Override
    public void add(int index, T element) {
        this.resizeIfNeeded();
        this._underlying[index] = element;

    }

    @Override
    public T remove(int index) {
        return this.removeIndexImpl(index);
    }

    private T removeIndexImpl(int index) {
        var elem = this.get(index);

        if (this._size - index >= 0)
            System.arraycopy(
                    this._underlying,
                    index + 1,
                    this._underlying,
                    index,
                    this._size - index);
        this._size--;
        return elem;
    }

    @Override
    public int indexOf(Object o) {
        for (int i = 0; i < this._size; i++) {
            if (this._underlying[i] == o) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public int lastIndexOf(Object o) {
        for (int i = this._size - 1; i >= 0; i--) {
            if (this._underlying[i] == o) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public ListIterator<T> listIterator() {
        return new DynamicListListIterator<>(this);
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return new DynamicListListIterator<>(this, index);
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        throw new IllegalStateException("not implemented");
    }

    public static class DynamicListIterator<T> implements Iterator<T> {

        private DynamicList<T> list;
        private int index = 0;

        DynamicListIterator(DynamicList<T> list) {
            this.list = list;
        }


        @Override
        public boolean hasNext() {
            return this.index < this.list.size();
        }

        @Override
        public T next() {
            if (!this.hasNext()) {
                throw new IllegalStateException("no entries remaining");
            }
            return this.list.get(++this.index);
        }
    }

    public static class DynamicListListIterator<T> implements ListIterator<T> {

        private final DynamicList<T> _list;
        private int pos;

        DynamicListListIterator(DynamicList<T> list) {
            this._list = list;
            this.pos = 0;
        }

        DynamicListListIterator(DynamicList<T> list, int startingIndex) {
            this._list = list;
            if (startingIndex < 0 || startingIndex >= this._list.size()) {
                throw new IndexOutOfBoundsException("startingIndex");
            }
            this.pos = startingIndex;
        }

        @Override
        public boolean hasNext() {
            return this.pos < this._list.size();
        }

        @Override
        public T next() {
            if (!this.hasNext()) {
                throw new IllegalStateException("No entries remaining");
            }
            return this._list.get(++this.pos);
        }

        @Override
        public boolean hasPrevious() {
            return this._list.size() > pos;
        }

        @Override
        public T previous() {
            if (!this.hasPrevious()) {
                throw new IllegalStateException("No entries prior");
            }
            return this._list.get(--this.pos);
        }

        @Override
        public int nextIndex() {
            return this.pos + 1;
        }

        @Override
        public int previousIndex() {
            return this.pos - 1;
        }

        @Override
        public void remove() {
            this._list.remove(--this.pos);
        }

        @Override
        public void set(T t) {
            this._list.set(this.pos, t);
        }

        @Override
        public void add(T t) {
            this._list.add(++this.pos, t);
        }
    }
}
