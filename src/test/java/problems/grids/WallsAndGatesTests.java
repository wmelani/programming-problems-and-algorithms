package problems.grids;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class WallsAndGatesTests {
    private static final int INF = 2147483647;

    @Test
    public void testSimpleCase() {
        int[][] grid = new int[][]{
                {INF, -1, 0, INF},
                {INF, INF, INF, -1},
                {INF, -1, INF, -1},
                {0, -1, INF, INF},
        };
        int[][] expected = new int[][]{
                {3, -1, 0, 1},
                {2, 2, 1, -1},
                {1, -1, 2, -1},
                {0, -1, 3, 4},
        };
        WallsAndGates.solution(grid);
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                assertEquals(grid[i][j], expected[i][j]);
            }
        }
    }

}
