package problems.grids;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class NumIslandsTests {
    @Test
    public void testSimpleCase() {
        char[][] grid = new char[][]{
                {'1', '0', '1', '0'},
                {'1', '0', '0', '0'},
                {'1', '0', '1', '1'},
                {'1', '0', '1', '1'},
        };
        int expected = 3;
        assertEquals(expected, NumIslands.solution(grid));
    }

    @Test
    public void testSingleRow() {
        char[][] grid = new char[][]{
                {'1', '0', '1', '0'}
        };
        int expected = 2;
        assertEquals(expected, NumIslands.solution(grid));
    }

    @Test
    public void testSingleColumn() {
        char[][] grid = new char[][]{
                {'1'},
                {'1'},
                {'1'},
                {'1'},
                {'0'},
                {'0'},
                {'1'},
                {'1'},
        };
        int expected = 2;
        assertEquals(expected, NumIslands.solution(grid));
    }

    @Test
    public void testAllOnes() {
        char[][] grid = new char[][]{
                {'1', '1', '1', '1'},
                {'1', '1', '1', '1'},
                {'1', '1', '1', '1'},
                {'1', '1', '1', '1'},
        };
        int expected = 1;
        assertEquals(expected, NumIslands.solution(grid));
    }

    @Test
    public void testAllZeroes() {
        char[][] grid = new char[][]{
                {'0', '0', '0', '0'},
                {'0', '0', '0', '0'},
                {'0', '0', '0', '0'},
                {'0', '0', '0', '0'},
        };
        int expected = 0;
        assertEquals(expected, NumIslands.solution(grid));
    }
}
