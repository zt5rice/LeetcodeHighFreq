import java.util.*;
public class OpenLock {
    public int openLock0(String[] deadends, String target) { // one end
        Set<String> deads = new HashSet<String>(Arrays.asList(deadends));
        Deque<String> queue = new ArrayDeque<>();
        int steps = 0;
        Set<String> visited = new HashSet<>();
        // 1. init
        visited.add("0000");
        queue.offerLast("0000");
        while(!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String tmp = queue.pollFirst();
                if (deads.contains(tmp)) {
                    size--;
                    continue;
                }
                if (tmp.equals(target)) {
                    return steps;
                }
                char[] arr = tmp.toCharArray();
                for (int i = 0; i < 4; i++) {
                    char orig = arr[i];
                    arr[i] = (arr[i] == '9') ? (char) '0' : (char) (arr[i] + 1); // +1
                    String opt1 = new String(arr);
                    if (!visited.contains(opt1) && !deads.contains(opt1)) {
                        queue.offerLast(opt1);
                        visited.add(opt1);
                    }
                    arr[i] = orig;
                    arr[i] = (arr[i] == '0') ? (char) '9' : (char) (arr[i] - 1); // -1
                    String opt2 = new String(arr);
                    if (!visited.contains(opt2) && !deads.contains(opt2)) {
                        queue.offerLast(opt2);
                        visited.add(opt2);
                    }  
                    arr[i] = orig;
                }
                size--;
            }
            steps++;
        }
        return -1;
    }    
    
    public static void main(String[] args) {
        OpenLock sol = new OpenLock();
        String[] deadends;
        String target;
        int steps;

        deadends = new String[]{"0201","0101","0102","1212","2002"};
        target = "0202";
        steps = sol.openLock0(deadends, target);
        System.out.println("Input : " + Arrays.deepToString(deadends));
        System.out.println("Target: " + target);
        System.out.println("Steps : " + steps);
    }
}
