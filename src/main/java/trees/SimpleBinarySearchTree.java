package trees;

import trees.utils.PrintUtils;

import java.util.Iterator;
import java.util.Stack;

public class SimpleBinarySearchTree<T extends Comparable<T>> {

    private BinaryTreeNode<T> head;
    private int count = 0;
    private T reallyBig;
    private T reallySmall;

    public SimpleBinarySearchTree() {

    }

    public SimpleBinarySearchTree(T reallySmall, T reallyBig) {
        this();
        this.reallyBig = reallyBig;
        this.reallySmall = reallySmall;
    }

    private boolean isValid() {
        if (this.reallySmall == null || this.reallyBig == null) {
            // skip if we cannot evaluate.
            return true;
        }
        this.print();
        return this.isValidImpl(this.head, this.reallySmall, this.reallyBig);
    }

    private boolean isValidImpl(BinaryTreeNode<T> node, T minValue, T maxValue) {
        if (node == null) {
            return true;
        }
        if (node.getValue().compareTo(minValue) < 0 || node.getValue().compareTo(maxValue) > 0) {
            return false;
        }
        return isValidImpl(node.getLeft(), minValue, node.getValue()) &&
                isValidImpl(node.getRight(), node.getValue(), maxValue);

    }

    public boolean contains(T entry) {
        if (count == 0) {
            return false;
        }
        var current = this.head;
        while (current != null) {
            int compared = current.getValue().compareTo(entry);
            if (compared == 0) {
                return true;
            }
            if (compared > 0) {
                current = current.getLeft();
            } else {
                current = current.getRight();
            }
        }
        return false;
    }

    //          5
    //      4      6
    //    2
    public boolean add(T entry) {
        if (this.count == 0) {
            this.head = new BinaryTreeNode<>(entry);
            this.count = 1;
            assert (this.isValid());
            return true;
        }
        var current = this.head;
        while (true) {
            var comp = current.getValue().compareTo(entry);
            if (comp > 0) {
                if (current.hasLeft()) {
                    current = current.getLeft();
                    continue;
                }
                // add as left child
                current.setLeft(new BinaryTreeNode<>(entry, current));
                this.count++;
                assert (this.isValid());
                return true;
            } else {
                if (current.hasRight()) {
                    current = current.getRight();
                    continue;
                }
                current.setRight(new BinaryTreeNode<>(entry, current));
                this.count++;
                assert (this.isValid());
                return true;
            }
        }
    }

    /**
     * 10
     * / \
     * /   \
     * /     \
     * /       \
     * 8       22
     * /       /
     * /       /
     * 6       18
     * /
     * 11
     *
     * @param entry
     * @return
     */
    public boolean remove(T entry) {
        var current = this.head;
        // this class does have parent pointers, but using a more "algorithm" based solution
        BinaryTreeNode<T> parent = null;
        while (current != null) {
            var compared = current.getValue().compareTo(entry);
            if (compared == 0) {
                removeFromTreeImpl(parent, current);
                assert (this.isValid());
                return true;
            } else if (compared > 0) {
                parent = current;
                current = current.getLeft();
            } else {
                // go right
                parent = current;
                current = current.getRight();
            }
        }
        assert (this.isValid());
        return false;
    }

    private BinaryTreeNode<T> nextValueFromTreeNode(BinaryTreeNode<T> node) {
        var current = node;
        while (current.hasLeft()) {
            current = current.getLeft();
        }
        return current;
    }

    private void removeFromTreeImpl(BinaryTreeNode<T> parent, BinaryTreeNode<T> current) {
        if (count == 1) {
            // case where we only have a single node, and its the root.
            this.head = null;
            this.count = 0;
            return;
        }

        // has both left and right. get in order successor and then swap places.
        if (current.hasRight() && current.hasLeft()) {
            var newEntry = this.nextValueFromTreeNode(current.getRight());
            current.setValue(newEntry.getValue());
            removeFromTreeImpl(newEntry.getParent(), newEntry); // shortcut based on having parent pointer.
            // no need to update count since ^ will do it and we are just swapping nodes.
            return;
        }

        // leaf node, we can just delete.
        if (!current.hasRight() && !current.hasLeft()) {
            if (parent.getLeft() == current) {
                parent.setLeft(null);
            } else {
                parent.setRight(null);
            }
            this.count--;
            current.setParent(null);
            return;
        }

        // single left or right child, we can shift up.
        BinaryTreeNode<T> child;
        if (current.hasRight()) {
            child = current.getRight();
        } else {
            child = current.getLeft();
        }
        if (parent.getLeft() == current) {
            parent.setLeft(child);

        } else {
            parent.setRight(child);
        }
        child.setParent(parent);
        this.count--;

    }

    public int size() {
        return this.count;
    }

    public boolean isEmpty() {
        return this.count == 0;
    }

    public Iterable<T> getInOrderIterator() {
        return new InOrderIterator(this);
    }

    public void print() {
        PrintUtils.prettyPrint(this.head);
    }

    private class InOrderIterator implements Iterable<T> {

        private final SimpleBinarySearchTree<T> tree;
        private final Stack<BinaryTreeNode<T>> entries = new Stack<>();

        InOrderIterator(SimpleBinarySearchTree<T> tree) {
            this.tree = tree;
            this.buildStack();

        }

        //      5
        // 1        4
        //  2

        // [5,1]
        // 1, [5]
        // 1, [5] (+2)
        // 1, [5,2]
        // 1, 2, [5]
        // 1, 2, 5, [4]
        // 1, 2, 5, 4, []
        private void buildStack() {
            var current = tree.head;
            while (current != null) {
                this.entries.push(current);
                current = current.getLeft();
            }
        }

        @Override
        public Iterator<T> iterator() {
            return new Iterator<T>() {
                @Override
                public boolean hasNext() {
                    return !entries.isEmpty();
                }

                @Override
                public T next() {
                    var current = entries.pop();
                    var val = current.getValue();
                    if (current.hasRight()) {
                        current = current.getRight();
                        while (current != null) {
                            entries.push(current);
                            current = current.getLeft();
                        }
                    }
                    return val;
                }
            };
        }
    }
}
