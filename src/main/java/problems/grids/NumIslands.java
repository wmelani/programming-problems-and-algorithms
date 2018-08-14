package problems.grids;

/**
 * From leetcode, pramp
 * <p>
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 * <p>
 * Example 1:
 * <p>
 * Input:
 * 11110
 * 11010
 * 11000
 * 00000
 * <p>
 * Output: 1
 * Example 2:
 * <p>
 * Input:
 * 11000
 * 11000
 * 00100
 * 00011
 * <p>
 * Output: 3
 */
public class NumIslands {
    public static int solution(char[][] grid) {
        if (grid.length == 0) {
            return 0;
        }
        int islandCount = 0;
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1' && !visited[i][j]) {
                    visit(grid, i, j, visited);
                    islandCount++;
                } else {
                    visited[i][j] = true;
                }
            }
        }
        return islandCount;
    }

    private static void visit(char[][] grid, int x, int y, boolean[][] visited) {
        if (x < 0 || y < 0 || x >= grid.length || y >= grid[x].length || visited[x][y]) {
            return;
        }
        visited[x][y] = true;
        if (grid[x][y] == '1') {
            visit(grid, x - 1, y, visited);
            visit(grid, x + 1, y, visited);
            visit(grid, x, y - 1, visited);
            visit(grid, x, y + 1, visited);
        }
    }
}
