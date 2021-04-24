//import GraphNode;
import java.util.*;

public class IsBipartiteLaiCode {

    public static void main(String[] args) {
        IsBipartiteLaiCode sol = new IsBipartiteLaiCode();
        List<GraphNode> graph = new ArrayList<GraphNode>();
        //Map<Integer, GraphNode> map = new HashMap<>();
        for (int i = 1; i <= 4; i++) {
            GraphNode tmp = new GraphNode(i);
            //map.put(i, tmp);
            graph.add(tmp);
        }
        // for (int j = 1; j < 4; j++) {
        //     GraphNode tmp1 = map.get(j);
        //     tmp1.neighbors.add(map.get(j+1));
        // }
        boolean rst = sol.isBipartite(graph);
        System.out.println(rst);
    }

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
}
// not working, but code works