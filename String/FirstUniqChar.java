public class FirstUniqChar {
    public int firstUniqChar(String s) {
        int[] count = new int[26];
        int n = s.length();
        // build char count bucket : <charIndex, count>
        for (int i = 0; i < n; i++) {            
            int index = s.charAt(i) - 'a';
            count[index]++;
        }
        
        // find the index
        for (int i = 0; i < n; i++) {
            int index = s.charAt(i) - 'a';
            if (count[index] == 1) {
                return i;
            }
                
        }
        return -1;
    }
    
    public static void main(String[] args) {
        FirstUniqChar sol = new FirstUniqChar();
        String s;
        int res;

        s = "leetcode";
        res = sol.firstUniqChar(s);
        System.out.println("Input  : " + s);
        System.out.println("Output : " + res);
    }
}
/*abstract

https://leetcode.com/problems/first-unique-character-in-a-string/
*/