package problems.trees;

import trees.BinaryTreeHelper;
import trees.BinaryTreeNode;

import java.util.ArrayList;
import java.util.List;

class ListOfDepths {

    static List<List<Integer>> solutionN(BinaryTreeNode<Integer> root) {
        int depth = BinaryTreeHelper.heightOfTree(root);
        List<List<Integer>> levels = new ArrayList<>();
        for (int i = 0; i < depth; i++) {
            levels.add(new ArrayList<>());
        }
        insertNodes(root, levels, 0);
        return levels;
    }

    private static void insertNodes(BinaryTreeNode<Integer> root, List<List<Integer>> levels, int levelIdx) {
        if (root == null) {
            return;
        }
        levels.get(levelIdx).add(root.getValue());
        insertNodes(root.getLeft(), levels, levelIdx + 1);
        insertNodes(root.getRight(), levels, levelIdx + 1);
    }
}
