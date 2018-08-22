package problems.trees;

import trees.BinaryTreeNode;

/**
 * From: pramp
 * <p>
 * Given a root of a Binary Search Tree (BST) and a number num, implement an efficient function findLargestSmallerKey that finds the largest key in the tree that is smaller than num. If such a number doesn’t exist, return -1. Assume that all keys in the tree are nonnegative.
 * <p>
 * Analyze the time and space complexities of your solution.
 * <p>
 * For example:
 * <p>
 * For num = 17 and the binary search tree below:
 * <p>
 * 20
 * 9       25
 * 5    12
 * 11  14
 * Your function would return:
 * <p>
 * 14 since it’s the largest key in the tree that is still smaller than 17
 */
public class LargestSmallerNode {

    public static int solution(BinaryTreeNode<Integer> tree, int num) {

        var current = tree;
        int largestSmallerSeenSoFar = Integer.MIN_VALUE;
        while (current != null) {
            if (current.getValue() < num) {
                largestSmallerSeenSoFar = current.getValue();
            }
            if (current.getValue() > num) {
                current = current.getLeft();
            } else if (current.getValue() == num) {
                return largestSmallerSeenSoFar;
            } else if (current.getValue() < num) {
                current = current.getRight();
            }
        }
        if (largestSmallerSeenSoFar == Integer.MIN_VALUE) {
            return -1;
        }
        return largestSmallerSeenSoFar;
    }
}
