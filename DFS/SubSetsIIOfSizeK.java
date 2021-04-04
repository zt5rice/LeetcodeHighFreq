import java.util.*;
public class SubSetsIIOfSizeK {
    public List<String> subSetsIIOfSizeK(String set, int k) {
        // Write your solution here
        List<String> result = new ArrayList<String>();
        if (set == null) {
          return result;
        }
        char[] array = set.toCharArray();
        Arrays.sort(array);
        StringBuilder sb = new StringBuilder();
        helper(array, k, 0, sb, result);
        return result;
      }
    
      private void helper(char[] array, int k, int index, StringBuilder sb, List<String> result) {
        Set<String> set = new HashSet<String>();
        for (String str : result) {
            set.add(str);
        }    
        if (sb.length() == k) {
          if (!set.contains(sb.toString())) {
            result.add(sb.toString());        
          }
          return;
        }
        if (index == array.length) {
          return;
        }
    
        helper(array, k, index + 1, sb, result);
        helper(array, k, index + 1, sb.append(array[index]), result);
        sb.deleteCharAt(sb.length() - 1);
      }   

    public static void main(String[] args) {
        SubSetsIIOfSizeK sol = new SubSetsIIOfSizeK();
        String set = "abc";
        int k = 2;  // all the subsets are [“ab”, “ac”, “bc”].
        System.out.println("Input  : " + set);
        System.out.println("Output : " + sol.subSetsIIOfSizeK(set, k));

        set = "abb";
        k= 2;  // all the subsets are [“ab”, “bb”].
        System.out.println("Input  : " + set);
        System.out.println("Output : " + sol.subSetsIIOfSizeK(set, k));

        set = "abab"; 
        k = 2; // all the subsets are [“aa”, “ab”, “bb”].
        System.out.println("Input  : " + set);
        System.out.println("Output : " + sol.subSetsIIOfSizeK(set, k));

        set = "xykbluy"; 
        k = 3; // all the subsets are [“aa”, “ab”, “bb”].
        System.out.println("Input  : " + set);
        System.out.println("Output : " + sol.subSetsIIOfSizeK(set, k));
        
    }
}
/*abstract

Input: "", 3
expected:<["bkl", "bku", "bkx", "bky", "blu", "blx", "bly", "bux", "buy", "bxy", "byy", "klu", "klx", "kly", "kux", "kuy", "kxy", "kyy", "lux", "luy", "lxy", "lyy", "uxy", "uyy", "xyy"]> but was:<["bkl", "bku", "bkx", "bky", "bky", "blu", "blx", "bly", "bly", "bux", "buy", "buy", "bxy", "bxy", "byy", "klu", "klx", "kly", "kly", "kux", "kuy", "kuy", "kxy", "kxy", "kyy", "lux", "luy", "luy", "lxy", "lxy", "lyy", "uxy", "uxy", "uyy", "xyy"]>
*/