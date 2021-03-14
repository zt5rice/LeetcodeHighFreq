import java.util.*;
/*
640. All Subsets of Size K
Medium
Given a set of characters represented by a String, return a list containing all subsets of the characters whose size is K.

Assumptions

There are no duplicate characters in the original set.

​Examples

Set = "abc", K = 2, all the subsets are [“ab”, “ac”, “bc”].

Set = "", K = 0, all the subsets are [""].

Set = "", K = 1, all the subsets are [].

*/
class SubSetsOfSizeK {
    public List<String> subSetsOfSizeK(String set, int k) {
        List<String> res = new ArrayList<>();
        if (k > set.length()) {
          return res;
        }
        char[] arr = set.toCharArray();
        StringBuilder sb = new StringBuilder();
        helper(arr, k, 0, sb, res);
        return res;
      }
      private void helper(char[] arr, int k, int index, StringBuilder sb, List<String> res) {
        if (index >= arr.length) {
          if (sb.length() == k) {
            res.add(sb.toString());
          }
          return;
        } // base case;
        // not add
        helper(arr, k, index + 1, sb, res);
        // add
        sb.append(arr[index]);
        helper(arr, k, index + 1, sb, res);
        sb.deleteCharAt(sb.length() - 1);
      }    
    public static void main(String[] args) {
        SubSetsOfSizeK sol = new SubSetsOfSizeK();
        String str = "abc";
        int K = 2;
        System.out.println("Input  : " + str + "; K = " + K);
        System.out.println("Output : " + sol.subSetsOfSizeK(str, K));
    }
}

/*
i: string, int
o: list of string
a: no duplicate
method: dfs with prune, return when length == n, length == n, sc: 
tc: o(2^n), sc: o(n)
0:    ""
1:   "a" | ""
2:   "ab" "a" | "b" "" 
3:         "ac" "a" "bc" "c"

t: 1) set.length() == 0, k == 0 -> ""
    =2)             ..., k == 1 -> 
be careful with "" 0 case    
*/
