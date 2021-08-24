public class ReorderList {
        public void reorderList(ListNode head) {
          if (head == null) return;
      
          // find the middle of linked list [Problem 876]
          // in 1->2->3->4->5->6 find 4 
          ListNode slow = head, fast = head;
          while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
          }
      
          // reverse the second part of the list [Problem 206]
          // convert 1->2->3->4->5->6 into 1->2->3->4 and 6->5->4
          // reverse the second half in-place
          ListNode prev = null, curr = slow, tmp;
          while (curr != null) {
            tmp = curr.next;
      
            curr.next = prev;
            prev = curr;
            curr = tmp;
          }
      
          // merge two sorted linked lists [Problem 21]
          // merge 1->2->3->4 and 6->5->4 into 1->6->2->5->3->4
          ListNode first = head, second = prev;
          while (second.next != null) {
            tmp = first.next;
            first.next = second;
            first = tmp;
      
            tmp = second.next;
            second.next = first;
            second = tmp;
          }
        }
      
}
/*abstract
143. Reorder List
Medium

You are given the head of a singly linked-list. The list can be represented as:

L0 → L1 → … → Ln - 1 → Ln
Reorder the list to be on the following form:

L0 → Ln → L1 → Ln - 1 → L2 → Ln - 2 → …
You may not modify the values in the list's nodes. Only nodes themselves may be changed.

 

Example 1:


Input: head = [1,2,3,4]
Output: [1,4,2,3]
Example 2:


Input: head = [1,2,3,4,5]
Output: [1,5,2,4,3]
 

Constraints:

The number of nodes in the list is in the range [1, 5 * 104].
1 <= Node.val <= 1000

*/