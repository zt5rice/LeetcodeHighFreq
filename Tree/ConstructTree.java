import java.util.*;
import TreeNode;

public class ConstructTree {
    /*public static void main(String[] args) {
        ConstructTree sol = new ConstructTree();
        Integer[] input = {5, 3, 8, 1, 4, null, 11};
        TreeNode root = sol.constructTree(input);
        Integer[] res = sol.destructTree(root);
        System.out.println(Arrays.toString(res));

        Integer[] input2 = {null};
        TreeNode root2 = sol.constructTree(input2);
        Integer[] res2 = sol.destructTree(root2);
        System.out.println(Arrays.toString(res2));
    }*/
    public TreeNode constructTree(Integer[] array) { // reverse level order
        if (array == null || array.length == 0) {
            return new TreeNode(null);
        }
        TreeNode root = new TreeNode(array[0]);
        TreeNode cur = root;
        Deque<TreeNode> queue = new ArrayDeque<>();
        queue.offer(cur);
        for (int i = 1; i < array.length; i++) {
            TreeNode processing = queue.poll();
            if (array[i] != null) {
                if (processing.left == null) {
                    TreeNode left = new TreeNode(array[i++]);
                    processing.left = left;
                    queue.offer(left);
                }
            } else {
                i++;
            }
            if (i < array.length && array[i] != null) {
                if (processing.right == null) {
                    TreeNode right = new TreeNode(array[i]);
                    processing.right = right;
                    queue.offer(right);
                }
            }
        }
        return root;
    }
    public Integer[] destructTree(TreeNode root) {
        if (root == null || root.key == null) {
            Integer[] rst = new Integer[1];
            rst[0] = null;
            return rst;
        }
        List<Integer> rst = new ArrayList<>();
        Queue<TreeNode> queue = new ArrayDeque<>();
        //StringBuilder sb = new StringBuilder();
        int count = 1; // count of non-null nodes #
        queue.offer(root);

        while (!queue.isEmpty() && count > 0) {
            TreeNode tmp = queue.poll();
            if (tmp.key != Integer.MAX_VALUE) {
                count--;
            }
            if (tmp.left != null) {
                queue.offer(tmp.left);
                count++;
            } else {
                queue.offer(new TreeNode(Integer.MAX_VALUE));
            }

            if (tmp.right != null) {
                queue.offer(tmp.right);
                count++;
            } else {
                queue.offer(new TreeNode(Integer.MAX_VALUE));
            }

            if (tmp.key != Integer.MAX_VALUE) {
                rst.add(tmp.key);
            } else {
                rst.add(null);
            }
        }
        return rst.toArray(new Integer[rst.size()]); 
    }
}
