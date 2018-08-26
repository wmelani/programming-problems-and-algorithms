package problems.arrays;


/* The isBadVersion API is defined in the parent class VersionControl.
      boolean isBadVersion(int version);

Given n = 5, and version = 4 is the first bad version.


n = 3, v =2

start = 1, end =3, mid = 2

badVersion = 2, end=2

start = 1, end = 2, mid = 1

*/
public class FindFirstBadVersion {


    public static int solution(int n, int badVersion) {


        if (n == 1) {
            return n;
        }
        int start = 1;
        int end = n;
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (isBadVersion(badVersion, mid)) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return start;
    }

    // this function is supposed to be a costly function to call and be  minimized
    private static boolean isBadVersion(int badVersion, int version) {
        return version >= badVersion;
    }
}
