import java.util.Arrays;

public class FindCelebrity {
    private int numberOfPeople;
    public int[][] graph;

    public int findCelebrity(int n) {
        numberOfPeople = n;
        int celebrityCandidate = 0;
        for (int i = 0; i < n; i++) {
            if (knows(celebrityCandidate, i)) {
                celebrityCandidate = i;
            }
        }
        if (isCelebrity(celebrityCandidate)) {
            return celebrityCandidate;
        }
        return -1;
    }
    
    private boolean knows(int celebrityCandidate, int i) {
        return (graph[celebrityCandidate][i] == 1);
    }

    private boolean isCelebrity(int i) {
        for (int j = 0; j < numberOfPeople; j++) {
            if (i == j) continue; // Don't ask if they know themselves.
            if (knows(i, j) || !knows(j, i)) {
                return false;
            }
        }
        return true;
    }   

    public static void main(String[] args) {
        FindCelebrity sol = new FindCelebrity();
        int n, res;

        sol.graph = new int[][]{{1,1,0},{0,1,0},{1,1,1}};
        n = sol.graph.length;
        res = sol.findCelebrity(n);
        System.out.println("Input Graph : " + Arrays.deepToString(sol.graph));
        System.out.println("Celebrity   : " + res);

        sol.graph = new int[][]{{1,0,1},{1,1,0},{0,1,1}};
        n = sol.graph.length;
        res = sol.findCelebrity(n);
        System.out.println("Input Graph : " + Arrays.deepToString(sol.graph));
        System.out.println("Celebrity   : " + res);
    }
}
