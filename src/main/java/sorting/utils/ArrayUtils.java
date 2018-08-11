package sorting.utils;

import java.util.Arrays;
import java.util.stream.Collectors;

public class ArrayUtils {
    public static <T> void swap(T[] arr, int idx1, int idx2) {
        T temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    public static <T> void print(T[] arr) {
        System.out.format("[%s]", Arrays.stream(arr).map(Object::toString).collect(Collectors.joining(",")));
        System.out.println();
    }

}
