package trees.utils;

import lombok.val;
import trees.BinaryTreeHelper;
import trees.BinaryTreeNode;

import java.util.LinkedList;

public class PrintUtils {

    public static <T extends Comparable<T>> void printLevelOrder(BinaryTreeNode<T> node) {
        if (node == null) {
            System.out.println("Level Order: node was null");
            return;
        }
        System.out.print("Level Order: ");

        val queue = new LinkedList<BinaryTreeNode<T>>();
        queue.add(node);
        while (!queue.isEmpty()) {
            val current = queue.poll();
            System.out.format(" %s ", current.getValue());
            if (current.hasLeft()) {
                queue.add(current.getLeft());
            }
            if (current.hasRight()) {
                queue.add(current.getRight());
            }
        }
        System.out.println();
    }

    public static <T extends Comparable<T>> void printInOrder(BinaryTreeNode<T> node) {
        if (node == null) {
            System.out.println("InOrder: node was null");
            return;
        }
        System.out.print("InOrder: ");
        printInOrderImpl(node);
    }

    private static <T extends Comparable<T>> void printInOrderImpl(BinaryTreeNode<T> node) {
        if (node.hasLeft()) {
            printInOrderImpl(node.getLeft());
        }
        System.out.format(" %s ", node.getValue());
        if (node.hasRight()) {
            printInOrderImpl(node.getRight());
        }
    }

    public static <T extends Comparable<T>> void printPreOrder(BinaryTreeNode<T> node) {
        if (node == null) {
            System.out.println("PreOrder: node was null");
            return;
        }
        System.out.print("PreOrder: ");
        printPreOrderImpl(node);
        System.out.println();
    }

    private static <T extends Comparable<T>> void printPreOrderImpl(BinaryTreeNode<T> node) {
        System.out.format(" %s ", node.getValue());
        if (node.hasLeft()) {
            printPreOrderImpl(node.getLeft());
        }
        if (node.hasRight()) {
            printPreOrderImpl(node.getRight());
        }

    }

    public static <T extends Comparable<T>> void printPostOrder(BinaryTreeNode<T> node) {
        if (node == null) {
            System.out.println("PostOrder: node was null");
            return;
        }
        System.out.print("PostOrder: ");
        printPostOrderImpl(node);
        System.out.println();
    }

    private static <T extends Comparable<T>> void printPostOrderImpl(BinaryTreeNode<T> node) {
        if (node.hasLeft()) {
            printPostOrderImpl(node.getLeft());
        }
        if (node.hasRight()) {
            printPostOrderImpl(node.getRight());
        }
        System.out.format(" %s ", node.getValue());

    }

    public static <T extends Comparable<T>> void prettyPrint(BinaryTreeNode<T> node) {
        BTreePrinter.printNode(node);
    }

    public static <T extends Comparable<T>> void printLevels(BinaryTreeNode<T> node) {
        int levels = BinaryTreeHelper.heightOfTree(node);
        for (int i = 0; i < levels; i++) {
            printLevelImpl(node, i, 0);
            System.out.println();
        }
    }

    private static <T extends Comparable<T>> void printLevelImpl(BinaryTreeNode<T> node, int desiredLevel, int level) {
        if (node == null) {
            return;
        }
        if (desiredLevel == level) {
            System.out.format(" %s ", node.getValue());
            return;
        }
        if (node.hasLeft() && desiredLevel > level) {
            printLevelImpl(node.getLeft(), desiredLevel, level + 1);
        }
        if (node.hasRight() && desiredLevel > level) {
            printLevelImpl(node.getRight(), desiredLevel, level + 1);
        }
    }
}
