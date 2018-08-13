package datastructures;

public interface Queue<T> {
    boolean push(T entry);

    T poll();

    T peek();

    boolean isEmpty();

    boolean isFull();

    int size();
}
