import java.util.ArrayDeque;
import java.util.Deque;

class MaxStack {
    Deque<Integer> stack;
    Deque<Integer> maxStack;

    public MaxStack() {
        stack = new ArrayDeque<>();
        maxStack = new ArrayDeque<>();
    }

    public void push(int x) {
        int max = maxStack.isEmpty() ? x : maxStack.peekLast();
        maxStack.offerLast(max > x ? max : x);
        stack.offerLast(x);
    }

    public int pop() {
        maxStack.pollLast();
        return stack.pollLast();
    }

    public int top() {
        return stack.peekLast();
    }

    public int peekMax() {
        return maxStack.peekLast();
    }

    public int popMax() {
        int max = peekMax();
        Deque<Integer> buffer = new ArrayDeque();
        while (top() != max) buffer.offerLast(pop());
        pop();
        while (!buffer.isEmpty()) push(buffer.pollLast());
        return max;
    }

    public static void main(String[] args) {
        MaxStack sol = new MaxStack();
        sol.push(5);
        sol.push(1);
        sol.push(5);
        sol.top();
        sol.popMax();
        sol.top();
        sol.peekMax();
        sol.pop();
        sol.top();
    }
}

/**
 * Your MaxStack object will be instantiated and called as such:
 * MaxStack obj = new MaxStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.peekMax();
 * int param_5 = obj.popMax();
 */