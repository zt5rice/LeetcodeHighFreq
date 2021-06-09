import java.util.Arrays;

public class IncreasingTriplet {
    public boolean increasingTriplet(int[] nums) {
        int first_num = Integer.MAX_VALUE;
        int second_num = Integer.MAX_VALUE;
        for (int n: nums) {
            if (n <= first_num) {
                first_num = n;
            } else if (n <= second_num) {
                second_num = n;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        IncreasingTriplet sol = new IncreasingTriplet();
        int[] arr;
        boolean res;

        arr = new int[]{1,2,3,4,5};
        res = sol.increasingTriplet(arr);
        System.out.println("Input  : " + Arrays.toString(arr));
        System.out.println("Outpu  : " + res);
    }
}
