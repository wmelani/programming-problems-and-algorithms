package sorting;

import sorting.utils.ArrayUtils;

/*
Bubble sort works by iterating over the entire array and swapping elements as it sees that a given entry is smaller
than the previous.

Time Complexity: O(N^2) algorithm because it visits each index N times in worst case
Space Complexity: O(1), no extra space besides swap.
Stability: Yes, It is a stable sort because elements are kept in place where possible



 */
public class BubbleSort {


    public static void sort(Integer[] array) {
        System.out.print("Initial: ");
        ArrayUtils.print(array);
        int operations = 0;
        int swaps = 0;

        // iterate over entire array to perform swaps starting at each index.
        for (int i = 0; i < array.length - 1; i++) {
            boolean didSwap = false;

            // iterate starting at each entry, and up to the new end of the list. as elements are put in place
            // after each iteration, it is not necessary to go over the entire list, as each loop of the parent for
            // makes the section of the array that is unsorted 1 smaller.

            for (int j = 0; j < array.length - i - 1; j++) {
                int left = array[j];
                int right = array[j + 1];
                System.out.format("Comparing %s with %s\n", left, right);
                if (left > right) {
                    didSwap = true;
                    ArrayUtils.swap(array, j, j + 1);
                    System.out.format("Swapped %s with %s\n", left, right);
                    swaps++;
                }
                operations++;
                ArrayUtils.print(array);
            }
            if (!didSwap) {
                // array is already sorted, we can bail out fast.
                System.out.println("array sorted");
                System.out.format("Done in %s operations and %s swaps\n", operations, swaps);
                return;
            }
        }
        System.out.format("Done in %s operations and %s swaps\n", operations, swaps);
    }

}
