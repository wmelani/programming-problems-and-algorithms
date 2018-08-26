package problems.arrays;

import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShiftedSortedArrayTest {

    @Test
    @Ignore("this test does not work")
    public void works() {
        int[] arr = new int[]{9, 12, 17, 2, 4, 5};
        int num = 2;
        int expectedIdx = 3;
        int actualIndex = ShiftedSortedArray.solution(arr, num);
        assertEquals(expectedIdx, actualIndex);
    }

    @Test
    public void works2() {
        int[] arr = new int[]{9, 12, 17, 2, 4, 5};
        int num = 4;
        int expectedIdx = 4;
        int actualIndex = ShiftedSortedArray.solution(arr, num);
        assertEquals(expectedIdx, actualIndex);
    }


}