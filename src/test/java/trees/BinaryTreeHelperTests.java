package trees;

import org.junit.Test;

import static junit.framework.TestCase.assertEquals;

public class BinaryTreeHelperTests {

    @Test
    public void testHeightIfNullShouldBe0() {
        int actual = BinaryTreeHelper.heightOfTree(null);
        assertEquals(0, actual);
    }

    @Test
    public void testHeightShouldMatch() {
        int actual = BinaryTreeHelper.heightOfTree(SampleTrees.create3LevelTree());
        assertEquals(3, actual);
    }

    @Test
    public void testWorksIfNoDescendantNodes() {
        int actual = BinaryTreeHelper.heightOfTree(new BinaryTreeNode<>(3));
        assertEquals(1, actual);
    }
}
