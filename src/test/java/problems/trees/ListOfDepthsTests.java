package problems.trees;

import org.junit.Test;
import trees.BinaryTreeNode;
import trees.utils.PrintUtils;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class ListOfDepthsTests {

    @Test
    public void solutionN() {
        BinaryTreeNode<Integer> tree = new BinaryTreeNode<>(1);
        tree.setLeft(new BinaryTreeNode<>(2));
        tree.setRight(new BinaryTreeNode<>(3));
        tree.getLeft().setLeft(new BinaryTreeNode<>(4));
        tree.getLeft().setRight(new BinaryTreeNode<>(5));
        PrintUtils.prettyPrint(tree);
        var result = ListOfDepths.solutionN(tree);
        result.stream().map(List::toArray).forEach(arrays.utils.PrintUtils::prettyPrint);
        assertEquals(3, result.size());
        assertEquals(1, (int) result.get(0).get(0));
        assertEquals(2, (int) result.get(1).get(0));
        assertEquals(3, (int) result.get(1).get(1));
        assertEquals(4, (int) result.get(2).get(0));
        assertEquals(5, (int) result.get(2).get(1));
    }
}