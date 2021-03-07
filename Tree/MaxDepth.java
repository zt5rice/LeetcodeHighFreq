import java.util.*;
import TreeNode;
import ConstructTree;

public class MaxDepth {
    public int maxDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int lh = maxDepth(root.left);
        int rh = maxDepth(root.right);
        return Math.max(lh, rh) + 1;
    }
    public static void main(String[] args) {
        MaxDepth sol = new MaxDepth();
        ConstructTree tree = new ConstructTree();
        Integer[] input = {3,9,20,null,null,15,7};
        System.out.println("Input  : " + Arrays.toString(input));
        TreeNode root = tree.constructTree(input);
        int depth = sol.maxDepth(root);
        System.out.println("Output  : " + depth);
    }
}
