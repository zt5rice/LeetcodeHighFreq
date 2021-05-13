import java.util.Arrays;

public class CanCompleteCircuit {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
    
        int total_tank = 0;
        int curr_tank = 0;
        int starting_station = 0;
        for (int i = 0; i < n; ++i) {
          total_tank += gas[i] - cost[i];
          curr_tank += gas[i] - cost[i];
          // If one couldn't get here,
          if (curr_tank < 0) {
            // Pick up the next station as the starting one.
            starting_station = i + 1;
            // Start with an empty tank.
            curr_tank = 0;
          }
        }
        return total_tank >= 0 ? starting_station : -1;
      }
      
      public static void main(String[] args) {
          CanCompleteCircuit sol = new CanCompleteCircuit();
          int[] gas, cost;
          int res;

          gas = new int[]{1,2,3,4,5};
          cost = new int[]{3,4,5,1,2};
          res = sol.canCompleteCircuit(gas, cost);
          System.out.println("Gas : " + Arrays.toString(gas));
          System.out.println("Gas : " + Arrays.toString(cost));
          System.out.println("Stop: " + res);
      }
}
