import java.util.*;
import TreeNode;
import ConstructTree;

public class LevelOrder {
    public List<List<Integer>> levelOrder(TreeNode root) {
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        List<List<Integer>> wrapList = new LinkedList<List<Integer>>();
        
        if(root == null) return wrapList;
        
        queue.offer(root);
        while(!queue.isEmpty()){
            int levelNum = queue.size();
            List<Integer> subList = new LinkedList<Integer>();
            for(int i=0; i<levelNum; i++) {
                if(queue.peek().left != null) queue.offer(queue.peek().left);
                if(queue.peek().right != null) queue.offer(queue.peek().right);
                subList.add(queue.poll().key);
            }
            wrapList.add(subList);
        }
        return wrapList;
    }    
    public static void main(String[] args) {
        LevelOrder sol = new LevelOrder();
        ConstructTree tree = new ConstructTree();
        Integer[] input = {3,9,20,null,null,15,7};
        System.out.println("Input  : " + Arrays.toString(input));
        TreeNode root = tree.constructTree(input);
        List<List<Integer>> res = sol.levelOrder(root);
        System.out.println("Output : " + res);
    }
}
