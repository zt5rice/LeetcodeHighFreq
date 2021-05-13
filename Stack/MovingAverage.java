import java.util.ArrayDeque;
import java.util.Deque;

class MovingAverage {
    Deque<Integer> deque;
    int count;
    int sum;
    int size;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        deque = new ArrayDeque(size);
        count = 0;
        sum = 0;
        this.size = size;
    }
    
    public double next(int val) {
        if (count < size) {
            sum += val;
            deque.offerLast(val);
            count++;
        } else {
            sum -= deque.peekFirst();
            deque.pollFirst();
            sum += val;
            deque.offerLast(val);
        }
        double res = (double) sum / (double) count;
        System.out.println(res);
        return res;
    }

    public static void main(String[] args) {
        MovingAverage sol = new MovingAverage(3);
        sol.next(1);
        sol.next(10);
        sol.next(3);
        sol.next(5);
    }

}

/**
 * Your MovingAverage object will be instantiated and called as such:
 * MovingAverage obj = new MovingAverage(size);
 * double param_1 = obj.next(val);
 */