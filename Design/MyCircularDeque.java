import java.util.*;
public class MyCircularDeque {
    int size;
    int k;
    DoubleListNode head;
    DoubleListNode tail;
    /** Initialize your data structure here. Set the size of the deque to be k. */
    public MyCircularDeque(int k) {
        head = new DoubleListNode(-1);
        tail = new DoubleListNode(-1);
        head.pre = tail;
        tail.next = head;
        this.k = k;
        this.size = 0;        
    }
    
    /** Adds an item at the front of Deque. Return true if the operation is successful. */
    public boolean insertFront(int value) {
        if (size == k) {
            System.out.println("False");
            return false;
        }
            
        DoubleListNode node = new DoubleListNode(value);
        node.next = head;
        node.pre = head.pre;
        head.pre.next = node;
        head.pre = node;
        size++;
        System.out.println("True");
        return true;        
    }
    
    /** Adds an item at the rear of Deque. Return true if the operation is successful. */
    public boolean insertLast(int value) {
        if (size == k) {
            System.out.println("False");
            return false;
        }
            
        DoubleListNode node = new DoubleListNode(value);
        node.next = tail.next;
        tail.next.pre = node;
        tail.next = node;
        node.pre = tail;
        size++;
        System.out.println("True");
        return true;        
    }
    
    /** Deletes an item from the front of Deque. Return true if the operation is successful. */
    public boolean deleteFront() {
        if (size == 0) {
            System.out.println("False");
            return false;
        }
            
        head.pre.pre.next = head;
        head.pre = head.pre.pre;
        size--;
        System.out.println("True");
        return true;        
    }
    
    /** Deletes an item from the rear of Deque. Return true if the operation is successful. */
    public boolean deleteLast() {
        if (size == 0) {
            System.out.println("False");
            return false;
        }
        tail.next.next.pre = tail;
        tail.next = tail.next.next;
        size--;
        System.out.println("True");
        return true;        
    }
    
    /** Get the front item from the deque. */
    public int getFront() {
        System.out.println(head.pre.val);
        return head.pre.val;        
    }
    
    /** Get the last item from the deque. */
    public int getRear() {
        System.out.println(tail.next.val);
        return tail.next.val;        
    }
    
    /** Checks whether the circular deque is empty or not. */
    public boolean isEmpty() {
        return size == 0;        
    }
    
    /** Checks whether the circular deque is full or not. */
    public boolean isFull() {
        return size == k;        
    }    

}
class DoubleListNode {
    DoubleListNode pre;
    DoubleListNode next;
    int val;
    public DoubleListNode(int val) {
        this.val = val;
    }
}

class Solution {
       public static void main(String[] args) {
        MyCircularDeque circularDeque = new MycircularDeque(3); // set the size to be 3
        circularDeque.insertLast(1);            // return true
        circularDeque.insertLast(2);            // return true
        circularDeque.insertFront(3);            // return true
        circularDeque.insertFront(4);            // return false, the queue is full
        circularDeque.getRear();              // return 2
        circularDeque.isFull();                // return true
        circularDeque.deleteLast();            // return true
        circularDeque.insertFront(4);            // return true
        circularDeque.getFront();            // return 4       
    } 
}