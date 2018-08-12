package problems;

import org.junit.Test;

import java.util.Optional;

import static junit.framework.TestCase.*;

// sample data taken from Introduction to Algorithms
public class MaximumSubarrayTests {

    @Test
    public void canFindTheBestSolution1() {

        int[] vals = new int[]{100, 113, 110, 85, 105, 102, 86, 63, 81, 101, 94, 106, 101, 79, 94, 90, 97};
        Optional<Integer> res = MaximumSubarray.solution(vals);
        assertTrue(res.isPresent());
        assertEquals(106 - 63, (int) res.get());
    }

    @Test
    public void canFindTheBestSolution2() {
        int[] vals = new int[]{10, 11, 7, 10, 6};

        Optional<Integer> res = MaximumSubarray.solution(vals);
        assertTrue(res.isPresent());
        assertEquals(3, (int) res.get());
    }

    @Test
    public void returnsEmptyOptionalIfNotProfitable() {
        int[] vals = new int[]{10, 10, 10, 10, 10, 10};

        Optional<Integer> res = MaximumSubarray.solution(vals);
        assertFalse(res.isPresent());
    }

    @Test
    public void returnsEmptyOptionalIfNotProfitableAndNegative() {
        int[] vals = new int[]{10, 6, 5, 3, 1};

        Optional<Integer> res = MaximumSubarray.solution(vals);
        assertFalse(res.isPresent());
    }

    @Test
    public void returnsEmptyOptionalIfNotEnoughDays() {
        int[] vals = new int[]{10};

        Optional<Integer> res = MaximumSubarray.solution(vals);
        assertFalse(res.isPresent());
    }
}
