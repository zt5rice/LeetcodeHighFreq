import java.util.*;

public class MinAvailableDuration {
    public List<Integer> minAvailableDuration(int[][] slots1, int[][] slots2, int duration) {
        PriorityQueue<int[]> timeslots = new PriorityQueue<>((slot1, slot2) -> slot1[0] - slot2[0]);

        for (int[] slot: slots1) {
            if (slot[1] - slot[0] >= duration) timeslots.offer(slot);
        }
        for (int[] slot: slots2) {
            if (slot[1] - slot[0] >= duration) timeslots.offer(slot);
        }

        while (timeslots.size() > 1) {
            int[] slot1 = timeslots.poll();
            int[] slot2 = timeslots.peek();
            if (slot1[1] >= slot2[0] + duration) {
                return new ArrayList<Integer>(Arrays.asList(slot2[0], slot2[0] + duration));
            }
        }
        return new ArrayList<Integer>();
    }

    public static void main(String[] args) {
        MinAvailableDuration sol = new MinAvailableDuration();
        int[][] slots1, slots2;
        int duration;
        List<Integer> res;

        slots1 = new int[][]{{10,50},{60,120},{140,210}};
        slots2 = new int[][]{{0,15},{60,70}};
        duration = 8;
        res = sol.minAvailableDuration(slots1, slots2, duration);
        System.out.println("Slots1 : " + Arrays.deepToString(slots1));
        System.out.println("Slots1 : " + Arrays.deepToString(slots1));
        System.out.println("Duration : " + duration);
        System.out.println("Result : " + Arrays.toString(res.toArray()));
    }
}

/*abstract

1229. Meeting Scheduler
Medium

Given the availability time slots arrays slots1 and slots2 of two people and a meeting duration duration, return the earliest time slot that works for both of them and is of duration duration.

If there is no common time slot that satisfies the requirements, return an empty array.

The format of a time slot is an array of two elements [start, end] representing an inclusive time range from start to end.

It is guaranteed that no two availability slots of the same person intersect with each other. That is, for any two time slots [start1, end1] and [start2, end2] of the same person, either start1 > end2 or start2 > end1.

 

Example 1:

Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 8
Output: [60,68]
Example 2:

Input: slots1 = [[10,50],[60,120],[140,210]], slots2 = [[0,15],[60,70]], duration = 12
Output: []
 

Constraints:

1 <= slots1.length, slots2.length <= 104
slots1[i].length, slots2[i].length == 2
slots1[i][0] < slots1[i][1]
slots2[i][0] < slots2[i][1]
0 <= slots1[i][j], slots2[i][j] <= 109
1 <= duration <= 106

*/