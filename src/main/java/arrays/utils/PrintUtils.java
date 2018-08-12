package arrays.utils;

import lombok.val;
import org.apache.commons.lang3.StringUtils;

import java.util.stream.IntStream;

/**
 * there's pretty obvious flaws here re- performance and cases where
 * a multidimensional array has different lengths, just used here for
 * quick visual comparisons on test cases.
 */
public class PrintUtils {
    private static String VERTICAL_WALL_TEXT = " | ";

    public static <T> void prettyPrintMultiDimensional(T[][] array) {
        int maxLength = 0;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                String val = "" + array[i][j];
                maxLength = Math.max(maxLength, val.length());
            }
        }

        for (int i = 0; i < array.length; i++) {
            prettyPrintPadded(array[i], maxLength);
        }
    }

    private static <T> void prettyPrintPadded(T[] array, int requiredElementLength) {
        if (array.length > 0) {
            System.out.print(PrintUtils.VERTICAL_WALL_TEXT);
        }
        for (int j = 0; j < array.length; j++) {
            String val = "" + array[j].toString();
            writeThing(StringUtils.center(val, requiredElementLength - val.length() + 1));
            System.out.print(PrintUtils.VERTICAL_WALL_TEXT);
        }
        System.out.println();
    }


    public static <T> void prettyPrint(T[] array) {
        val indexes = IntStream.rangeClosed(0, array.length - 1)
                .boxed()
                .map(n -> "i:" + n)
                .toArray();
        val prettyArray = new Object[][]{
                array,
                indexes
        };

        prettyPrintMultiDimensional(prettyArray);
    }

    private static <T> void writeThing(T thing) {
        System.out.format(" %s ", thing);
    }
}
