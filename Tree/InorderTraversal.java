import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class InorderTraversal {
    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> res = new ArrayList<Integer>();
        helper(root, res);
        return res;
    }
    private void helper(TreeNode root, List<Integer> res) {
        if (root == null) {
            return;
        }
        helper(root.left, res);
        res.add(root.key);
        helper(root.right, res);
    }
    public static void main(String[] args) {
        InorderTraversal sol = new InorderTraversal();
        Integer[] rootInt;
        TreeNode root;
        List<Integer> res;
        ConstructTree construct = new ConstructTree();

        rootInt = new Integer[]{1,null,2,3};
        root = construct.constructTree(rootInt);
        res = sol.inorderTraversal(root);
        System.out.println("Input  : " + Arrays.toString(rootInt));
        System.out.println("Output : " + Arrays.toString(res.toArray()));
    }
}
