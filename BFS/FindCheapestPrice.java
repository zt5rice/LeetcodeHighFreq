import java.util.*;

public class FindCheapestPrice {
    public static void main(String[] args) {
        FindCheapestPrice sol = new FindCheapestPrice();
        int[][] flights = {{0,1,100},{0,2,1000}, {1,2,200}};
        int src = 0;
        int dst = 2;
        int k = 1;
        System.out.println(sol.findCheapestPrice(3, flights, src, dst, k));
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        if (src == dst){
          return 0;
        }
        Queue<Cell> minHeap = new PriorityQueue<Cell>(new Comparator<Cell>(){
          @Override
          public int compare(Cell c1, Cell c2){
            if (c1.cost == c2.cost){
              return 0;
            }
            return c1.cost < c2.cost ? -1:1;
          }
        });
        boolean[][] visited = new boolean[n][n];
        int[][] price = new int[n][n];
        for (int[] row : flights){
          price[row[0]][row[1]] = row[2];
        }
      
        for (int j = 0; j <= n - 1; j++){
          if (price[src][j] == 0){
            continue;
          }
          minHeap.offer(new Cell(price[src][j], j, 0));
          visited[src][j] = true;
        }
      
        while(!minHeap.isEmpty()){
           //System.out.println(minHeap.toArray().toCellString()); 
           //System.out.println(Arrays.toString(minHeap.toArray().toString()));
           for (Cell c : minHeap) {
               System.out.print(c.toString());
           }
           System.out.println("");

           Cell temp = minHeap.poll();
           System.out.println(temp.toString());
           minHeap.clear();
          if (temp.city == dst){
            return temp.cost;
          }
          if (temp.numStop == k){
            continue;
          }
          for (int j = 0; j <= n - 1; j++){
            if (price[temp.city][j] == 0 || visited[temp.city][j]){
              continue;
            }
            minHeap.offer(new Cell(price[temp.city][j] + temp.cost, j, temp.numStop + 1));
            visited[temp.city][j] = true;
          }
        }
        return -1;
      }
      class Cell{
        int cost;
        int city;//arrival city
        int numStop;
        Cell(int cost, int city, int numStop){
          this.cost = cost;
          this.city = city;
          this.numStop = numStop;
        }
        @Override
        public String toString() {
          int[] output = {cost, city, numStop};
          return Arrays.toString(output);
        }
      }    
}
