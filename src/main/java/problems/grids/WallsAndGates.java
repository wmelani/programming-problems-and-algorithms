package problems.grids;

/**
 * taken from leetcoder
 * https://leetcode.com/explore/learn/card/queue-stack/231/practical-application-queue/1373/
 * <p>
 * This section was about 'creatively applying BFS' as part of a section on queues, but the algorithms did not
 * involve a queue. very similar question to NumIslands. My first solution involved a BFS queue, creating a graph, etc,
 * but it was not necessary.
 * <p>
 * You are given a m x n 2D grid initialized with these three possible values.
 * <p>
 * -1 - A wall or an obstacle.
 * 0 - A gate.
 * INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent
 * INF as you may assume that the distance to a gate is less than 2147483647.
 * Fill each empty room with the distance to its nearest gate.
 * If it is impossible to reach a gate, it should be filled with INF.
 * <p>
 * Example:
 * <p>
 * Given the 2D grid:
 * <p>
 * INF  -1  0  INF
 * INF INF INF  -1
 * INF  -1 INF  -1
 * 0  -1 INF INF
 * After running your function, the 2D grid should be:
 * <p>
 * 3  -1   0   1
 * 2   2   1  -1
 * 1  -1   2  -1
 * 0  -1   3   4
 */
public class WallsAndGates {

    public static void solution(int[][] rooms) {
        for (int i = 0; i < rooms.length; i++) {
            for (int j = 0; j < rooms[i].length; j++) {
                if (rooms[i][j] == 0) {
                    recurse(rooms, i, j, 0);
                }
            }
        }
    }

    private static void recurse(int[][] rooms, int i, int j, int nearestExit) { // may be behind you
        if (i < 0 || i >= rooms.length || j < 0 || j >= rooms[i].length) {
            return;
        }
        int val = rooms[i][j];
        if (val == -1) {
            return;
        }
        if (val < nearestExit) {
            return;
        }
        rooms[i][j] = nearestExit;
        recurse(rooms, i, j + 1, nearestExit + 1);
        recurse(rooms, i, j - 1, nearestExit + 1);
        recurse(rooms, i + 1, j, nearestExit + 1);
        recurse(rooms, i - 1, j, nearestExit + 1);

    }

}
