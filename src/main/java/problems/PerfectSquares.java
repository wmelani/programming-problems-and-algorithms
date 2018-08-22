package problems;

import java.util.ArrayList;
import java.util.List;

public class PerfectSquares {

    public static int solution(int n) {
        if (n == 1) {
            return 1;
        }
        List<Integer> squares = new ArrayList<Integer>();
        for (int i = 1; i < n; i++) {
            double square = Math.pow(i, 2);
            if (square > n) {
                break;
            }
            squares.add((int) square);
            System.out.println(square);
        }

        int count = count(squares, squares.size(), n, 0, Integer.MAX_VALUE);
        return count;
    }

    private static int count(List<Integer> perfectSquares, int endIndex, int target, int count, int minSoFar) {
        if (count > minSoFar) {
            return Integer.MAX_VALUE;
        }
        int min = minSoFar;
        for (int i = endIndex - 1; i >= 0; i--) {
            int current = perfectSquares.get(i);
            if (target - current > 0) {
                min =
                        Math.min(min,
                                count(perfectSquares, i + 1, target - current, count + 1, minSoFar));
            }
            if (target - current == 0) {
                return count + 1;
            }
        }
        return min;
    }
}
