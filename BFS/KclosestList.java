/*
@Parameter: int[] a, int[] b, int[] c, int k
@Output: List<Integer> res
Assumption:
  1) K >= 1 and K <= a.length * b.length * c.length
  2) a, b, c; not null or empty
R: BFS - 2
  DS: minHeap of list, pq based on dist
      int dist(list, a, b, c)
  visited - hashSet<List<Integer>>
  init - minHeap.offer(List<Integer>)
  term: poll times == k - 1
  generation: minHeap.offer(List.asList(x?+1, y?+1, z?+1)) if not out of bound and visited 
  expansion: tmp.minHeap.poll();
result. minHeap.poll();

TC: O(KlogK)
SC: O(K + a.length*b.length*c.length)
T: 
*/
import java.util.*;
public class KclosestList {
    public static void main(String[] args) {
        KclosestList sol = new KclosestList();
        int[] a = {1,2,3};
        int[] b = {2,4};
        int[] c = {1,2};
        int k = 10;
        List<Integer> rst = sol.closest(a, b, c, k);
        System.out.println(rst);
        rst = sol.closest0(a, b, c, k);
        System.out.println(rst);
    } // [1,2,3],[2,4],[1,2]
    public List<Integer> closest(int[] a, int[] b, int[] c, int k) {
        if (a == null || b == null || c == null || a.length * b.length * c.length < k) {
          return new ArrayList<Integer>();
        }
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<List<Integer>>(2*k, new Comparator<List<Integer>>(){
          @Override
          public int compare(List<Integer> l1, List<Integer> l2) {
            int d1 = dist(l1, a, b, c);
            int d2 = dist(l2, a, b, c);
            if (d1 == d2) {
              return 0;
            }
            return d1 < d2 ? -1 : 1;
          }
        });
        Set<List<Integer>> visited = new HashSet<List<Integer>>();
        // 1. init
        List<Integer> tmp = Arrays.asList(0,0,0);
        minHeap.offer(tmp);     
        visited.add(tmp);
        while (k > 1) {
          List<Integer> t1 = minHeap.poll();
          System.out.print("k = " + k + "; ");
          System.out.println(t1);
          List<Integer> t1x = Arrays.asList(t1.get(0) + 1, t1.get(1), t1.get(2));
          if (t1.get(0) + 1 < a.length && visited.add(t1x)) { // visited add when insert into pq
            minHeap.offer(t1x);
          }
          List<Integer> t1y = Arrays.asList(t1.get(0), t1.get(1) + 1, t1.get(2));      
          if (t1.get(1) + 1 < b.length && visited.add(t1y)) {
            minHeap.offer(t1y);
          }
          List<Integer> t1z = Arrays.asList(t1.get(0), t1.get(1), t1.get(2) + 1);       
          if (t1.get(2) + 1 < c.length && visited.add(t1z)) {
            minHeap.offer(t1z);
          }      
          k--;
        }
        List<Integer> rst = minHeap.poll();
        System.out.print("k = " + k + "; ");
        System.out.println(rst);

        rst.set(0, a[rst.get(0)]);
        rst.set(1, b[rst.get(1)]);
        rst.set(2, c[rst.get(2)]);    
        return rst;
      }
      private int dist(List<Integer> l1, int[] a, int[] b, int[] c) {
        int d = 0;
        d += a[l1.get(0)] * a[l1.get(0)];
        d += b[l1.get(1)] * b[l1.get(1)];
        d += c[l1.get(2)] * c[l1.get(2)];    
        return d;
      }
      public List<Integer> closest0(int[] a, int[] b, int[] c, int k) {
        // Write your solution here
        PriorityQueue<List<Integer>> minHeap = new PriorityQueue<>(2*k, 
        new Comparator<List<Integer>>() {
          @Override
          public int compare(List<Integer> o1, List<Integer> o2) {
            long d1 = distance(o1, a, b, c);
            long d2 = distance(o2, a, b, c);
            if (d1 == d2) {
              return 0;
            }
            return d1 < d2 ? -1 : 1;
          }
        });
        Set<List<Integer>> visited = new HashSet<>();
        List<Integer> cur = Arrays.asList(0, 0, 0);
        visited.add(cur);
        minHeap.offer(cur);
        while (k > 0) {
          cur = minHeap.poll();
          System.out.print("k = " + k + "; ");
          System.out.println(cur);
          List<Integer> n = Arrays.asList(cur.get(0) + 1, cur.get(1), cur.get(2)) ;
          if (n.get(0) < a.length && visited.add(n)) {
            minHeap.offer(n);
          }
          n = Arrays.asList(cur.get(0), cur.get(1) + 1, cur.get(2));
          if (n.get(1) < b.length && visited.add(n)) {
            minHeap.offer(n);
          }
          n = Arrays.asList(cur.get(0), cur.get(1), cur.get(2) + 1);
          if (n.get(2) < c.length && visited.add(n)) {
            minHeap.offer(n);
          }
          k--;
        }
        cur.set(0, a[cur.get(0)]);
        cur.set(1, b[cur.get(1)]);
        cur.set(2, c[cur.get(2)]);
        return cur;    
      }
      private long distance(List<Integer> point, int[] a, int[] b, int[] c) {
        long dis = 0;
        dis += a[point.get(0)] * a[point.get(0)];
        dis += b[point.get(1)] * b[point.get(1)];
        dis += c[point.get(2)] * c[point.get(2)]; 
        return dis;   
      }      
}
