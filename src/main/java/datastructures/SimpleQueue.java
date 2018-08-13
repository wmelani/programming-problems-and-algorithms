package datastructures;

public class SimpleQueue<T> implements Queue<T> {

    /*
     h     e
     5 4 3 1

     poll()
     X h   e
     5 4 3 1
      */
    //

    //

    private DynamicList<T> list;
    private int startIndex = 0;
    private int endIndex = 0;
    private int size = 0;

    SimpleQueue(T[] entries) {
        this.list = new DynamicList<>(entries);
        this.size = this.list.size();
    }

    SimpleQueue(int limit) {
        this.list = new DynamicList<>(limit);
        this.size = 0;
    }

    SimpleQueue() {
        this.list = new DynamicList<>();
    }

    @Override
    public boolean push(T entry) {
        if (this.isFull()) {
            return false;
        }
        this.list.set(this.endIndex, entry);
        this.endIndex = (this.endIndex + 1) % this.list.capacity();
        this.size++;
        return true;
    }

    @Override
    public T poll() {
        var current = this.list.get(this.startIndex);
        this.startIndex = (this.startIndex + 1) % (this.list.capacity());
        this.size = this.size - 1;
        return current;
    }

    @Override
    public T peek() {
        return this.list.get(this.startIndex);
    }

    @Override
    public boolean isEmpty() {
        return this.startIndex == this.endIndex;
    }

    @Override
    public boolean isFull() {
        return this.size == this.list.capacity();
    }

    @Override
    public int size() {
        return this.size;
    }
}
