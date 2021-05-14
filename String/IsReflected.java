import java.util.Arrays;
import java.util.HashSet;

public class IsReflected {
    public boolean isReflected(int[][] points) {
        int max, min, sum;
        HashSet<Point> set = new HashSet<>();
        if(points.length == 0) return true;
        max = points[0][0]; min = max;
        for(int[] point: points) {
            int x = point[0];
            if(x > max) max = x;
            if(x < min) min = x;
            set.add(new Point(point[0], point[1]));
        }
        sum = (max + min);
        for(int[] point: points) {
            Point ref = new Point(sum - point[0], point[1]);
            if(set.contains(ref)) set.remove(ref);
        }
        return set.isEmpty();
        
    }
    private class Point {
        int x;
        int y;
        Point(int xx, int yy) {x = xx; y = yy;}
        @Override
        public boolean equals(Object obj){
            Point p = (Point) obj;
            return (this.x == p.x && this.y == p.y);
        }
        @Override
        public int hashCode(){
            return x * 31 + y * 17;
        }
    }    

    public static void main(String[] args) {
        IsReflected sol = new IsReflected();
        int[][] points;
        boolean res;

        points = new int[][]{{1,1},{-1,1}};
        res = sol.isReflected(points);
        System.out.println("Input  : " + Arrays.deepToString(points));
        System.out.println("Output  : " + res);

        points = new int[][]{{1,1},{-1,-1}};
        res = sol.isReflected(points);
        System.out.println("Input  : " + Arrays.deepToString(points));
        System.out.println("Output  : " + res);
    }
}
/*abstract

https://leetcode.com/problems/line-reflection/
*/