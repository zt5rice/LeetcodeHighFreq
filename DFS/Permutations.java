import java.util.*;
/*
65. All Permutations II
Hard
Given a string with possible duplicate characters, return a list with all permutations of the characters.

Examples

Set = “abc”, all permutations are [“abc”, “acb”, “bac”, “bca”, “cab”, “cba”]
Set = "aba", all permutations are ["aab", "aba", "baa"]
Set = "", all permutations are [""]
Set = null, all permutations are []
*/
public class Permutations {

    public List<String> permutations(String input) {
        List<String> res = new ArrayList<>();
        if (res == null) {
          return res;
        }
        char[] arr = input.toCharArray();
        helper(arr, 0, res);
        return res;
      }
      private void helper(char[] arr, int index, List<String> res) {
        if (index == arr.length) {
          res.add(new String(arr));
          return;
        }
        Set<Character> set = new HashSet<>();
        for (int i = index; i < arr.length; i++) {
          if (set.add(arr[i])) {
            swap(arr, index, i);
            helper(arr, index + 1, res);
            swap(arr, index, i);
          }
        }
      }
      private void swap(char[] arr, int left, int right) {
        char tmp = arr[left];
        arr[left] = arr[right];
        arr[right] = tmp;
      }    
}
