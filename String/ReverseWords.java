public class ReverseWords {
    public String reverseWords(String s) {
        if (s == null)
            return null;
    
        char[] str = s.toCharArray();
        int start = 0, end = str.length - 1;
    
        // Trim start of string
        while (start <= end && str[start] == ' ')
            start++;
    
        //Trim end of string
        while (end >= 0 && str[end] == ' ')
            end--;
    
        if (start > end)
            return new String("");
    
        int i = start;
        while (i <= end) {
            if (str[i] != ' ') {
                // case when i points to a start of word -  find the word reverse it
                int j = i + 1;
                while (j <= end && str[j] != ' ')
                    j++;
                reverse(str, i, j - 1);
                i = j;
            } else {
                if (str[i - 1] == ' ') {
                    //case when prev char is also space - shift char to left by 1 and decrease end pointer
                    int j = i;
                    while (j <= end - 1) {
                        str[j] = str[j + 1];
                        j++;
                    }
                    end--;
                } else
                    // case when there is just single space
                    i++;
            }
        }
        //Now that all words are reversed, time to reverse the entire string pointed by start and end - This step reverses the words in string
        reverse(str, start, end);
        // return new string object pointed by start with len = end -start + 1
        return new String(str, start, end - start + 1);
    }
    
    private static void reverse(char[] str, int begin, int end) {
        while (begin < end) {
            char temp = str[begin];
            str[begin] = str[end];
            str[end] = temp;
            begin++;
            end--;
        }
    }   
    
    public static void main(String[] args) {
        ReverseWords sol = new ReverseWords();
        String s, res;

        s = "the sky is blue";
        res = sol.reverseWords(s);
        System.out.println("Input  : " + s);
        System.out.println("Output : " + res);

        s = "  hello world  ";
        res = sol.reverseWords(s);
        System.out.println("Input  : " + s);
        System.out.println("Output : " + res);

        s = "a good   example";
        res = sol.reverseWords(s);
        System.out.println("Input  : " + s);
        System.out.println("Output : " + res);

        s = "  Bob    Loves  Alice   ";
        res = sol.reverseWords(s);
        System.out.println("Input  : " + s);
        System.out.println("Output : " + res);
    }
}
