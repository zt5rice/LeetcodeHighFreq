import java.util.*;
public class TrapRainWater {
    public static void main(String[] args) {
        TrapRainWater sol = new TrapRainWater();
        int[][] mat = {{1,4,3,1,3,2},{3,2,1,3,2,4},{2,3,3,2,3,1}};
        //int[][] mat = {{2,2,2},{2,1,2},{2,1,2},{2,1,2}};
        int water = sol.trapRainWater(mat);
        System.out.println(water);
        System.out.println(Arrays.deepToString(mat));
    }
    public int trapRainWater(int[][] mat) {
        // sanitory clean
        int row = mat.length;
        int col = mat[0].length;
        if (row < 3 || col < 3) {
            return 0;
        } // all edge case
        int maxWater = 0;
        boolean[][] visited = new boolean[row][col];
        PriorityQueue<Node> minHeap = new PriorityQueue<>(new Comparator<Node>(){
            @Override
                public int compare(Node n1, Node n2) {
                if (n1.height == n2.height) {
                    return 0;
            }
            return n1.height < n2.height ? -1 : 1;
            }
        });
        // 1. process all Edges, 
        getEdge(mat, visited, minHeap);
    
        // 2. expand w neighbours
        while (!minHeap.isEmpty()) {
            Node cur = minHeap.poll();
            List<Node> curNei = getNei(cur, visited, row, col, mat);
            for (Node curN : curNei) {
                if (visited[curN.r][curN.c]) {
                    continue;
                }
                visited[curN.r][curN.c] = true;
                if (cur.height > curN.height) {
                    System.out.println(curN.r + "," + curN.c);
                }
                maxWater += Math.max(cur.height - curN.height, 0); 
                curN.height = Math.max(curN.height, cur.height);
                minHeap.offer(curN);
            }
        }
            return maxWater;
    }
    
    public static final int[][] DIR = {{-1, 0}, {1, 0}, {0, -1}, {0, 1}};
    
    private List<Node> getNei(Node minEdge, boolean[][] visited, int row, int col, int[][] mat) {
        List<Node> nei = new ArrayList<>();
        int curR = minEdge.r;
        int curC = minEdge.c;
        for (int i = 0; i < 4; i++) {
            int tmpR = curR + DIR[i][0];
            int tmpC = curC + DIR[i][1];
            if (tmpR >= 0 && tmpR < row) {
                nei.add(new Node(tmpR, curC, mat[tmpR][curC]));
            }
            if (tmpC >= 0 && tmpC < col) {
                nei.add(new Node(curR, tmpC, mat[curR][tmpC]));
            }
        }
        return nei;
    }
    private void getEdge(int[][] mat, boolean[][] visited, PriorityQueue<Node> minHeap) {
        int row = mat.length;
        int col = mat[0].length;
        for (int i = 0; i < row - 1; i++) { // left/right
            minHeap.offer(new Node(i, 0, mat[i][0]));
            visited[i][0] = true;
            minHeap.offer(new Node(i, col - 1, mat[i][col - 1]));
            visited[i][col - 1] = true;
        }
        for (int j = 0; j < col; j++) { // up/down
            minHeap.offer(new Node(0, j, mat[0][j]));
            visited[0][j] = true;
            minHeap.offer(new Node(row - 1, j,  mat[row - 1][j]));
            visited[row - 1][j] = true;
        }
        //return minHeap.poll();
    }
    
    
    static class Node{
        int r;
        int c;
        int height;
        Node (int r, int c, int height) {
            this.r = r;
            this.c = c;
             this.height = height;
        }
    }    
}
