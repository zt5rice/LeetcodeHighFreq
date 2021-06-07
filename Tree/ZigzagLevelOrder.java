import java.util.ArrayList;
import java.util.Arrays;
import java.util.Deque;
import java.util.LinkedList;
import java.util.List;

public class ZigzagLevelOrder {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if (root == null) {
            return res;
        }
        // bfs
        Deque<TreeNode> deque = new LinkedList<>();
        deque.offerLast(root);
        int layer = 0;
        while (!deque.isEmpty()) {
            List<Integer> curLayer = new ArrayList<>();
            int sz = deque.size();
            while (sz > 0) {      
                if (layer == 0) {                
                    TreeNode tmp = deque.pollFirst();
                    curLayer.add(tmp.key);
                    if (tmp.left != null) {
                        deque.offerLast(tmp.left);
                    }
                    if (tmp.right != null) {
                        deque.offerLast(tmp.right);
                    }
                } else {
                    TreeNode tmp = deque.pollLast();
                    curLayer.add(tmp.key);
                    if (tmp.right != null) {
                        deque.offerFirst(tmp.right);
                    }
                    if (tmp.left != null) {
                        deque.offerFirst(tmp.left);
                    }
                }
                sz--;
            }
            res.add(new ArrayList(curLayer));
            layer = 1 - layer;
        }
        return res;
    }    

    public static void main(String[] args) {
        ZigzagLevelOrder sol = new ZigzagLevelOrder();
        ConstructTree construct = new ConstructTree();
        Integer[] treeInt;
        List<List<Integer>> res;
        TreeNode root;

        treeInt = new Integer[]{3,9,20,null,null,15,7};
        root = construct.constructTree(treeInt);
        res = sol.zigzagLevelOrder(root);
        System.out.println("Input  : " + Arrays.toString(treeInt));
        System.out.println("Output : " + Arrays.deepToString(res.toArray()));
    }
}
