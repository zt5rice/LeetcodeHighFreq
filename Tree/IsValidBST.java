import java.util.Arrays;

public class IsValidBST {
    public boolean isValidBST(TreeNode root) {
        if (root == null || (root.left == null && root.right == null)) {
            return true;
        }
        
        return isBST(root, null, null);
    }
    private boolean isBST(TreeNode root, Integer min, Integer max) {
        if (root == null) {
            return true;
        }
        if ((min != null && root.key <= min) || (max != null && root.key >= max)) {
            return false;
        }
        return isBST(root.left, min, root.key)
            && isBST(root.right, root.key, max);
    }
    public static void main(String[] args) {
        IsValidBST sol = new IsValidBST();
        Integer[] rootInt;
        Boolean res;
        TreeNode root;
        ConstructTree construct = new ConstructTree();

        rootInt = new Integer[]{5,1,4,null,null,3,6};
        root = construct.constructTree(rootInt);
        res = sol.isValidBST(root);
        System.out.println("Input  : " + Arrays.toString(rootInt));
        System.out.println("Output : " + res);
    }
}
/*abstract
https://leetcode.com/problems/validate-binary-search-tree/
*/