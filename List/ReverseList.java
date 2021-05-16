import java.util.Arrays;

public class ReverseList {
    public ListNode reverseList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode prev = null;
        ListNode cur = head;
        ListNode next;
        while (cur.next != null) {
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }
        cur.next = prev;
        return cur;
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
        ReverseList sol = new ReverseList();
        int[] h = new int[]{1,2,3,4,5};
        ListNode head, res;
        head = sol.int2list(h);
        res = sol.reverseList(head);
        int[] resint = sol.list2int(res);
        System.out.println("Input  : " + Arrays.toString(h));
        System.out.println("Output : " + Arrays.toString(resint));
    }
}
/*abstract


https://leetcode.com/problems/reverse-linked-list/

*/