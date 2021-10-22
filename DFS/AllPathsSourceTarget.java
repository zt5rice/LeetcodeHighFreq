import java.util.List;

public class AllPathsSourceTarget {
    private int target;
    private int[][] graph;
    private List<List<Integer>> results;

    protected void backtrack(int currNode, LinkedList<Integer> path) {
        if (currNode == this.target) {
            // Note: one should make a deep copy of the path
            this.results.add(new ArrayList<Integer>(path));
            return;
        }
        // explore the neighbor nodes one after another.
        for (int nextNode : this.graph[currNode]) {
            // mark the choice, before backtracking.
            path.addLast(nextNode);
            this.backtrack(nextNode, path);
            // remove the previous choice, to try the next choice
            path.removeLast();
        }
    }

    public List<List<Integer>> allPathsSourceTarget(int[][] graph) {

        this.target = graph.length - 1;
        this.graph = graph;
        this.results = new ArrayList<List<Integer>>();
        // adopt the LinkedList for fast access to the tail element.
        LinkedList<Integer> path = new LinkedList<Integer>();
        path.addLast(0);
        // kick of the backtracking, starting from the source (node 0)
        this.backtrack(0, path);
        return this.results;
    }    
}
/*abstract
Given a directed acyclic graph (DAG) of n nodes labeled from 0 to n - 1, find all possible paths from node 0 to node n - 1 and return them in any order.

The graph is given as follows: graph[i] is a list of all nodes you can visit from node i (i.e., there is a directed edge from node i to node graph[i][j]).

 

Example 1:


Input: graph = [[1,2],[3],[3],[]]
Output: [[0,1,3],[0,2,3]]
Explanation: There are two paths: 0 -> 1 -> 3 and 0 -> 2 -> 3.
Example 2:


Input: graph = [[4,3,1],[3,2,4],[3],[4],[]]
Output: [[0,4],[0,3,4],[0,1,3,4],[0,1,2,3,4],[0,1,4]]
Example 3:

Input: graph = [[1],[]]
Output: [[0,1]]
Example 4:

Input: graph = [[1,2,3],[2],[3],[]]
Output: [[0,1,2,3],[0,2,3],[0,3]]
Example 5:

Input: graph = [[1,3],[2],[3],[]]
Output: [[0,1,2,3],[0,3]]

*/