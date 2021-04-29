import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class MinJumps4 {
    public int minJumps(int[] arr) {
        int n = arr.length;
        HashMap<Integer, List<Integer>> indicesOfValue = new HashMap<>();
        for (int i = 0; i < n; i++)
            indicesOfValue.computeIfAbsent(arr[i], x -> new LinkedList<>()).add(i);
        boolean[] visited = new boolean[n]; visited[0] = true;
        Queue<Integer> q = new LinkedList<>(); q.offer(0);
        int step = 0;
        while (!q.isEmpty()) {
            for (int size = q.size(); size > 0; --size) {
                int i = q.poll();
                if (i == n - 1) return step; // Reached to last index
                List<Integer> next = indicesOfValue.get(arr[i]);
                next.add(i - 1); next.add(i + 1);
                for (int j : next) {
                    if (j >= 0 && j < n && !visited[j]) {
                        visited[j] = true;
                        q.offer(j);
                    }
                }
                next.clear(); // avoid later lookup indicesOfValue arr[i]
            }
            step++;
        }
        return 0;
    }
    public static void main(String[] args) {
        MinJumps4 sol = new MinJumps4();
        int[] arr;
        int res;

        arr = new int[]{100,-23,-23,404,100,23,23,23,3,404};
        res = sol.minJumps(arr);
        System.out.println("Input  : " + Arrays.toString(arr));
        System.out.println("Output : " + res);

        arr = new int[]{7};
        res = sol.minJumps(arr);
        System.out.println("Input  : " + Arrays.toString(arr));
        System.out.println("Output : " + res);

        arr = new int[]{7,6,9,6,9,6,9,7};
        res = sol.minJumps(arr);
        System.out.println("Input  : " + Arrays.toString(arr));
        System.out.println("Output : " + res);

        arr = new int[]{6,1,9};
        res = sol.minJumps(arr);
        System.out.println("Input  : " + Arrays.toString(arr));
        System.out.println("Output : " + res);

        arr = new int[]{11,22,7,7,7,7,7,7,7,22,13};
        res = sol.minJumps(arr);
        System.out.println("Input  : " + Arrays.toString(arr));
        System.out.println("Output : " + res);
    } 
}
