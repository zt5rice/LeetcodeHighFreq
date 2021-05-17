import java.util.Arrays;

public class DiameterOfBinaryTree {
    public int diameterOfBinaryTree(TreeNode root) {
        int[] rst = {1};
        depth(root, rst);
        return rst[0] - 1;
    }
    public int depth(TreeNode node, int[] rst) {
        if (node == null) return 0;
        int L = depth(node.left, rst);
        int R = depth(node.right, rst);
        rst[0] = Math.max(rst[0], L+R+1);
        return Math.max(L, R) + 1;
    }

    public static void main(String[] args) {
        DiameterOfBinaryTree sol = new DiameterOfBinaryTree();
        ConstructTree construct = new ConstructTree();
        Integer[] rootint;
        TreeNode root;
        int res;

        rootint = new Integer[]{1,2,3,4,5};
        root = construct.constructTree(rootint);
        res = sol.diameterOfBinaryTree(root);
        System.out.println("Input tree : " + Arrays.toString(rootint));
        System.out.println("Output : " + res);
        
        rootint = new Integer[]{1,2};
        root = construct.constructTree(rootint);
        res = sol.diameterOfBinaryTree(root);
        System.out.println("Input tree : " + Arrays.toString(rootint));
        System.out.println("Output : " + res);
    }
}
/*abstract
https://leetcode.com/problems/diameter-of-binary-tree/
*/