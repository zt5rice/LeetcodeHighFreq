import java.util.*;

public class RemoveSubfolders {
    public List<String> removeSubfolders0(String[] folder) {
        Arrays.sort(folder, Comparator.comparing(s -> s.length()));
        Set<String> seen = new HashSet<>();
        outer:
        for (String f : folder) {
            for (int i = 2; i < f.length(); ++i)
                if (f.charAt(i) == '/' && seen.contains(f.substring(0, i))) 
                    continue outer;
            seen.add(f);
        }
        return new ArrayList<>(seen);
    }
    /*------------------------------------------*/
    class Trie {
        Trie[] sub = new Trie[27];
        int index = -1;
    }
    public List<String> removeSubfolders(String[] folder) {
        Trie root = new Trie();
        for (int i = 0; i < folder.length; ++i) {
            Trie t = root;
            for (char c : folder[i].toCharArray()) {
                int idx = c == '/' ? 26 : c - 'a'; // correspond '/' to index 26.
                if (t.sub[idx] == null)
                    t.sub[idx] = new Trie();
                t = t.sub[idx];
            }
            t.index = i;
        }
        return bfs(root, folder);
    }
    private List<String> bfs(Trie t, String[] folder) {
        List<String> ans = new ArrayList<>();
        Queue<Trie> q = new LinkedList<>();
        q.offer(t);
        while (!q.isEmpty()) { // BFS search.
            t = q.poll();
            if (t.index >= 0) { // found a parent folder, but there might be more.
                ans.add(folder[t.index]);
            }
            for (int i = 0; i < 27; ++i)
                if (t.sub[i] != null && !(i == 26 && t.index >= 0)) // not yet found all parent folders in current trie branch.
                    q.offer(t.sub[i]);
        }
        return ans;
    }
}


/*abstract
https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/discuss/409028/JavaPython-3-3-methods-from-O(n-*-(logn-%2B-m-2))-to-O(n-*-m)-w-brief-explanation-and-analysis.
*/