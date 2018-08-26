package problems.strings;

/**
 * CTCI 1-5 There are three types of edits that can be performed on a string, insert, remove, or replace. Given
 * Two strings, write a function to check if they are 1 or less edits away
 * <p>
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bake -> false
 * pale, eale -> true
 */
public class OneAway {

    public static boolean solution(String one, String two) {
        if (Math.abs(one.length() - two.length()) > 1) {
            return false;
        }
        int changes = 0;
        int onePtr = 0;
        int twoPtr = 0;
        while (onePtr < one.length() && twoPtr < two.length()) {
            char currOne = one.charAt(onePtr);
            char currTwo = two.charAt(twoPtr);
            if (currOne != currTwo) {
                changes++;
                if (one.length() > two.length()) {
                    onePtr++;
                } else if (onePtr != twoPtr) {
                    twoPtr++;
                }
            }
            if (changes > 1) {
                return false;
            }
            onePtr++;
            twoPtr++;
        }
        if (onePtr != one.length() || twoPtr != two.length()) {
            return changes == 0;
        }
        return true;
    }
}
