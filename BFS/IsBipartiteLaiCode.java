//import GraphNode;
import java.util.*;

public class IsBipartiteLaiCode {

    public static void main(String[] args) {
        IsBipartiteLaiCode sol = new IsBipartiteLaiCode();
        List<GraphNode> graph = new ArrayList<GraphNode>();
        Map<Integer, GraphNode> map = new HashMap<>();
        for (int i = 1; i <= 2; i++) {
            GraphNode tmp = new GraphNode(i);
            map.put(i, tmp);
            graph.add(tmp);
        }
        map.get(1).neighbors = new ArrayList<GraphNode>();
        map.get(1).neighbors.add(map.get(2));
        map.get(2).neighbors = new ArrayList<GraphNode>();
        map.get(2).neighbors.add(map.get(1));
        // for (int j = 1; j < 4; j++) {
        //     GraphNode tmp1 = map.get(j);
        //     tmp1.neighbors.add(map.get(j+1));
        // }
        boolean rst = sol.isBipartite(graph);
        System.out.println(rst);
    }
    // public boolean isBipartite(List<GraphNode> graph) {
    //     HashMap<GraphNode, Integer> visited = new HashMap<GraphNode, Integer>();
    //     for (GraphNode node : graph) {
    //       if (!dfs(node, visited)) {
    //         return false;
    //       }
    //     }
    //     return true;
    // }

    public boolean isBipartite(List<GraphNode> graph) {
        if (graph == null) {
            return true;
        }
        Map<GraphNode, Integer> visited = new HashMap<>();
        for (GraphNode node : graph) {
            if (!bfs(node, visited)) {
                return false;
            }
        }
        return true;
    }

    
    // public boolean bfs(GraphNode node, Map<GraphNode, Integer> visited) { // this is right
    //     if (visited.containsKey(node)) {
    //         return true;
    //     }

    //     Queue<GraphNode> queue = new LinkedList<GraphNode>();
    //     queue.offer(node);    
    //     visited.put(node, 0);
    //     while (!queue.isEmpty()) {
    //         GraphNode cur = queue.poll();
    //         int curval = visited.get(cur); // color of polled node
    //         int neival = curval == 0 ? 1 : 0; // color of node's neighbour
    //         for (GraphNode neinode : cur.neighbors) {
    //         if (!visited.containsKey(neinode)) {
    //             visited.put(neinode, neival);
    //             queue.offer(neinode);
    //         } else if (visited.get(neinode) != neival) {
    //             return false;
    //         }
    //         }
    //     }
    //     return true;
    // }   

    private boolean bfs(GraphNode node, Map<GraphNode, Integer> visited) {
        if (visited.containsKey(node)) {
            return true;
        }
        Deque<GraphNode> queue = new ArrayDeque<>();
        queue.offerLast(node);
        visited.put(node, 0);
        while (!queue.isEmpty()) {
            GraphNode tmp = queue.pollFirst();
            int neiColor = visited.get(tmp) == 0 ? 1 : 0;
            for (GraphNode nei : tmp.neighbors) { // ! tmp's nei, not node's nei
                if (!visited.containsKey(nei)) {
                    visited.put(nei, neiColor);
                    queue.offerLast(nei);
                } else if (visited.get(nei) != neiColor) {
                    return false;
                }
            }
        }
        return true;
    }
 
}
// not working, but code works
/*abstract
 @ Parameter: list<GraphNode> graph
 @ Output: boolean
 Assumption:
 Method: dfs
 ds: hashmap<graphnode, color> - visited 
 1. scan every graph node, bfs(node, visited);
    any node has conflict -> return false;
    after loop -> return true;

 2. bfs for each node
    ds: queue<graphnode>
    a. if (visited.containsKey(node)) -> return true;
    b. init - put graphnode to graph, visited.put(graphnode, 0), cl 
       generation - graphnode.poll()
       generation - go through all nei, if not visited, dye with cl, else if not same color with cl, return false;

TC: O(V + E);
SC: O(V) ???

   public boolean isBipartite(List<GraphNode> graph) {
        HashMap<GraphNode, Integer> visited = new HashMap<GraphNode, Integer>();
        for (GraphNode node : graph) {
          if (!dfs(node, visited)) {
            return false;
          }
        }
        return true;
    }

    public boolean dfs(GraphNode node, HashMap<GraphNode, Integer> visited) {
        if (visited.containsKey(node)) {
            return true;
        }

        Queue<GraphNode> queue = new LinkedList<GraphNode>();
        queue.offer(node);    
        visited.put(node, 0);
        while (!queue.isEmpty()) {
            GraphNode cur = queue.poll();
            int curval = visited.get(cur); // color of polled node
            int neival = curval == 0 ? 1 : 0; // color of node's neighbour
            for (GraphNode neinode : cur.neighbors) {
            if (!visited.containsKey(neinode)) {
                visited.put(neinode, neival);
                queue.offer(neinode);
            } else if (visited.get(neinode) != neival) {
                return false;
            }
            }
        }
        return true;
    }   
 */