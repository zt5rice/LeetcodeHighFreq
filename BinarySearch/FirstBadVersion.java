import java.util.Arrays;

public class FirstBadVersion {
    public int[] version;

    public int firstBadVersion(int n) {
        version = new int[n];
        int first = (int) (Math.random() * n);
        Arrays.fill(version, first, n, -1);
        System.out.println("version : " + Arrays.toString(version));
        int left = 1;
        int right = n;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (isBadVersion(mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private boolean isBadVersion(int test) {
        return version[test] == -1;
    }

    public static void main(String[] args) {
        FirstBadVersion sol = new FirstBadVersion();
        int n, res;

        n = 10;
        res = sol.firstBadVersion(n);
        System.out.println("Output  : " + res);
    }
}
/*abstract
https://leetcode.com/problems/first-bad-version/submissions/

*/