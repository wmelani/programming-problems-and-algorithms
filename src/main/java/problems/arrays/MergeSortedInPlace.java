package problems.arrays;

/**
 * nums1 = [1,2,3,6,7,0,0,0], m = 5
 * nums2 = [2,5,6],       n = 3
 * <p>
 * nums1 = [1,2,3,6,0,0,6,7], m = 5, num1Idx = 3
 * nums2 = [2,5,6],       n = 3
 * <p>
 * nums1 = [1,2,3,0,0,6,6,7], m = 5, num1Idx = 2
 * nums2 = [2,5,0],       n = 3, numIdx = 2
 * <p>
 * nums1 = [1,2,3,0,5,6,6,7], m = 5, num1Idx = 2
 * nums2 = [2,0,0],       n = 3, numIdx = 1
 * <p>
 * nums1 = [1,2,3,0,5,6,6,7], m = 5, num1Idx = 2
 * nums2 = [2,0,0],       n = 3, numIdx = 1
 * <p>
 * nums1 = [1,2,0,3,5,6,6,7], m = 5, num1Idx = 1
 * nums2 = [2,0,0],       n = 3, numIdx = 1
 * <p>
 * nums1 = [1,0,2,3,5,6,6,7], m = 5, num1Idx = 0
 * nums2 = [2,0,0],       n = 3, numIdx = 1
 * <p>
 * from leetcode
 */
public class MergeSortedInPlace {

    public static void solution(int[] nums1, int m, int[] nums2, int n) {
        int num1Idx = m - 1;
        int num2Idx = n - 1;
        while (num1Idx >= 0 && num2Idx >= 0) {
            int mainArrayElement = nums1[num1Idx];
            int sideArrayElement = nums2[num2Idx];
            int currentPos = num2Idx + num1Idx + 1;

            if (sideArrayElement < mainArrayElement) {
                nums1[currentPos] = mainArrayElement;
                num1Idx--;
            } else if (sideArrayElement == mainArrayElement) {
                nums1[currentPos] = mainArrayElement;
                num1Idx--;
            } else {
                nums1[currentPos] = sideArrayElement;
                num2Idx--;
            }
        }
        while (num2Idx >= 0) {
            nums1[num2Idx] = nums2[num2Idx];
            num2Idx--;
        }
    }
}
