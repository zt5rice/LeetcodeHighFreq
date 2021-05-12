import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

public class DailyTemperatures {
    public int[] dailyTemperatures(int[] T) {
        if (T == null || T.length == 0) {
            return T;
        }        
        int[] days = new int[T.length];
        Deque<Integer> stack = new ArrayDeque<>(); // store unexplored index of 
        for (int i = 0; i < T.length; i++) {
            if (stack.isEmpty() || T[i] <= T[stack.peekLast()]) { // insert condition
                stack.offerLast(i);
            } else {
                while (!stack.isEmpty() && T[i] > T[stack.peekLast()]) {
                    int tmp = stack.pollLast();
                    days[tmp] = i - tmp; 
                } 
                stack.offerLast(i);
            }            
        } // end of for
        return days;
    }
    
    public static void main(String[] args) {
        DailyTemperatures sol = new DailyTemperatures();
        int[] res, T;

        T = new int[]{73, 74, 75, 71, 69, 72, 76, 73};
        res = sol.dailyTemperatures(T);
        System.out.println("Temperature : " + Arrays.toString(T));
        System.out.println("Results     : " + Arrays.toString(res));
    }
}
/*abstract
739. Daily Temperatures
Medium

Given a list of daily temperatures temperatures, return a list such that, for each day in the input, tells you how many days you would have to wait until a warmer temperature. If there is no future day for which this is possible, put 0 instead.

For example, given the list of temperatures temperatures = [73, 74, 75, 71, 69, 72, 76, 73], your output should be [1, 1, 4, 2, 1, 1, 0, 0].

Note: The length of temperatures will be in the range [1, 30000]. Each temperature will be an integer in the range [30, 100].

*/