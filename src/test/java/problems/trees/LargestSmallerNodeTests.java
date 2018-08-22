package problems.trees;

import org.junit.Test;
import trees.BinaryTreeNode;

import static org.junit.Assert.assertEquals;

public class LargestSmallerNodeTests {

    //
    //                 20
    //              9       25
    //            5    12
    //               11  14
    //

    @Test
    public void testWorks() {
        var node = new BinaryTreeNode<Integer>(20);
        node.setLeft(new BinaryTreeNode<>(9));
        node.setRight(new BinaryTreeNode<>(25));
        node.getLeft().setLeft(new BinaryTreeNode<>(5));
        node.getLeft().setRight(new BinaryTreeNode<>(12));
        node.getLeft().getRight().setLeft(new BinaryTreeNode<>(11));
        node.getLeft().getRight().setRight(new BinaryTreeNode<>(14));
        assertEquals(14, LargestSmallerNode.solution(node, 17));
    }

    @Test
    public void testWorks2() {
        var node = new BinaryTreeNode<Integer>(20);
        node.setLeft(new BinaryTreeNode<>(9));
        node.setRight(new BinaryTreeNode<>(25));
        node.getLeft().setLeft(new BinaryTreeNode<>(5));
        node.getLeft().setRight(new BinaryTreeNode<>(12));
        node.getLeft().getRight().setLeft(new BinaryTreeNode<>(11));
        node.getLeft().getRight().setRight(new BinaryTreeNode<>(14));
        assertEquals(20, LargestSmallerNode.solution(node, 25));
    }

    @Test
    public void testWorks3() {
        var node = new BinaryTreeNode<Integer>(20);
        node.setLeft(new BinaryTreeNode<>(9));
        node.setRight(new BinaryTreeNode<>(25));
        node.getLeft().setLeft(new BinaryTreeNode<>(5));
        node.getLeft().setRight(new BinaryTreeNode<>(12));
        node.getLeft().getRight().setLeft(new BinaryTreeNode<>(11));
        node.getLeft().getRight().setRight(new BinaryTreeNode<>(14));
        assertEquals(-1, LargestSmallerNode.solution(node, 1));
    }


}