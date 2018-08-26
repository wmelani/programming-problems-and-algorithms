package trees;

class SampleTrees {

    static BinaryTreeNode<Integer> create3LevelTree() {
        BinaryTreeNode<Integer> tree = new BinaryTreeNode<>(1);
        tree.setLeft(new BinaryTreeNode<>(2));
        tree.setRight(new BinaryTreeNode<>(3));
        tree.getLeft().setLeft(new BinaryTreeNode<>(4));
        tree.getLeft().setRight(new BinaryTreeNode<>(5));
        return tree;
    }
}
