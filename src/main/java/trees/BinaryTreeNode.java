package trees;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@NoArgsConstructor
public class BinaryTreeNode<T extends Comparable<T>> implements Comparable<BinaryTreeNode<T>> {
    private T value;
    private BinaryTreeNode<T> left;
    private BinaryTreeNode<T> right;
    @Setter
    private BinaryTreeNode<T> parent;

    public BinaryTreeNode(T value) {
        this.value = value;
    }

    public boolean hasLeft() {
        return left != null;
    }

    public boolean hasRight() {
        return right != null;
    }

    public boolean hasParent() {
        return parent != null;
    }

    public boolean isLeaf() {
        return !this.hasLeft() && !this.hasRight() && this.hasParent();
    }

    public void setLeft(BinaryTreeNode<T> left) {
        if (this.left == left) {
            return;
        }
        this.left = left;
        this.left.setParent(this);
    }

    public void setRight(BinaryTreeNode<T> right) {
        if (this.right == right) {
            return;
        }
        this.right = right;
        this.right.setParent(this);
    }

    @Override
    public int compareTo(BinaryTreeNode<T> o) {
        if (o == null) {
            return -1;
        }
        return this.getValue().compareTo(o.getValue());
    }
}
