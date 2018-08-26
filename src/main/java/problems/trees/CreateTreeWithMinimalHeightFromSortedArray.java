package problems.trees;


import trees.BinaryTreeNode;

/**
 * CTCI 4.2 Given a sorted array, create a BST with minimal height.
 * <p>
 * 1 4 6 8 11 12 17
 * 8
 * 4     12
 * 1  6  11  17
 */
public class CreateTreeWithMinimalHeightFromSortedArray {
    public static BinaryTreeNode<Integer> solution(int[] arr) {
        int start = 0;
        int end = arr.length - 1;

        int mid = end / 2;

        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(arr[mid]);
        root.setLeft(solutionImpl(arr, start, mid - 1));
        root.setRight(solutionImpl(arr, mid + 1, end));
        return root;
    }

    private static BinaryTreeNode<Integer> solutionImpl(int[] arr, int start, int end) {
        if (start > end || start < 0 || start >= arr.length || end >= arr.length) {
            return null;
        }
        int mid = (start + end) / 2;
        BinaryTreeNode<Integer> root = new BinaryTreeNode<>(arr[mid]);
        root.setLeft(solutionImpl(arr, start, mid - 1));
        root.setRight(solutionImpl(arr, mid + 1, end));
        return root;
    }

}
