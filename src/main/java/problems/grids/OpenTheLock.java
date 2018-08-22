package problems.grids;

import datastructures.Queue;
import datastructures.SimpleQueue;

import java.util.HashSet;
import java.util.List;

/**
 * From leetcode
 * <p>
 * You have a lock in front of you with 4 circular wheels.
 * Each wheel has 10 slots: '0', '1', '2', '3', '4', '5', '6', '7', '8', '9'.
 * The wheels can rotate freely and wrap around: for example we can turn '9' to be '0', or '0' to be '9'.
 * Each move consists of turning one wheel one slot.
 * <p>
 * The lock initially starts at '0000', a string representing the state of the 4 wheels.
 * <p>
 * You are given a list of deadends dead ends, meaning if the lock displays any of these codes,
 * the wheels of the lock will stop turning and you will be unable to open it.
 * <p>
 * Given a target representing the value of the wheels that will unlock the lock,
 * return the minimum total number of turns required to open the lock, or -1 if it is impossible.
 * <p>
 * Example 1:
 * Input: deadends = ["0201","0101","0102","1212","2002"], target = "0202"
 * Output: 6
 * Explanation:
 * A sequence of valid moves would be "0000" -> "1000" -> "1100" -> "1200" -> "1201" -> "1202" -> "0202".
 * Note that a sequence like "0000" -> "0001" -> "0002" -> "0102" -> "0202" would be invalid,
 * because the wheels of the lock become stuck after the display becomes the dead end "0102".
 * Example 2:
 * Input: deadends = ["8888"], target = "0009"
 * Output: 1
 * Explanation:
 * We can turn the last wheel in reverse to move from "0000" -> "0009".
 * Example 3:
 * Input: deadends = ["8887","8889","8878","8898","8788","8988","7888","9888"], target = "8888"
 * Output: -1
 * Explanation:
 * We can't reach the target without getting stuck.
 * Example 4:
 * Input: deadends = ["0000"], target = "8888"
 * Output: -1
 * Note:
 * The length of deadends will be in the range [1, 500].
 * target will not be in the list deadends.
 * Every string in deadends and the string target will be a string of 4 digits from the 10,000 possibilities '0000' to '9999'.
 */
public class OpenTheLock {
    public static int solution(String[] deadends, String target) {
        var start = "0000";
        HashSet<String> disallowed = new HashSet<>(List.of(deadends));

        // case where the deadend is the starting point, the lock is jammed forever
        if (disallowed.contains(start)) {
            return -1;
        }
        HashSet<String> visited = new HashSet<>();
        Queue<String> q = new SimpleQueue<>(10000);
        q.push(start);
        visited.add(start);
        int changes = 0;
        while (!q.isEmpty()) {

            // since each iteration adds up to 8 elements into the queue (all possible positions for each of the 4
            // rings) we should explore all of them before incrementing the `changes` variable that represents the distance
            // away.
            int size = q.size();
            while (size > 0) {
                String current = q.poll();
                if (current.equals(target)) {
                    return changes;
                }
                size--;
                addNeighbors(q, current, visited, disallowed);
            }
            changes++;
        }
        return -1;
    }

    private static Queue<String>
    addNeighbors(Queue<String> q, String current, HashSet<String> visited, HashSet<String> disallowed) {
        Queue<String> neighbors = new SimpleQueue<>(8);
        for (int i = 0; i < current.length(); i++) {
            var stringBefore = "";
            if (i > 0) {
                stringBefore = current.substring(0, i);
            }
            var stringAfter = "";
            if (i + 1 < current.length()) {
                stringAfter = current.substring(i + 1);
            }
            int currentDigit = Integer.parseInt(current.charAt(i) + "");
            int optionOne = currentDigit == 9 ? 0 : currentDigit + 1;
            int optionTwo = currentDigit == 0 ? 9 : currentDigit + -1;
            String oneTurn = String.format("%s%s%s", stringBefore, optionOne, stringAfter);
            String twoTurn = String.format("%s%s%s", stringBefore, optionTwo, stringAfter);

            if (!disallowed.contains(oneTurn) && !visited.contains(oneTurn)) {
                q.push(oneTurn);
                neighbors.push(oneTurn);
                visited.add(oneTurn);
            }
            if (!disallowed.contains(twoTurn) && !visited.contains(twoTurn)) {
                q.push(twoTurn);
                neighbors.push(twoTurn);
                visited.add(twoTurn);
            }

        }
        return neighbors;
    }
}
