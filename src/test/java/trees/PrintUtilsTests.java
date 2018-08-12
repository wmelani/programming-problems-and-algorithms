package trees;

import org.junit.Test;
import trees.utils.PrintUtils;

public class PrintUtilsTests {
    /*
           1
        2    3
      4   5

    */
    static BinaryTreeNode<Integer> createTree() {
        BinaryTreeNode<Integer> tree = new BinaryTreeNode<>(1);
        tree.setLeft(new BinaryTreeNode<>(2));
        tree.setRight(new BinaryTreeNode<>(3));
        tree.getLeft().setLeft(new BinaryTreeNode<>(4));
        tree.getLeft().setRight(new BinaryTreeNode<>(5));
        return tree;
    }

    // not real tests, not worth mocking out system.out or making a predicate
    @Test
    public void printLevelOrder() {
        PrintUtils.printLevelOrder(createTree());
        // 1 2 3 4 5
    }

    @Test
    public void printInOrder() {
        PrintUtils.printInOrder(createTree());
        // 4 2 5 1 3
    }

    @Test
    public void printPreOrder() {
        PrintUtils.printPreOrder(createTree());
        // 1 2 4 5 3
    }

    @Test
    public void printPostOrder() {
        PrintUtils.printPostOrder(createTree());
        // 4 5 2 3 1
    }

    @Test
    public void prettyPrint() {
        PrintUtils.prettyPrint(createTree());
    }
}
