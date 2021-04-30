import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class GenerateParenthesis {
    public List<String> generateParenthesis(int n) {
        List<String> res = new ArrayList<String>();
        char[] arr = new char[2*n];
        dfs(res, arr, 0, n, n);
        return res;
    }
    private void dfs(List<String> res, char[] arr, int idx, int left, int right) {
        if (idx == arr.length) {
            res.add(new String(arr));
            return;
        }
        if (left > 0) {
            arr[idx] = '(';
            dfs(res, arr, idx + 1, left - 1, right);
        }
        if (right > left) {
            arr[idx] = ')';
            dfs(res, arr, idx + 1, left, right - 1);
        }            
    }    
    public static void main(String[] args) {
        GenerateParenthesis sol = new GenerateParenthesis();
        int n;
        List<String> res;

        n = 3;
        res = sol.generateParenthesis(n);
        System.out.println("Input  : " + n);
        System.out.println("Output : " + Arrays.toString(res.toArray()));
        
        n = 1;
        res = sol.generateParenthesis(n);
        System.out.println("Input  : " + n);
        System.out.println("Output : " + Arrays.toString(res.toArray()));
    }
}
