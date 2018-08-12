package trees;

public class BinaryTreeHelper {

    public static int heightOfTree(BinaryTreeNode<?> root) {
        if (root == null) {
            return 0;
        }
        return heightOfTreeImpl(root);
    }

    private static int heightOfTreeImpl(BinaryTreeNode<?> root) {
        int heightLeft = 0;
        int heightRight = 0;

        if (root.hasLeft()) {
            heightLeft = heightOfTreeImpl(root.getLeft());
        }
        if (root.hasRight()) {
            heightRight = heightOfTreeImpl(root.getRight());
        }
        return Math.max(heightLeft, heightRight) + 1;
    }

}
