package datastructures;

import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class DynamicListTests {
    @Test
    public void canBeCreatedDefaultCtor() {
        var list = new DynamicList<Boolean>();
        assertEquals(0, list.size());
    }

    @Test
    public void canBeCreatedExistingArrayCtor() {
        var list = new DynamicList<>(new Boolean[]{true});
        assertEquals(1, list.size());
    }

    @Test
    public void canAddTo() {
        var list = new DynamicList<Boolean>();
        list.add(true);
        assertEquals(1, list.size());
    }

    @Test
    public void canBeResizedOnAdd() {
        var arr = new Boolean[DynamicList.DEFAULT_SIZE];
        Arrays.fill(arr, true);

        var list = new DynamicList<Boolean>(arr);
        list.add(true);
        assertEquals(1, list.getResizeCount());
        assertEquals(1 + DynamicList.DEFAULT_SIZE, list.size());
    }

    @Test
    public void canRemoveFromViaIndex() {
        var list = new DynamicList<Boolean>();
        list.add(true);
        list.add(false);
        list.add(false);
        assertTrue(list.remove(0));
        assertEquals(2, list.size());
    }

    @Test
    public void canRemoveFromViaValue() {
        var list = new DynamicList<Boolean>();
        list.add(true);
        list.add(false);
        list.add(false);
        assertTrue(list.remove(true));
        assertEquals(2, list.size());
    }

    @Test
    public void canRemoveLastFromViaValue() {
        var list = new DynamicList<>();
        var one = new Object();
        var two = new Object();
        var three = new Object();
        list.add(one);
        list.add(two);
        list.add(three);
        list.add(two);
        assertEquals(3, list.lastIndexOf(two));
    }
}
