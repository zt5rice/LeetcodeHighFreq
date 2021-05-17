import java.util.Arrays;

public class IsSymmetric {
    public boolean isSymmetric(TreeNode root) {
        return isMirror(root, root);
    }
    
    public boolean isMirror(TreeNode t1, TreeNode t2) {
        if (t1 == null && t2 == null) return true;
        if (t1 == null || t2 == null) return false;
        return (t1.key == t2.key)
            && isMirror(t1.right, t2.left)
            && isMirror(t1.left, t2.right);
    }

    public static void main(String[] args) {
        IsSymmetric sol = new IsSymmetric();
        ConstructTree tree = new ConstructTree();
        Integer[] rootint = new Integer[]{1,2,2,3,4,4,3};
        TreeNode root = tree.constructTree(rootint);
        Boolean res = sol.isSymmetric(root);
        System.out.println("Input  : " + Arrays.toString(rootint));
        System.out.println("Output : " + res);

    }
}
