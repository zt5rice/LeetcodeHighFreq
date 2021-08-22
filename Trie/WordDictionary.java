import java.util.*;

class WordDictionary {
    Map<Integer, Set<String>> d;

    /** Initialize your data structure here. */
    public WordDictionary() {
        d = new HashMap();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        int m = word.length();
        if (!d.containsKey(m)) {
            d.put(m, new HashSet());
        }
        d.get(m).add(word);
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        int m = word.length();
        if (d.containsKey(m)) {
            for (String w : d.get(m)) {
                int i = 0;
                while ((i < m) && (w.charAt(i) == word.charAt(i) || word.charAt(i) == '.')) {
                    i++;
                }
                if (i == m) return true;
            }
        }
        return false;
    }
}