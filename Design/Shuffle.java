import java.util.Arrays;
import java.util.Random;

public class Shuffle {
    private int[] nums;
    private Random random;

    public void Shuffle(int[] nums) {
        this.nums = nums;
        random = new Random();
    }
    
    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return nums;
    }
    
    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if(nums == null) return null;
        int[] a = nums.clone();
        for(int j = 1; j < a.length; j++) {
            int i = random.nextInt(j + 1);
            swap(a, i, j);
        }
        return a;
    }
    
    private void swap(int[] a, int i, int j) {
        int t = a[i];
        a[i] = a[j];
        a[j] = t;
    }
    
    public static void main(String[] args) {
        Shuffle sol = new Shuffle();
        int[] nums, res;

        nums = new int[]{1,2,3};
        sol.Shuffle(nums);
        res = sol.shuffle();
        System.out.println("Input  : " + Arrays.toString(nums));
        System.out.println("Output : " + Arrays.toString(res));
        res = sol.reset();
        System.out.println("Output : " + Arrays.toString(res));
    }

    
}
