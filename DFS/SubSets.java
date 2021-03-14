import java.util.List;
import java.util.Arrays;
import java.util.*;
/*
63. All Subsets II
Hard
Given a set of characters represented by a String, return a list containing all subsets of the characters. Notice that each subset returned will be sorted to remove the sequence.

Assumptions

There could be duplicate characters in the original set.
​Examples

Set = "abc", all the subsets are ["", "a", "ab", "abc", "ac", "b", "bc", "c"]
Set = "abb", all the subsets are ["", "a", "ab", "abb", "b", "bb"]
Set = "abab", all the subsets are ["", "a", "aa","aab", "aabb", "ab","abb","b", "bb"]
Set = "", all the subsets are [""]
Set = null, all the subsets are []
*/

class SubSets {
    public List<String> subSets(String set) {
        List<String> res = new ArrayList<>();
        if (set == null) {
            return res;
        }
        char[] array = set.toCharArray(); // [a,b,c]
        Arrays.sort(array); // o(nlogn)
        StringBuilder sb = new StringBuilder(); // variable length
        helper(array, 0, sb, res);
        return res;
    }

    /*
     * input: "abc" a: a | _ b: ab | a_ | b | __ c: abc| ab_ | ac | a__ | bc | b__ |
     * c | ___ input: "abb", length == 2 0 a: a | _ 1 b: ab | a_ | b | __
     * 
     */
    private void helper(char[] array, int index, StringBuilder sb, List<String> res) {
        // base case
        if (index == array.length) {
            res.add(sb.toString());
            return;
        } // array sorted
          // 1. add the element
        sb.append(array[index]);
        helper(array, index + 1, sb, res);
        sb.deleteCharAt(sb.length() - 1);

        // 2. scape the element: case 1 - the same with prev element
        while (index < array.length - 1 && array[index + 1] == array[index]) {
            index++;
        }
        helper(array, index + 1, sb, res);
    }
}

/*
 * Assume: 1) duplicate possible, Method: DFS DS: sb, arr, res recursion tree: w
 * prune each level, add/not add, length n (not duplicated) TC: o(2^n), SC: o(n)
 * 
 * input: set: aabb output(sorted): [, a, a, aa, aab, aab, aabb, ab, ab, ab, ab,
 * abb, abb, b, b, bb] expected:<["", "a", "aa", "aab", "aabb", "ab", "abb",
 * "b", "bb"]> but was:<["", "a", "a", "aa", "aab", "aab", "aabb", "ab", "ab",
 * "ab", "ab", "abb", "abb", "b", "b", "bb"]>
 * 
 */
class Solution {
    public static void main(String[] args) {
        SubSets sol = new SubSets();
        String set = "aabb";
        System.out.println("Input  : " + set);
        System.out.println("Output : " + sol.subSets(set));
    }
}
