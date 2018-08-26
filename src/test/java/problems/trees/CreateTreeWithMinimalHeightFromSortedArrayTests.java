package problems.trees;

import org.junit.Test;
import trees.BinaryTreeHelper;
import trees.BinaryTreeNode;
import trees.utils.PrintUtils;

import static junit.framework.TestCase.assertEquals;

public class CreateTreeWithMinimalHeightFromSortedArrayTests {

    @Test
    public void test1() {
        /*
         * 1 4 6 8 11 12 17
         *           8
         *         4     12
         *      1  6  11  17
         *
         */
        int[] arr = new int[]{1, 4, 6, 8, 11, 12, 17};
        BinaryTreeNode<Integer> root = CreateTreeWithMinimalHeightFromSortedArray.solution(arr);
        int depth = BinaryTreeHelper.heightOfTree(root);
        PrintUtils.prettyPrint(root);
        assertEquals(3, depth);
    }

    @Test
    public void test2() {
        int[] arr = new int[]{1};
        BinaryTreeNode<Integer> root = CreateTreeWithMinimalHeightFromSortedArray.solution(arr);
        int depth = BinaryTreeHelper.heightOfTree(root);
        PrintUtils.prettyPrint(root);
        assertEquals(1, depth);
    }
}