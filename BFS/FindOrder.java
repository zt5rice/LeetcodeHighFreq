import java.util.*;
class FindOrder {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        int[] res = new int[numCourses]; // a possible solution
        int[] countPre = new int[numCourses]; // num of pre for the ith course
        List<List<Integer>> pre = new ArrayList<List<Integer>>(numCourses);
        for (int i = 0; i < numCourses; i++) {
            pre.add(new ArrayList<>());
        }
        for (int i = 0; i < prerequisites.length; i++) {
            int x = prerequisites[i][0];
            int y = prerequisites[i][1];
            pre.get(y).add(x);
            countPre[x]++;
        }
        Deque<Integer> queue = new ArrayDeque<>();
        for (int i = 0; i < numCourses; i++) {
            if (countPre[i] == 0) {
                queue.offerLast(i); // node with no pre
            }
        }
        int c = 0;
        while (!queue.isEmpty()) {
            int tmp = queue.pollFirst();
            res[c++] = tmp;
            for (int y : pre.get(tmp)) {
                if (--countPre[y] == 0) {
                    queue.offerLast(y);
                }
            }
        }
        return c == numCourses ? res : new int[]{};
    }    
    public static void main(String[] args) {
        FindOrder sol = new FindOrder();
        int numCourses = 2;
        int[][] prerequisites = {{1,0}};
        System.out.println("Num of courses :" + Integer.toString(numCourses));
        System.out.println("Prerequistites :" + Arrays.deepToString(prerequisites));
        System.out.println("Results:" + Arrays.toString(sol.findOrder(numCourses, prerequisites)));
        System.out.println("------------------------------");
        numCourses = 4;
        prerequisites = new int[][]{{1,0},{2,0},{3,1},{3,2}};
        System.out.println("Num of courses :" + Integer.toString(numCourses));
        System.out.println("Prerequistites :" + Arrays.deepToString(prerequisites));
        System.out.println("Results:" + Arrays.toString(sol.findOrder(numCourses, prerequisites)));
        System.out.println("------------------------------");
        // numCourses = 1;
        // prerequisites = new int[][]{{}};
        // System.out.println("Num of courses :" + Integer.toString(numCourses));
        // System.out.println("Prerequistites :" + Arrays.deepToString(prerequisites));
        // System.out.println("Results:" + Arrays.toString(sol.findOrder(numCourses, prerequisites)));
        // System.out.println("------------------------------");
    }
}
/*
Course Schedule II

There are a total of n courses you have to take labelled from 0 to n - 1.
Some courses may have prerequisites, for example, if prerequisites[i] = [ai, bi] this means you must take the course bi before the course ai.
Given the total number of courses numCourses and a list of the prerequisite pairs, return the ordering of courses you should take to finish all courses.
If there are many valid answers, return any of them. If it is impossible to finish all courses, return an empty array.

*/