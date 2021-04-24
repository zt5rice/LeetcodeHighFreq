import java.util.*;
public class LargestProduct {
    public static void main(String[] args) {
        LargestProduct sol = new LargestProduct();
        String[] dict = {"abcdefhi","ix","hj","x"};
        System.out.println(Arrays.toString(dict));
        System.out.println(sol.largestProduct(dict));
    }
    public int largestProduct(String[] dict) {
        HashMap<String, Integer> bitMap = getBitMasks(dict);        
        PriorityQueue<int[]> maxHeap = new PriorityQueue<int[]>(new Comparator<int[]>() {
          @Override
          public int compare(int[] i1, int[] i2) {
            int t1 = dict[i1[0]].length() * dict[i1[1]].length();
            int t2 = dict[i2[0]].length() * dict[i2[1]].length();
            if (t1 == t2) {
              return 0;
            }
            return t1 > t2 ? -1 : 1;
          }
        });

        System.out.println(Arrays.toString(bitMap.entrySet().toArray()));
        boolean[][] visited = new boolean[dict.length][dict.length];
        maxHeap.offer(new int[]{0, 1});
        visited[0][1] = true;
        // while (!maxHeap.isEmpty()) {
        //   int[] tmp = maxHeap.poll();
        //   System.out.println(Arrays.toString(tmp));
        //   if (bitMap.get(dict[tmp[0]]) & bitMap.get(dict[tmp[1]]) == 0) {
        //     return dict[tmp[0]].length() * dict[tmp[1]].length();
        //   }
        //   if (tmp[0] + 1 < dict.length && (!visited[tmp[0]+1][tmp[1]] || !visited[tmp[1]][tmp[0] + 1])) {
        //     maxHeap.offer(new int[]{tmp[0] + 1, tmp[1]});
        //     visited[tmp[0] + 1][tmp[1]] = true;
        //     visited[tmp[1]][tmp[0] + 1] = true;
        //   }
        //   if (tmp[1] + 1 < dict.length && (!visited[tmp[1]+1][tmp[0]] || !visited[tmp[0]][tmp[1] + 1])) {
        //     maxHeap.offer(new int[]{tmp[0] ,tmp[1]+ 1});
        //     visited[tmp[1] + 1][tmp[0]] = true;
        //     visited[tmp[0]][tmp[1] + 1] = true;
        //   }
        // }
         return 0;
      }
    //   private HashMap<String, Integer> coverMap(String[] dict) {
    //     HashMap<String, Integer> coMap = new HashMap<String, Integer>();
    //     for (String str : dict) {
    //       int tmp = 0;
    //       for (char c : str.toCharArray()) {
    //         tmp |= 1 << (c - 'a');
    //       }
    //       coMap.put(str, tmp);
    //     }
    //     return coMap;
    //   }
    private HashMap<String, Integer> getBitMasks(String[] dict) {
        HashMap<String, Integer> map = new HashMap<String, Integer>();
        for (String str: dict) {
          int bitMask = 0;
          for (int i = 0; i < str.length(); i++) {
            bitMask |= 1 << (str.charAt(i) - 'a');
          }
          map.put(str, bitMask);
        }
        return map;
      }
}
