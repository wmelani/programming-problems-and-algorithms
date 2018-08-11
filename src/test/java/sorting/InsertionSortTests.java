package sorting;

import org.junit.Test;
import sorting.utils.ArrayUtils;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

public class InsertionSortTests {

    @Test
    public void canSortProperly() {
        Integer[] arr = new Integer[]{6, 8, 3, 5, 4, 10, 2, 1};
        Integer[] sortedExpected = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedExpected);
        System.out.print("Expected: ");
        ArrayUtils.print(sortedExpected);

        InsertionSort.sort(arr);
        assertArrayEquals(sortedExpected, arr);

    }

    @Test
    public void canSortAlreadySortedAsc() {
        Integer[] arr = new Integer[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        Integer[] sortedExpected = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedExpected);
        System.out.print("Expected: ");
        ArrayUtils.print(sortedExpected);

        InsertionSort.sort(arr);
        assertArrayEquals(sortedExpected, arr);

    }

    @Test
    public void canSortAlreadySortedDesc() {
        Integer[] arr = new Integer[]{10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        Integer[] sortedExpected = Arrays.copyOf(arr, arr.length);
        Arrays.sort(sortedExpected);
        System.out.print("Expected: ");
        ArrayUtils.print(sortedExpected);

        InsertionSort.sort(arr);
        assertArrayEquals(sortedExpected, arr);

    }
}
