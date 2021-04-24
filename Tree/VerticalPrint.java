import java.util.*;
import TreeNode;

public class VerticalPrint {
    public static void main(String[] args) {
        VerticalPrint sol = new VerticalPrint();

    }
    public List<List<Integer>> verticalList(TreeNode root){
        //step1: do breadth first search
        //initialize
        Queue<Cell> queue = new ArrayDeque<>();
        queue.offer(new Cell(root, 0));
        List<Cell> list = new ArrayList<>();
        while (!queue.isEmpty()){
            Cell temp = queue.poll();
            list.add(temp);
            if (temp.node.left != null){
                queue.offer(new Cell(temp.node.left, temp.index -1));
            }
            if (temp.node.right != null){
                queue.offer(new Cell(temp.node.right, temp.index + 1));
            }
        }
        
        //step2: do merge Sort for cells
        Collections.sort(list, new Comparator<Cell>(){
            @Override
            public int compare(Cell c1, Cell c2){
            if (c1.index == c2.index){
                return 0;
            }
            return c1.index < c2.index ? -1 : 1;
            }
        });
        
        //step3: get the result list
        List<List<Integer>> result = new ArrayList<>();
        int i = 0;// list[i] is being processed
        while (i <= list.size() - 1){
            Cell cur = list.get(i);
            int col = cur.index;
            List<Integer> verList = new ArrayList<>();
            while (i <= list.size() - 1 && cur.index == col){
                verList.add(cur.node.key);
                i++;
                if (i <= list.size() - 1){
                    cur = list.get(i);
                }
            }
            result.add(verList);
        }
        return result;
        } 

        class Cell{
            TreeNode node;
            int index;
            Cell(TreeNode node, int index){
                this.node = node;
                this.index = index;
            }
        }
        
            
}
