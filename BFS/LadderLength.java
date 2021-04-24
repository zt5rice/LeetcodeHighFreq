import java.util.*;

public class LadderLength {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> dict = new HashSet<>(wordList);
        Queue<String> queue = new ArrayDeque<>();
        Set<String> visited = new HashSet<>();
        int level = 0;
        // 1. init
        queue.offer(beginWord);
        visited.add(beginWord);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                String tmp = queue.poll();
                size--;
                if (tmp.equals(endWord)) {
                    return level + 1;
                }
                // generate next word
                List<String> nei = getNei(tmp, visited, dict);
                for (String neiWord : nei) {
                    queue.offer(neiWord);
                    visited.add(neiWord);
                }
            }
            level++;
        }
        return 0;
    }
    private List<String> getNei(String tmp, Set<String> visited, Set<String> dict) {
        List<String> nei = new ArrayList<>();
        char[] arr = tmp.toCharArray();
        for (int i = 0; i < arr.length; i++) {
            char orig = arr[i];
            for (char j = 'a'; j <= 'z'; j++) {
                if (j != orig) {
                    arr[i] = j;
                    String newStr = new String(arr);
                    if (dict.contains(newStr) && !visited.contains(newStr)) {
                        nei.add(newStr);
                    }
                    arr[i] = orig;
                }
            }
        }
        return nei;
    }   
    public static void main(String[] args) {
        LadderLength sol = new LadderLength();
        String beginWord = "hit";
        String endWord = "cog";
        String[] dict = {"hot","dot","dog","lot","log","cog"};
        List<String> wordList = Arrays.asList(dict);
        System.out.println("beginWord : " + beginWord);
        System.out.println("endWord : " + endWord);
        System.out.println("dictionary : " + wordList.toString());
        System.out.println(sol.ladderLength(beginWord, endWord, wordList));
    } 
}
/*
method: dfs 
ds: queue, hashset - dictionary, visited - hashset
1. init, put begin word into queue, adn visited
2. termination, if == end word || queue.isEmpty();
3. level by level gen, get level size, poll out -> equal endword? 
-> generate non-visited, next word in dict -> existed? put to queue and visited
4. if term, return 0

tc: o(set.size())
*/