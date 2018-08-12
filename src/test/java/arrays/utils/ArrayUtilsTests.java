package arrays.utils;

import lombok.val;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class ArrayUtilsTests {

    @Test
    public void TestEvenSizeArray() {
        val array = new Integer[]{1, 2, 3, 4};
        val expected = new Integer[]{4, 3, 2, 1};

        ArrayUtils.reverse(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void TestOddSizeArray() {
        val array = new Integer[]{1, 2, 3, 4, 5};
        val expected = new Integer[]{5, 4, 3, 2, 1};

        ArrayUtils.reverse(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void TestEmptyArray() {
        val array = new Integer[]{};
        val expected = new Integer[]{};

        ArrayUtils.reverse(array);
        assertArrayEquals(expected, array);
    }

    @Test
    public void TestSingleElementArray() {
        val array = new Integer[]{1};
        val expected = new Integer[]{1};

        ArrayUtils.reverse(array);
        assertArrayEquals(expected, array);
    }
}
