public class ReverseBetween {

        // Object level variables since we need the changes
        // to persist across recursive calls and Java is pass by value.
        private boolean stop;
        private ListNode left;
    
        public void recurseAndReverse(ListNode right, int m, int n) {
    
            // base case. Don't proceed any further
            if (n == 1) {
                return;
            }
    
            // Keep moving the right pointer one step forward until (n == 1)
            right = right.next;
    
            // Keep moving left pointer to the right until we reach the proper node
            // from where the reversal is to start.
            if (m > 1) {
                this.left = this.left.next;
            }
    
            // Recurse with m and n reduced.
            this.recurseAndReverse(right, m - 1, n - 1);
    
            // In case both the pointers cross each other or become equal, we
            // stop i.e. don't swap data any further. We are done reversing at this
            // point.
            if (this.left == right || right.next == this.left) {
                this.stop = true;            
            }
    
            // Until the boolean stop is false, swap data between the two pointers
            if (!this.stop) {
                int t = this.left.val;
                this.left.val = right.val;
                right.val = t;
    
                // Move left one step to the right.
                // The right pointer moves one step back via backtracking.
                this.left = this.left.next;
            }
        }
    
        public ListNode reverseBetween(ListNode head, int m, int n) {
            this.left = head;
            this.stop = false;
            this.recurseAndReverse(head, m, n);
            return head;
        }
    
}
/*abstract
92. Reverse Linked List II
Medium

Given the head of a singly linked list and two integers left and right where left <= right, reverse the nodes of the list from position left to position right, and return the reversed list.

 

Example 1:


Input: head = [1,2,3,4,5], left = 2, right = 4
Output: [1,4,3,2,5]
Example 2:

Input: head = [5], left = 1, right = 1
Output: [5]
 

Constraints:

The number of nodes in the list is n.
1 <= n <= 500
-500 <= Node.val <= 500
1 <= left <= right <= n
 

Follow up: Could you do it in one pass?

*/