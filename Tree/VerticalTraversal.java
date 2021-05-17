import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.TreeMap;

public class VerticalTraversal {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        dfs(root, 0, 0, map);
        List<List<Integer>> list = new ArrayList<>();
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            list.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    list.get(list.size() - 1).add(nodes.poll());
                }
            }
        }
        return list;
    }
    private void dfs(TreeNode root, int x, int y, TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map) {
        if (root == null) {
            return;
        }
        if (!map.containsKey(x)) {
            map.put(x, new TreeMap<>());
        }
        if (!map.get(x).containsKey(y)) {
            map.get(x).put(y, new PriorityQueue<>());
        }
        map.get(x).get(y).offer(root.key);
        dfs(root.left, x - 1, y + 1, map);
        dfs(root.right, x + 1, y + 1, map);
    }
    public static void main(String[] args) {
        VerticalTraversal sol = new VerticalTraversal();
        ConstructTree construct = new ConstructTree();
        Integer[] treeInt;
        List<List<Integer>> res;
        TreeNode root;

        treeInt = new Integer[]{3,9,20,null,null,15,7};
        root = construct.constructTree(treeInt);
        res = sol.verticalTraversal(root);
        System.out.println("Input  : " + Arrays.toString(treeInt));
        System.out.println("Output : " + Arrays.deepToString(res.toArray()));
    }
}
/*
https://leetcode.com/problems/vertical-order-traversal-of-a-binary-tree/
*/
