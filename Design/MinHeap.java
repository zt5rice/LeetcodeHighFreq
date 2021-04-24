import java.util.Arrays;
import java.util.NoSuchElementException;

// Implementation Of Min Heap
// Empty version:
public class MinHeap {
    private int[] array;
    private int size; // actual length of minHeap

    public MinHeap(int[] array) {
		if (array == null || array.length == 0) {
			throw new IllegalArgumentException("input array can not be null or empty");
		}
		this.array = array;
		size = array.length;
		heapify();
    }

    private void heapify() { // from right to left percolate down
        // from last parent node
        int idx = size / 2 - 1; // array.length not good!!
        while (idx >= 0) {
            percolateDown(idx);
            idx--;
        }
    }

    public MinHeap(int cap) {
		if (cap <= 0) {
			throw new IllegalArgumentException("capacity can not be <= 0");
        }
        array = new int[cap];
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public boolean isFull() {
        return size == array.length;
    }

    private void percolateUp(int index) {
        while (index >= 0) {
            int parentIdx = (index - 1) / 2;
            if (array[parentIdx] > array[index]) {
                swap(parentIdx, index);
                index = parentIdx;
            } else {
                break;
            }    
        }
    }

    private void percolateDown(int index) {
        while (2 * index + 1 <= size) {
            int lchildIdx = 2 * index + 1;
            int rchildIdx = 2 * index + 2; 
            // 1. find the smaller child as swapCandidate (index)
            int swapCandidate = lchildIdx;
            if (rchildIdx <= size - 1 && array[lchildIdx] >= array[rchildIdx]) {
                swapCandidate = rchildIdx;
            }           
            if (array[index] > array[swapCandidate]) {
                swap(index, swapCandidate);
            } else {
                break;
            }
            index = swapCandidate;
        }    
    }

    public int peek() {
        if (size == 0) {
            throw new NoSuchElementException("heap is empty");
        }
        // two methods: 1. return a default value; check int or Integer if want to return null;
        return array[0];
    }

    public int poll() { // action copy the tail element to top
        if (size == 0) {
            throw new NoSuchElementException("heap is empty");
        }
        int result = array[0];
        array[0] = array[size - 1];
        size--; // when? before or after percolate, must process it before!!! If after, tail may interfere with the result
        percolateDown(0);
        return result;
    }

    public void offer(int ele) {
        if (size == array.length) { // out of bound.
            array = Arrays.copyOf(array, (int)(array.length * 1.5));
        }
        array[size] = ele;
        size++; // first make size right, then do other operations
        percolateUp(size - 1);
    }

    // return the original value
    public int update(int index, int ele) {
        if (index < 0 || index > size - 1) {
            throw new ArrayIndexOutOfBoundsException("heap is empty");           
        }
        int result = array[index];
        array[index] = ele;
        if (result > ele) {
            percolateUp(index);
        } else {
            percolateDown(index);
        }
        return result;
    }

    public void swap(int l, in r) {
        int tmp = array[l];
        array[l] = array[r];
        array[r] = tmp;
    }
}
/*abstract
follow-up: how to further apply to <E> generic type
E.compareTo....
*/