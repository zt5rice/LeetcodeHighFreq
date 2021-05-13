import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.TreeMap;

public class GetSkyline {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> heights = new ArrayList<>();
        for (int[] b: buildings) {
            heights.add(new int[]{b[0], - b[2]});
            heights.add(new int[]{b[1], b[2]});
        }
        Collections.sort(heights, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
        TreeMap<Integer, Integer> heightMap = new TreeMap<>(Collections.reverseOrder());
        heightMap.put(0,1);
        int prevHeight = 0;
        List<List<Integer>> skyLine = new ArrayList<>();
        for (int[] h: heights) {
            if (h[1] < 0) {
                Integer cnt = heightMap.get(-h[1]);
                cnt = ( cnt == null ) ? 1 : cnt + 1;
                heightMap.put(-h[1], cnt);
            } else {
                Integer cnt = heightMap.get(h[1]);
                if (cnt == 1) {
                    heightMap.remove(h[1]);
                } else {
                    heightMap.put(h[1], cnt - 1);
                }
            }
            int currHeight = heightMap.firstKey();
            if (prevHeight != currHeight) {
                skyLine.add(List.of(h[0], currHeight));
                prevHeight = currHeight;
            }
        }
        return skyLine;
    }
    
    public static void main(String[] args) {
        GetSkyline sol = new GetSkyline();
        int[][] buildings;
        List<List<Integer>> skyline;

        buildings = new int[][]{{2,9,10},{3,7,15},{5,12,12},{15,20,10},{19,24,8}};
        skyline = sol.getSkyline(buildings);
        System.out.println("Input  : " + Arrays.deepToString(buildings));
        System.out.println("Output : " + Arrays.deepToString(skyline.toArray()));
    }
}
