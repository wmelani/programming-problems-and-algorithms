package trees;

import lombok.NonNull;
import lombok.val;

import java.util.LinkedList;

public class BinaryTreeFactory {

    public static <T extends Comparable<T>> BinaryTreeNode<T> from(@NonNull T[] inOrderArray) {
        if (inOrderArray.length == 0) {
            return null;
        }
        val root = new BinaryTreeNode<T>(inOrderArray[0]);
        val queue = new LinkedList<BinaryTreeNode<T>>();
        queue.add(root);
        int i = 1;

        return root;
    }
}
