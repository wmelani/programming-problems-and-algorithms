package problems.arrays;

/**
 * Shifted Array Search
 * A sorted array of distinct integers shiftArr is shifted to the left by an unknown offset and
 * you don’t have a pre-shifted copy of it. For instance, the sequence 1, 2, 3, 4, 5 becomes 3, 4, 5, 1, 2,
 * after shifting it twice to the left.
 * <p>
 * Given shiftArr and an integer num, implement a function shiftedArrSearch that finds and returns the
 * index of num in shiftArr. If num isn’t in shiftArr, return -1. Assume that the offset doesn’t equal to 0
 * (i.e. assume the array is shifted at least once) or to arr.length - 1 (i.e. assume the shifted array isn’t
 * fully reversed).
 * <p>
 * Explain your solution and analyze its time and space complexities.
 * <p>
 * Example:
 * <p>
 * input:  shiftArr = [9, 12, 17, 2, 4, 5], num = 2 # shiftArr is the
 * # outcome of shifting
 * # [2, 4, 5, 9, 12, 17]
 * # three times to the left
 * <p>
 * output: 3 # since it’s the index of 2 in arr
 */
public class ShiftedSortedArray {
    public static int solution(int[] arr, int num) {
        int pivot = findPivot(arr);
        if (pivot == 0 || num < arr[0]) {
            return binarySearch(arr, num, pivot + 1, arr.length - 1);
        }
        return binarySearch(arr, num, 0, pivot);
    }

    public static int findPivot(int[] arr) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (mid == 0 || arr[mid] < arr[mid - 1]) {
                return mid;
            }
            if (arr[mid] > arr[0]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return 0;
    }

    private static int binarySearch(int[] arr, int num, int start, int end) {
        int mid = (start + end) / 2;
        if (start < 0 || end >= arr.length) {
            return -1;
        }
        if (arr[mid] > num) {
            return binarySearch(arr, num, mid + 1, end);
        }
        if (arr[mid] == num) {
            return mid;
        } else return binarySearch(arr, num, start, mid - 1);
    }
}
