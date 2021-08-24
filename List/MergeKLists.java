import java.util.Comparator;
import java.util.PriorityQueue;

public class MergeKLists {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode rst = new ListNode();
        ListNode cur = rst;
        int len = lists.length;
        if (len == 0) {
            return null;
        } else if (len == 1) {
            return lists[0];
        }
        PriorityQueue<ListNode> minHeap = new PriorityQueue<ListNode>(len, new Comparator<ListNode>() {
            @Override
            public int compare(ListNode L1, ListNode L2) {
                if (L1.val == L2.val) {
                    return 0;
                }
                return L1.val < L2.val ? -1 : 1;
            }
        });
        // initialization
        for (int i = 0; i < len; i++) {
            if (lists[i] != null) {
                minHeap.offer(lists[i]);
            }
        }
        // pop
        while (!minHeap.isEmpty()) {
            ListNode tmp = minHeap.poll();
            if (tmp.next != null) {
                minHeap.offer(tmp.next);
            }
            cur.next = tmp;
            cur = cur.next;
            cur.next = null;
        }

        // return
        return rst.next;
    }

    public class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

}
/*
 * abstract 23. Merge k Sorted Lists Hard
 * 
 * You are given an array of k linked-lists lists, each linked-list is sorted in
 * ascending order.
 * 
 * Merge all the linked-lists into one sorted linked-list and return it.
 * 
 * 
 * 
 * Example 1:
 * 
 * Input: lists = [[1,4,5],[1,3,4],[2,6]] Output: [1,1,2,3,4,4,5,6] Explanation:
 * The linked-lists are: [ 1->4->5, 1->3->4, 2->6 ] merging them into one sorted
 * list: 1->1->2->3->4->4->5->6 Example 2:
 * 
 * Input: lists = [] Output: [] Example 3:
 * 
 * Input: lists = [[]] Output: []
 * 
 * 
 * Constraints:
 * 
 * k == lists.length 0 <= k <= 10^4 0 <= lists[i].length <= 500 -10^4 <=
 * lists[i][j] <= 10^4 lists[i] is sorted in ascending order. The sum of
 * lists[i].length won't exceed 10^4.
 * 
 * 
 */