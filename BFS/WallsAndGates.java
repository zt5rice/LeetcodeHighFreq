import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.List;

public class WallsAndGates {
    private static final int EMPTY = Integer.MAX_VALUE;
    private static final int GATE = 0;
    private static final List<int[]> DIRECTIONS = Arrays.asList(new int[] { 1, 0 }, new int[] { -1, 0 },
            new int[] { 0, 1 }, new int[] { 0, -1 });

    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        if (m == 0)
            return;
        int n = rooms[0].length;
        Deque<int[]> q = new ArrayDeque<>();
        for (int row = 0; row < m; row++) {
            for (int col = 0; col < n; col++) {
                if (rooms[row][col] == GATE) {
                    q.offerFirst(new int[] { row, col });
                }
            }
        }
        while (!q.isEmpty()) {
            int[] point = q.pollLast();
            int row = point[0];
            int col = point[1];
            for (int[] direction : DIRECTIONS) {
                int r = row + direction[0];
                int c = col + direction[1];
                if (r < 0 || c < 0 || r >= m || c >= n || rooms[r][c] != EMPTY) {
                    continue;
                }
                rooms[r][c] = rooms[row][col] + 1;
                q.offerFirst(new int[] { r, c });
            }
        }
    }

    public static void main(String[] args) {
        WallsAndGates sol = new WallsAndGates();
        int[][] rooms, res;

        rooms = new int[][]{{2147483647,-1,0,2147483647},{2147483647,2147483647,2147483647,-1},{2147483647,-1,2147483647,-1},{0,-1,2147483647,2147483647}};
        System.out.println("Input  : " + Arrays.deepToString(rooms));
        sol.wallsAndGates(rooms);
        System.out.println("Output : " + Arrays.deepToString(rooms));
    }
}
