import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class SpiralOrder {
    public List<Integer> spiralOrder(int[][] matrix) {
        List ans = new ArrayList();
        if (matrix.length == 0)
            return ans;
        int r1 = 0, r2 = matrix.length - 1;
        int c1 = 0, c2 = matrix[0].length - 1;
        while (r1 <= r2 && c1 <= c2) {
            for (int c = c1; c <= c2; c++) ans.add(matrix[r1][c]);
            for (int r = r1 + 1; r <= r2; r++) ans.add(matrix[r][c2]);
            if (r1 < r2 && c1 < c2) {
                for (int c = c2 - 1; c > c1; c--) ans.add(matrix[r2][c]);
                for (int r = r2; r > r1; r--) ans.add(matrix[r][c1]);
            }
            r1++;
            r2--;
            c1++;
            c2--;
        }
        return ans;
    }
    
    public static void main(String[] args) {
        SpiralOrder sol = new SpiralOrder();
        int[][] matrix;
        List<Integer> res;

        matrix = new int[][]{{1,2,3,4},{5,6,7,8},{9,10,11,12}};
        res = sol.spiralOrder(matrix);
        System.out.println("Input  : " + Arrays.deepToString(matrix));
        System.out.println("Output : " + Arrays.toString(res.toArray()));
    }
}
