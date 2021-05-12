import java.util.ArrayDeque;
import java.util.Deque;

class MinStack {
    private Deque<int[]> stack = new ArrayDeque<int[]>();

    /** initialize your data structure here. */
    public MinStack() {

    }

    public void push(int x) {
        if (stack.isEmpty()) {
            stack.offerFirst(new int[] { x, x });
            return;
        }
        int curMin = stack.peekFirst()[1];
        stack.offerFirst(new int[] { x, Math.min(curMin, x) });
    }

    public void pop() {
        stack.poll();
    }

    public int top() { // return max
        return stack.peekFirst()[0];
    }

    public int getMin() {
        return stack.peekFirst()[1];
    }

    public static void main(String[] args) {
        MinStack minStack = new MinStack();
        minStack.push(-2);
        minStack.push(0);
        minStack.push(-3);
        minStack.getMin(); // return -3
        minStack.pop();
        minStack.top(); // return 0
        minStack.getMin(); // return -2
    }
}

/**
 * Your MinStack object will be instantiated and called as such: MinStack obj =
 * new MinStack(); obj.push(x); obj.pop(); int param_3 = obj.top(); int param_4
 * = obj.getMin();
 */
/*
 * abstract 155. Min Stack Easy
 * 
 * Design a stack that supports push, pop, top, and retrieving the minimum
 * element in constant time.
 * 
 * Implement the MinStack class:
 * 
 * MinStack() initializes the stack object. void push(val) pushes the element
 * val onto the stack. void pop() removes the element on the top of the stack.
 * int top() gets the top element of the stack. int getMin() retrieves the
 * minimum element in the stack.
 * 
 * 
 * Example 1:
 * 
 * Input ["MinStack","push","push","push","getMin","pop","top","getMin"]
 * [[],[-2],[0],[-3],[],[],[],[]]
 * 
 * Output [null,null,null,null,-3,null,0,-2]
 * 
 * Explanation MinStack minStack = new MinStack(); minStack.push(-2);
 * minStack.push(0); minStack.push(-3); minStack.getMin(); // return -3
 * minStack.pop(); minStack.top(); // return 0 minStack.getMin(); // return -2
 * 
 */