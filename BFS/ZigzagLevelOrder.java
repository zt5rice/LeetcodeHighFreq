import java.util.*;
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
                    curLayer.add(tmp.val);
                    if (tmp.left != null) {
                        deque.offerLast(tmp.left);
                    }
                    if (tmp.right != null) {
                        deque.offerLast(tmp.right);
                    }
                } else {
                    TreeNode tmp = deque.pollLast();
                    curLayer.add(tmp.val);
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
}
