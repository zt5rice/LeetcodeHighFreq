import java.util.*;
public class MinMeetingRooms {
    public int minMeetingRooms(int[][] intervals) {
        if (intervals.length == 0) {
            return 0;
        }
        Arrays.sort(intervals, new Comparator<int[]>(){
            @Override
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        // allocator based on end time
        PriorityQueue<Integer> allocator = new PriorityQueue<Integer>();
        allocator.add(intervals[0][1]);
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] >= allocator.peek()) {
                allocator.poll();
            }
            allocator.add(intervals[i][1]);
        }
        return allocator.size();
    }
    public static void main(String[] args) {
        MinMeetingRooms sol = new MinMeetingRooms();
        int[][] intervals;
        int res;

        intervals = new int[][]{{0,30},{5,10},{15,20}};
        res = sol.minMeetingRooms(intervals);
        System.out.println("Input  : " + Arrays.deepToString(intervals));
        System.out.println("Output : " + res);
    }
}
/*abstract
253. Meeting Rooms II
Medium

Given an array of meeting time intervals intervals where intervals[i] = [starti, endi], return the minimum number of conference rooms required.

 

Example 1:

Input: intervals = [[0,30],[5,10],[15,20]]
Output: 2
Example 2:

Input: intervals = [[7,10],[2,4]]
Output: 1
 

Constraints:

1 <= intervals.length <= 104
0 <= starti < endi <= 106

*/