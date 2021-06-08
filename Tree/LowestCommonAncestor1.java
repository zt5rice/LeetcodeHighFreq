import java.util.Arrays;

public class LowestCommonAncestor1 {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        if(root == null || root == p || root == q)  return root;
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);
        if(left != null && right != null)   return root;
        return left != null ? left : right;
    }
    public static void main(String[] args) {
        LowestCommonAncestor1 sol = new LowestCommonAncestor1();
        ConstructTree tree = new ConstructTree();
        Integer[] rootint = new Integer[]{3,5,1,6,2,0,8,null,null,7,4};
        TreeNode root = tree.constructTree(rootint);
        TreeNode p = new TreeNode(5);
        TreeNode q = new TreeNode(1);
        TreeNode res = sol.lowestCommonAncestor(root, p, q);
        System.out.println("Input tree : " + Arrays.toString(rootint));
        System.out.println("p, q :" + p.key + " , " + q.key);
        if (res != null) {
            System.out.println("Output LCA : " + res);
        } else {
            System.out.println("Output LCA : null");
        }       
    }
}
/*abstract
To be improved: use search TreeNode find input node, then it will work.
abstract*/