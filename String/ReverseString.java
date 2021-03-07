import java.util.*;

public class ReverseString {
    public void reverseString(char[] s) {
        if (s == null || s.length <= 1) {
            return;
        } // [i, j]
        int i = 0;
        int j = s.length - 1;
        while (i < j) {
            swap(s, i++, j--);
        }
        return;
    }
    private void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }
    public static void main(String[] args) {
        ReverseString sol = new ReverseString();
        String s = "Hello";
        char[] str = s.toCharArray();
        System.out.println("Input  : " + Arrays.toString(str));
        sol.reverseString(str);
        System.out.println("Output  : " + Arrays.toString(str));
    } 
}
