package problems;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class PerfectSquaresTests {

    @Test
    public void itWorks() {
        int n = 12;
        int expected = 3; // 4 + 4 + 4

        assertEquals(expected, PerfectSquares.solution(n));
    }

    @Test
    public void itWorks2() {
        int n = 13;
        int expected = 2;   // 9 + 4

        assertEquals(expected, PerfectSquares.solution(n));
    }

    @Test
    public void itWorks3() {
        int n = 296;
        int expected = 2;   // 9 + 4

        assertEquals(expected, PerfectSquares.solution(n));
    }
}
