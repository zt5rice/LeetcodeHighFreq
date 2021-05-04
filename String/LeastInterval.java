import java.util.Arrays;

public class LeastInterval {
    public int leastInterval(char[] tasks, int n) {
        int[] c = new int[26];
        for(char t : tasks){
            c[t - 'A']++;
        }
        Arrays.sort(c);
        int i = 25;
        while(i >= 0 && c[i] == c[25]) i--;

        return Math.max(tasks.length, (c[25] - 1) * (n + 1) + 25 - i);
    }
    
    public static void main(String[] args) {
        LeastInterval sol = new LeastInterval();
        int[] tasks;
        int n, res;

        tasks = new int[]{'A','A','A','B','B','B'};
        n = 2;
        res = sol.leastInterval(tasks, n);
        System.out.println("Input   : " + Arrays.toString(tasks));
        System.out.println("Input n : " + n);
        System.out.println("Output  : " + res);
    }
}
