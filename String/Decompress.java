
/*
175. Decompress String II
Hard
Given a string in compressed form, decompress it to the original string. The adjacent repeated characters in the original string are compressed to have the character followed by the number of repeated occurrences.

Assumptions

The string is not null

The characters used in the original string are guaranteed to be ‘a’ - ‘z’

There are no adjacent repeated characters with length > 9

Examples

“a1c0b2c4” → “abbcccc”
*/
import java.util.*;

public class Decompress {
    public static void main(String[] args) {
        Decompress sol = new Decompress();
        String input = "a1c0b2c4";
        System.out.println("Input : " + input);
        System.out.println(sol.decompress(input));
    }

    public String decompress(String input) {
        // 1. sanitory clean
        if (input == null || input.length() == 0) {
            return input;
        }
        char[] arr = input.toCharArray();
        int count = 0; // duplication times
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < arr.length; i++) {
            char tmp = arr[i];
            while (i + 1 < arr.length && Character.isDigit(arr[i + 1])) {
                count *= 10;
                count += arr[i + 1] - '0';
                i++;
            }
            while (count > 0) {
                sb.append(tmp);
                count--;
            }

        }
        return sb.toString();
    }
}
