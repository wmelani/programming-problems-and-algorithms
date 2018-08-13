package problems;

import datastructures.Queue;
import datastructures.SimpleQueue;

/**
 * Given a stream of integers and a window size, calculate the moving average of all integers in the sliding window.
 * <p>
 * Example:
 * <p>
 * MovingAverage m = new MovingAverage(3);
 * m.next(1) = 1
 * m.next(10) = (1 + 10) / 2
 * m.next(3) = (1 + 10 + 3) / 3
 * m.next(5) = (10 + 3 + 5) / 3
 * <p>
 * from LeetCode
 * <p>
 * https://leetcode.com/explore/learn/card/queue-stack/228/first-in-first-out-data-structure/1368/
 * <p>
 * <p>
 * General algorithm is to keep track of the sum that we've seen so far. if the queue is full, than we should pop off
 * the first entry.
 * <p>
 * If we subtract the popped element from the sum, the sum will then be only the remaining elements in the queue.
 * <p>
 * Then we can add our new element, increment sum, and then divide the sum by the number of total elements.
 */
public class MovingAverageFromDataStream {

    private Queue<Integer> queue;
    private double sum = 0;

    MovingAverageFromDataStream(int windowSize) {
        this.queue = new SimpleQueue<>(windowSize);
    }

    public double next(int newNumber) {
        if (this.queue.isEmpty()) {
            this.queue.push(newNumber);
            this.sum = newNumber;
            return newNumber;
        }
        this.sum += newNumber;

        if (this.queue.isFull()) {
            var front = this.queue.poll();
            this.sum -= front;
        }
        this.queue.push(newNumber);
        return this.sum / this.queue.size();
    }
}
