import java.util.*;
public class CanFinish {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList[] graph = new ArrayList[numCourses];
        int[] degree = new int[numCourses];
        Queue queue = new LinkedList();
        int count=0;
        
        for(int i=0;i<numCourses;i++)
            graph[i] = new ArrayList();
            
        for(int i=0; i<prerequisites.length;i++){
            degree[prerequisites[i][1]]++;
            graph[prerequisites[i][0]].add(prerequisites[i][1]);
        }
        for(int i=0; i<degree.length;i++){
            if(degree[i] == 0){
                queue.add(i);
                count++;
            }
        }
        
        while(queue.size() != 0){
            int course = (int)queue.poll();
            for(int i=0; i<graph[course].size();i++){
                int pointer = (int)graph[course].get(i);
                degree[pointer]--;
                if(degree[pointer] == 0){
                    queue.add(pointer);
                    count++;
                }
            }
        }
        if(count == numCourses)
            return true;
        else    
            return false;
    }
    public static void main(String[] args) {
        CanFinish sol = new CanFinish();
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};
        System.out.println("Num of courses :" + Integer.toString(numCourses));
        System.out.println("Prerequistites :" + Arrays.deepToString(prerequisites));
        System.out.println("Results:" + sol.canFinish(numCourses, prerequisites));
        System.out.println("------------------------------");
        numCourses = 2;
        prerequisites = new int[][]{{1,0},{0,1}};
        System.out.println("Num of courses :" + Integer.toString(numCourses));
        System.out.println("Prerequistites :" + Arrays.deepToString(prerequisites));
        System.out.println("Results:" + sol.canFinish(numCourses, prerequisites));
        System.out.println("------------------------------");
    }
}
