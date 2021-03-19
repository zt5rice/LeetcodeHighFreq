import jdk.incubator.jpackage.main.Main;

import java.util.*;
public class NumPairsDivisibleBy60 {
    public static void main(String[] args) {
        NumPairsDivisibleBy60 sol = new NumPairsDivisibleBy60();
        int[] arr = {30,20,150,100,40};
        System.out.print(sol.numPairsDivisibleBy60(arr));
    }
    public int numPairsDivisibleBy60(int[] time) {
        int[] remain = new int[60];
        int count = 0;
        for (int i = 0; i < time.length; i++) {   
            if (time[i] % 60 != 0) {
                count += remain[60 - time[i] % 60]; 
            } else {
                count += remain[0];
            }
            remain[time[i] % 60]++;
        }
        return count;
    }    
}
