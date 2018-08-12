package problems;

import arrays.utils.ArrayUtils;
import arrays.utils.PrintUtils;
import org.junit.Test;

import static junit.framework.TestCase.assertFalse;
import static junit.framework.TestCase.assertTrue;

public class OneDimensionalPeakTests {

    @Test
    public void itCanFindAPeak() {
        Integer[] array = new Integer[]{1, 4, 5, 2, 3};

        PrintUtils.prettyPrint(array);

        assertTrue(OneDimensionalPeak.solution(array));
    }

    @Test
    public void itDoesNotFindAPeakWhenAllEqual() {
        Integer[] array = new Integer[]{1, 1, 1, 1, 1};

        PrintUtils.prettyPrint(array);

        assertFalse(OneDimensionalPeak.solution(array));
    }

    @Test
    public void itDoesNotFindAPeakIncreasing() {
        Integer[] array = new Integer[]{1, 2, 3, 4, 5, 6, 7};

        PrintUtils.prettyPrint(array);

        assertFalse(OneDimensionalPeak.solution(array));
    }

    @Test
    public void itDoesNotFindAPeakDecreasing() {
        Integer[] array = new Integer[]{7, 6, 5, 4, 3, 2, 1};

        PrintUtils.prettyPrint(array);

        assertFalse(OneDimensionalPeak.solution(array));
    }

    @Test
    public void itFindsAPeakOnTheLeftSide() {
        Integer[] array = new Integer[]{4, 6, 4, 4, 1, 2, 6};

        PrintUtils.prettyPrint(array);

        assertTrue(OneDimensionalPeak.solution(array));
    }

    @Test
    public void itFindsAPeakOnTheRightSide() {
        Integer[] array = new Integer[]{4, 6, 4, 4, 1, 2, 6};
        ArrayUtils.reverse(array);
        PrintUtils.prettyPrint(array);

        assertTrue(OneDimensionalPeak.solution(array));
    }
}
