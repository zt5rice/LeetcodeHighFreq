public class CriticalConnections {
    List<List<Integer>> res = new ArrayList<>(); // 返回结果
    int[] deepArray; // 深度数组
    ArrayList<Integer>[] map; // 结构图

    public List<List<Integer>> criticalConnections(int n, List<List<Integer>> connections) {
        deepArray = new int[n]; // 初始化深度数组
        Arrays.fill(deepArray, -1); // 所有节点初始深度为-1
        map = new ArrayList[n]; // 初始化结构图map[i]代表节点i可以连通哪些节点
        for (int i = 0; i < n; i++) {
            map[i] = new ArrayList<>();
        }
        // 构建路径图
        for (List<Integer> connection : connections) {
            map[connection.get(0)].add(connection.get(1));
            map[connection.get(1)].add(connection.get(0));
        }
        dfs(0, 0, 0); // 开始dfs
        return res;
    }

    // current为当前节点
    // previous为前节点
    // deep为当前深度
    // 返回值为当前节点所有dfs路径终点的最小深度
    private int dfs(int current, int previous, int deep) {
        deepArray[current] = deep; // 将当前深度存入深度数组
        int result = Integer.MAX_VALUE; // 返回值
        for (int i : map[current]) { // 遍历当前节点能走的所有节点
            if (i == previous) { // 不能走回头路
                continue;
            }
            int endDeep; // dfs终点深度
            if (deepArray[i] == -1) { // 深度为-1的点没走过，可以dfs
                endDeep = dfs(i, current, deep + 1);
                // 如果深度大于当前深度，说明当前点不在闭环上
                // 当前点与下一节点i之间的连线为答案之一
                if (endDeep > deep) {
                    List<Integer> list = new ArrayList<>();
                    list.add(current);
                    list.add(i);
                    res.add(list);
                }
            } else {
                // i节点深度不为-1，说明已经走过，i节点为dfs终点
                endDeep = deepArray[i];
            }
            // 更新最小深度
            result = Math.min(result, endDeep);
        }
        return result; // 返回最小深度
    }
}
/*abstract

1192. Critical Connections in a Network
Hard

There are n servers numbered from 0 to n - 1 connected by undirected server-to-server connections forming a network where connections[i] = [ai, bi] represents a connection between servers ai and bi. Any server can reach other servers directly or indirectly through the network.

A critical connection is a connection that, if removed, will make some servers unable to reach some other server.

Return all critical connections in the network in any order.

 

Example 1:


Input: n = 4, connections = [[0,1],[1,2],[2,0],[1,3]]
Output: [[1,3]]
Explanation: [[3,1]] is also accepted.
Example 2:

Input: n = 2, connections = [[0,1]]
Output: [[0,1]]


*/