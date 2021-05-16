import java.util.Arrays;

public class IsPalindromeList {
    public boolean isPalindrome(ListNode head) {

        if (head == null) return true;

        // Find the end of first half and reverse second half.
        ListNode firstHalfEnd = endOfFirstHalf(head);
        ListNode secondHalfStart = reverseList(firstHalfEnd.next);

        // Check whether or not there is a palindrome.
        ListNode p1 = head;
        ListNode p2 = secondHalfStart;
        boolean result = true;
        while (result && p2 != null) {
            if (p1.val != p2.val) result = false;
            p1 = p1.next;
            p2 = p2.next;
        }        

        // Restore the list and return the result.
        firstHalfEnd.next = reverseList(secondHalfStart);
        return result;
    }

    // Taken from https://leetcode.com/problems/reverse-linked-list/solution/
    private ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }
        return prev;
    }

    private ListNode endOfFirstHalf(ListNode head) {
        ListNode fast = head;
        ListNode slow = head;
        while (fast.next != null && fast.next.next != null) {
            fast = fast.next.next;
            slow = slow.next;
        }
        return slow;
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

    public static void main(String[] args) {
        IsPalindromeList sol = new IsPalindromeList();
        int[] h = new int[]{1,2,2,1};
        ListNode head = sol.int2list(h);
        Boolean res = sol.isPalindrome(head);
        System.out.println("Input  : " + Arrays.toString(h));
        System.out.println("Output : " + res);
    }
}
