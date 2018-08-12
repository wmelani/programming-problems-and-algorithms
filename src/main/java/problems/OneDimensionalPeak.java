package problems;

import lombok.NonNull;
import lombok.val;

import java.util.Optional;

/**
 * Problem:
 * <p>
 * Given an array of numbers, determine if there is an index i such that i is greater than its two sides.
 * <p>
 * EX:
 * [ 1 4 5 2 3 ]
 * <p>
 * Output: true [ 1 4 5 2 3 ] (5 is the peak)
 * <p>
 * EX:
 * [ 1 5 5 2 6 ]
 * *
 * * Output: false
 */
public class OneDimensionalPeak {

    static boolean solution(@NonNull Integer[] array) {
        if (array.length == 0) {
            return false;
        }
        val result = OneDimensionalPeak.findOneDimensionalPeak(array, 0, array.length - 1);
        return result.isPresent();
    }

    private static Optional<Integer> findOneDimensionalPeak(Integer[] array, int indexStart, int indexEnd) {
        int indexMiddle = indexStart + (indexEnd - indexStart) / 2;
        if (indexMiddle == 0 || indexMiddle == array.length - 1) {
            return Optional.empty();
        }
        if (array[indexMiddle] > array[indexMiddle - 1] && array[indexMiddle] > array[indexMiddle + 1]) {
            System.out.format("Found peak at index %s, %s *%s* %s\n",
                    indexMiddle,
                    array[indexMiddle - 1],
                    array[indexMiddle],
                    array[indexMiddle + 1]);
            return Optional.of(indexMiddle);
        }
        if (array[indexMiddle] > array[indexMiddle + 1]) {
            System.out.format("At index %s, value = %s, moving left\n",
                    indexMiddle,
                    array[indexMiddle]);
            return findOneDimensionalPeak(array, indexStart, indexMiddle - 1);
        }
        if (array[indexMiddle] < array[indexMiddle - 1]) {
            System.out.format("At index %s, value = %s, moving right\n",
                    indexMiddle,
                    array[indexMiddle]);
            return findOneDimensionalPeak(array, indexMiddle + 1, indexEnd);
        }
        System.out.format("At index %s, value = %s, moving right\n",
                indexMiddle,
                array[indexMiddle]);
        return findOneDimensionalPeak(array, indexMiddle + 1, indexEnd);
    }
}
