import java.util.Arrays;

public class InvertTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) {
            return root;
        }
        TreeNode l = invertTree(root.left);
        TreeNode r = invertTree(root.right);
        TreeNode tmp = l;
        root.left = r;
        root.right = tmp;
        return root;
    }

    public static void main(String[] args) {
        ConstructTree construct = new ConstructTree();
        InvertTree sol = new InvertTree();
        Integer[] rootint, invrootint;
        TreeNode root, invroot;

        rootint = new Integer[]{4,2,7,1,3,6,9};
        root = construct.constructTree(rootint);
        invroot = sol.invertTree(root);
        invrootint = construct.destructTree(invroot);
        System.out.println("Input tree : " + Arrays.toString(rootint));
        System.out.println("Output tree: " + Arrays.toString(invrootint));

        rootint = new Integer[]{2,1,3};
        root = construct.constructTree(rootint);
        invroot = sol.invertTree(root);
        invrootint = construct.destructTree(invroot);
        System.out.println("Input tree : " + Arrays.toString(rootint));
        System.out.println("Output tree: " + Arrays.toString(invrootint));

        rootint = new Integer[]{};
        root = construct.constructTree(rootint);
        invroot = sol.invertTree(root);
        invrootint = construct.destructTree(invroot);
        System.out.println("Input tree : " + Arrays.toString(rootint));
        System.out.println("Output tree: " + Arrays.toString(invrootint));

    }
}
/*

https://leetcode.com/problems/invert-binary-tree/

*/
