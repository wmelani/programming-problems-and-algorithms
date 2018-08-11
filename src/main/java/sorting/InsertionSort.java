package sorting;

import sorting.utils.ArrayUtils;

/*
Insertion Sort works by finding the correct element to go into a given index. Starting with the first index, we assume
that the list beginning from that index is sorted.

[6,8,3,5,4,10,2,1], sublist [6]

Then we traverse the rest of the array, starting at the first index not in the sorted array

[6,8(here),3,5,4,10,2,1], sublist [6]

If this entry is less than the prior, we can swap it with the previous index.

< no swap, 6 is less than 8 >

Since we're at the beginning index, we know the array with [6,8] is sorted.

We move to the next index.

[6,8,3(here),5,4,10,2,1], sublist [6,8]

We compare 3 with the earlier entry 8. 3 is smaller, so we need to swap 3 with 8.

[6,3,8,5,4,10,2,1], sublist [6,3]

Since the index of 3 is still greater than 0, we know there is another swap possible.

[6,3(here),8,5,4,10,2,1], sublist [6,3]

We compare 3 with the earlier entry 6. 3 is smaller, so we need to swap 3 with 6.

[3,6,8,5,4,10,2,1], sublist [3,6,8]

We're back at the beginning of the list, and 3 elements are now considered sorted.

[3,6,8,5(here),4,10,2,1], sublist [3,6,8]

We compare 5 with 8. We swap them.

[3,6,5(here),8,4,10,2,1], sublist [3,6,5,8]

We compare 5 with 6. We swap them.

[3,5(here),6,8,4,10,2,1], sublist [3,5,6,8]

We compare 5 with 3. 5 is not smaller. We *break* out of the loop, since we know all elements to the left will be smaller.


Time Complexity: O(N^2) algorithm because it visits each index N times in worst case
Space Complexity: O(1), no extra space besides swap.
Stability: Yes, It is a stable sort because elements are kept in place where possible



 */
public class InsertionSort {


    public static void sort(Integer[] array) {
        System.out.print("Initial: ");
        ArrayUtils.print(array);
        int operations = 0;
        int swaps = 0;

        for (int i = 0; i < array.length - 1; i++) {
            System.out.format("i is %s\n", i);
            for (int j = i + 1; j > 0; j--) {
                operations++;
                int right = array[j];
                int left = array[j - 1];
                System.out.format("Comparing %s with %s\n", left, right);
                if (right < left) {
                    ArrayUtils.swap(array, j, j - 1);
                    swaps++;
                    ArrayUtils.print(array);
                } else {
                    ArrayUtils.print(array);
                    break;
                }

            }


        }
        System.out.format("Done in %s operations and %s swaps\n", operations, swaps);
    }

}
