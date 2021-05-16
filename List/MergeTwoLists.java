import java.util.Arrays;

public class MergeTwoLists {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode rst = new ListNode(0);
        ListNode cur = rst;
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                cur.next = l1;
                l1 = l1.next;
                cur = cur.next;
            } else {
                cur.next = l2;
                l2 = l2.next;
                cur = cur.next;
            }
        }
        if (l1 == null) {
            cur.next = l2;
        } else {
            cur.next = l1;
        }
        return rst.next;
    }

    public static void main(String[] args) {
        MergeTwoLists sol = new MergeTwoLists();
        int[] l1, l2, resint;
        ListNode n1, n2, res;

        l1 = new int[]{1,2,4};
        l2 = new int[]{1,3,4};
        n1 = sol.conv(l1);
        n2 = sol.conv(l2);
        res = sol.mergeTwoLists(n1, n2);
        resint = sol.list2int(res);
        System.out.println("Output : " + Arrays.toString(resint));
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

    private ListNode conv(int[] l) {
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
}
