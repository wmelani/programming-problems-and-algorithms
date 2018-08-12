package arrays.utils;

public class ArrayUtils {
    public static <T> void reverse(T[] array) {
        for (int i = 0; i < array.length / 2; i++) {
            int reverseIndex = array.length - i - 1;
            T temp = array[reverseIndex];
            array[reverseIndex] = array[i];
            array[i] = temp;
        }
    }
}
