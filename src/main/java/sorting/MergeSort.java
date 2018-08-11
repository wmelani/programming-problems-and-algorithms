package sorting;

import sorting.utils.ArrayUtils;

/*
Merge Sort divides an array recursively into two smaller arrays that are 1/2 the size.
The left array is merged via MergeSort
The right array is merged via MergeSort

the left and right arrays are then merged together into a new array
the new array is returned.


Time Complexity: O(N log N) algorithm because it chunks the array and works and smaller and smaller pieces.
Space Complexity: O(N), every entry is stored in a new array.
Stability: Yes, It is a stable sort because elements are kept in place where possible



 */
public class MergeSort {
    public static Integer[] sort(Integer[] array) {
        System.out.print("Initial: ");
        ArrayUtils.print(array);

        MergeSort.Instrumentation instrumentation = new MergeSort.Instrumentation();
        Integer[] arr = MergeSort.mergeSortImpl(array, instrumentation);
        ArrayUtils.print(arr);
        System.out.format("Merge Sort did %s array splits, %s merges, and %s order comparisons\n",
                instrumentation.arraySplits, instrumentation.merges, instrumentation.comparisons);
        return arr;

    }

    public static Integer[] mergeSortImpl(Integer[] array, MergeSort.Instrumentation instrumentation) {
        if (array.length <= 1) {
            return array;
        }

        Integer[] leftArr = new Integer[array.length / 2];

        for (int i = 0; i < array.length / 2; i++) {
            leftArr[i] = array[i];
        }
        int rightSize = array.length % 2 == 0 ? array.length / 2 : (array.length / 2 + 1);
        Integer[] rightArr = new Integer[rightSize];
        for (int i = 0, j = array.length / 2; j < array.length; j++) {
            rightArr[i++] = array[j];
        }
        instrumentation.arraySplits++;

        Integer[] leftSide = MergeSort.mergeSortImpl(leftArr, instrumentation);
        ArrayUtils.print(leftSide);
        Integer[] rightSide = MergeSort.mergeSortImpl(rightArr, instrumentation);
        ArrayUtils.print(rightSide);

        Integer[] res = MergeSort.mergeImpl(leftSide, rightSide, instrumentation);
        ArrayUtils.print(res);
        instrumentation.merges++;
        return res;
    }

    private static Integer[] mergeImpl(Integer[] arrayOne, Integer[] arrayTwo,
                                       MergeSort.Instrumentation instrumentation) {
        int total = arrayOne.length + arrayTwo.length;
        Integer[] newArray = new Integer[total];

        System.out.println("Merging Arrays");
        ArrayUtils.print(arrayOne);
        ArrayUtils.print(arrayTwo);
        int leftPtr = 0;
        int rightPtr = 0;

        int idx = 0;
        while (leftPtr < arrayOne.length && rightPtr < arrayTwo.length) {
            if (arrayOne[leftPtr] <= arrayTwo[rightPtr]) {
                newArray[idx++] = arrayOne[leftPtr];
                leftPtr++;
            } else {
                newArray[idx++] = arrayTwo[rightPtr];
                rightPtr++;
            }
            instrumentation.comparisons++;
        }
        while (leftPtr < arrayOne.length) {
            newArray[idx++] = arrayOne[leftPtr++];
        }
        while (rightPtr < arrayTwo.length) {
            newArray[idx++] = arrayTwo[rightPtr++];
        }
        ArrayUtils.print(newArray);
        return newArray;
    }

    static class Instrumentation {
        int comparisons = 0;
        int arraySplits = 0;
        int merges = 0;
    }


}
