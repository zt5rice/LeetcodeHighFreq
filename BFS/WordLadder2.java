import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.Set;

/*
126. Word Ladder II
Input: List<String> wordList
Output: List<List<String>> where each list in the list is a transformation from beginWord to endWord using shortest # of steps

                git
               /    \
            hit      got
              \       /
               hot
Data Structure
HashMap<String, List<String>> graph: key: a word value: a predecessor
predecessor needs only one letter transformation to word
word and its predecessor has min step diff = 1, i.e.
the difference of the min step from word to beginWord and the min step from its predecessor to beginWord must be 1

HashMap<String, Integer> visited: key: words that have been put into the queue; 
value: min # of steps from beginWord to the key

step1: do breadth first search
Data Structure:
Queue
step: min # of step from beginWord to the word being polled from queue

step2: depth first search
do dfs from the endWords using the HashMap graph

*/
public class WordLadder2 {
    public List<List<String>> wordLadder(List<String> wordList, String beginWord, String endWord) {
        // map of predecessor
        Map<String, List<String>> graph = new HashMap<>();
        // map of visited
        Map<String, Integer> visited = new HashMap<>();

        // step1: do breadth first search
        bfs(wordList, beginWord, endWord, graph, visited);

        // step2: do depth first search
        List<List<String>> result = new ArrayList<>();
        List<String> path = new ArrayList<>();
        path.add(endWord);
        dfs(graph, result, path, endWord);
        return result;
    }

    public void dfs(Map<String, List<String>> graph, List<List<String>> result, List<String> path, String endWord) {
        // base case
        if (graph.get(endWord) == null) {
            if (path.size() == 1) {
                return;
            }
            List<String> comb = new ArrayList(path);
            Collections.reverse(comb);
            result.add(comb);
            return;
        }

        for (String pred : graph.get(endWord)) {
            path.add(pred);
            dfs(graph, result, path, pred);
            path.remove(pred);
        }
    }

    public void bfs(List<String> wordList, String beginWord, String endWord, Map<String, List<String>> graph,
            Map<String, Integer> visited) {
        Queue<String> queue = new ArrayDeque<>();
        queue.offer(beginWord);
        visited.put(beginWord, 0);
        while (!queue.isEmpty()) {
            String temp = queue.poll();
            if (temp == endWord) {
                break;
            }
            int step = visited.get(temp);
            for (String nei : getNeighbors(temp, wordList)) {
                if (!visited.containsKey(nei)) {
                    visited.put(nei, step + 1);
                    queue.offer(nei);
                    graph.put(nei, new ArrayList());
                }
                if (visited.get(nei) == step + 1) {
                    graph.get(nei).add(temp);
                }
            }
        }
    }

    public List<String> getNeighbors(String temp, List<String> wordList) {
        Set<String> dict = new HashSet(wordList);
        List<String> result = new ArrayList<>();
        char[] s = temp.toCharArray();
        for (int i = 0; i <= s.length - 1; i++) {
            char origin = s[i];
            for (char c = 'a'; c <= 'z'; c++) {
                s[i] = c;
                String newS = new String(s);
                if (dict.contains(newS)) {
                    result.add(newS);
                }
            }
            s[i] = origin;
        }
        return result;
    }
    public static void main(String[] args) {
        WordLadder2 sol = new WordLadder2();
        String beginWord, endWord;
        String[] dict;
        List<String> wordList;
        List<List<String>> res; 
        
        beginWord = "hit";
        endWord = "cog";
        dict = new String[]{"hot","dot","dog","lot","log","cog"};
        wordList = Arrays.asList(dict);
        res = sol.wordLadder(wordList, beginWord, endWord);
        System.out.println("[Begin , End] : " + beginWord + " , " + endWord);
        System.out.println("Word Lists : " + Arrays.toString(dict));
        System.out.println("Output : " + Arrays.deepToString(res.toArray()));
    }
}
