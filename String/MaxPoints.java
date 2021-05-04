import java.util.Arrays;

public class MaxPoints {
    public int maxPoints(int[][] points) {
        int res = 0, n = points.length;
        for (int i = 0; i < n; ++i) {
            int duplicate = 1;
            for (int j = i + 1; j < n; ++j) {
                int cnt = 0;
                long x1 = points[i][0], y1 = points[i][1];
                long x2 = points[j][0], y2 = points[j][1];
                if (x1 == x2 && y1 == y2) {++duplicate;continue;}
                for (int k = 0; k < n; ++k) {
                    int x3 = points[k][0], y3 = points[k][1];
                    if (x1*y2 + x2*y3 + x3*y1 - x3*y2 - x2*y1 - x1 * y3 == 0) {
                        ++cnt;
                    }
                }
                res = Math.max(res, cnt);
            }
            res = Math.max(res, duplicate);
        }
        return res;
    }    

    public static void main(String[] args) {
        MaxPoints sol = new MaxPoints();
        int[][] points;
        int res;

        points = new int[][]{{1,1},{2,2},{3,3}};
        res = sol.maxPoints(points);
        System.out.println("Input  : " + Arrays.deepToString(points));
        System.out.println("Output : " + res);
    }
}
