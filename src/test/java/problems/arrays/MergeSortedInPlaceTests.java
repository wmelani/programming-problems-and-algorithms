package problems.arrays;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

public class MergeSortedInPlaceTests {

    @Test
    public void solution() {
        int[] nums1 = new int[]{1, 2, 3, 0, 0, 0};
        int m = 3;
        int[] nums2 = new int[]{2, 5, 6};
        int n = 3;
        int[] expected = new int[]{1, 2, 2, 3, 5, 6};

        MergeSortedInPlace.solution(nums1, m, nums2, n);
        assertArrayEquals(expected, nums1);
    }
}