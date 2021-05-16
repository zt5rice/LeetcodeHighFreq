import jdk.incubator.jpackage.main.Main;

public class HasCycle {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }

        ListNode slow = head;
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        HasCycle sol = new HasCycle();
        ListNode head = new ListNode(1);
        Boolean res; 

        res = sol.hasCycle(head);
        System.out.println("Output : " + res);
    }
}
/*abstract
https://leetcode.com/problems/linked-list-cycle/

*/