package problems;

import arrays.utils.PrintUtils;

import java.util.Arrays;
import java.util.Optional;

/**
 * 4.1 The maximum-subarray problem from Introduction to Algorithms
 * (pg 89)
 * <p>
 * Given a list of stock prices, determine the best day to buy
 * and the best day to sell a given stock to achieve maximum profit.
 * <p>
 * Return an integer representing the money you could make.
 */
public class MaximumSubarray {

    static Optional<Integer> bruteForce(int[] prices) {
        if (prices.length < 2) {
            return Optional.empty();
        }
        int buyIdx = 0;
        int sellIdx = 1;
        int max = prices[sellIdx] - prices[buyIdx];
        for (int i = 0; i < prices.length - 1; i++) {
            int buyPrice = prices[i];
            for (int j = i + 1; j < prices.length; j++) {
                int sellPrice = prices[j];
                int profit = (sellPrice - buyPrice);
                if (profit > max) {
                    max = profit;
                }
            }
        }
        if (max > 0) {
            return Optional.of(max);
        }
        return Optional.empty();
    }

    /**
     * This solution works by checking each day, and determining
     * <p>
     * <p>
     * If we sold now, would we have made more money than the cheapest day we've seen? if so, update to say that today
     * is our most profitable so far.
     * Is today the cheapest day, if so, set today as the min.
     * <p>
     * |  10  |  11  |   7   |  10  |   6   |
     * <p>
     * result = 0
     * min = 10;
     * <p>
     * i = 1
     * result = 1 (0 vs 11-10)
     * min = 10
     * i = 2
     * result = 1 (1 vs -3)
     * min = 7
     * i = 3
     * result = 3 (1 vs 3)
     * min = 7
     * i = 4
     * result = 3 (1 vs -1)
     * min = 6
     * loop ends
     * returns result (3)
     */
    static Optional<Integer> solution(int[] prices) {
        if (prices.length < 2) {
            System.out.format("Not enough days to buy and sell.\n");
            return Optional.empty();
        }

        int min = prices[0];
        int mostProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (mostProfit < prices[i] - min) {
                mostProfit = prices[i] - min;
            }
            if (min > prices[i]) {
                min = prices[i];
            }
        }
        PrintUtils.prettyPrint(Arrays.stream(prices).boxed().toArray());
        if (mostProfit > 0) {
            System.out.format("Most profit possible: %s\n", mostProfit);
            return Optional.of(mostProfit);
        }
        System.out.println("There were no profitable days");
        return Optional.empty();
    }
}
