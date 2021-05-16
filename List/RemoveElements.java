import java.util.Arrays;

public class RemoveElements {
    public ListNode removeElements(ListNode head, int val) {
        ListNode sentinel = new ListNode(0);
        sentinel.next = head;
    
        ListNode prev = sentinel, curr = head;
        while (curr != null) {
          if (curr.val == val) prev.next = curr.next;
          else prev = curr;
          curr = curr.next;
        }
        return sentinel.next;
      }

      private ListNode int2list(int[] l) {
        ListNode dum = new ListNode(0);
        ListNode cur = dum;
        for (int i : l) {
            ListNode tmp = new ListNode(i);
            cur.next = tmp;
            cur = cur.next;
        }
        cur.next = null;
        return dum.next;
    }      

    private int[] list2int(ListNode n) {
        int count = 0;
        ListNode dum = n;
        while (dum != null) {
            count++;
            dum = dum.next;
        }
        int[] res = new int[count];
        for (int i = 0; i < count; i++) {
            res[i] = n.val;
            n = n.next;
        }
        return res;
    }
    public static void main(String[] args) {
        RemoveElements sol = new RemoveElements();
        int[] head = new int[]{1,2,6,3,4,5,6};

        int val = 6;
        ListNode h = sol.int2list(head);
        ListNode res = sol.removeElements(h, val);
        int[] resint = sol.list2int(res);
        System.out.println("Input : " + Arrays.toString(head));
        System.out.println("Value : " + val);
        System.out.println("Output : " + Arrays.toString(resint));
      }
}
/*abstract


https://leetcode.com/problems/remove-linked-list-elements/

*/