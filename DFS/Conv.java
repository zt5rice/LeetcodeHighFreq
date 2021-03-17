import java.util.*;

public class Conv {
    public static void main(String[] args) {
        Conv sol = new Conv();
        int num = 231;
        System.out.println(sol.conv(num));
    }
    public List<String> conv(int num) {
        String[] pad = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
        StringBuilder sb = new StringBuilder();
        List<String> res = new ArrayList<>();
        int[] arr = convNum(num); // convert int to int[]
        helper(arr, sb, 0, res, pad);
        return res;
    }
    private void helper(int[] arr, StringBuilder sb, int index, List<String> res, String[] pad) {
        // base case 
        if (index == arr.length) {
            res.add(sb.toString());
            return;
        }
        String tmp = pad[arr[index]];
        if (tmp.length() == 0) {
            helper(arr, sb, index + 1, res, pad);
        }
        char[] choices = tmp.toCharArray();
        for (int i = 0; i < choices.length; i++) {
            sb.append(choices[i]);
            helper(arr, sb, index + 1, res, pad);
            sb.deleteCharAt(sb.length() - 1);	
        }
    }
    
    private int[] convNum(int num) {
        int count = 0;
        int tmp = num;
        while (tmp > 0) {
            tmp/= 10;
            count++;
        }
        int[] res = new int[count];
        for (int i = count - 1; i >= 0; i--) {
            res[i] = num % 10;
            num /= 10;
        }
        return res;
    }  
}
