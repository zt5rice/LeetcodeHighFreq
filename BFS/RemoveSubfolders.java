import java.util.*;

public class RemoveSubfolders {
    class Trie {
        Trie[] next = new Trie[27];
        int index = -1;
    }
    public List<String> removeSubfolders(String[] folder) {
        //List<String> res = new ArrayList<>();
        Trie root = new Trie();
        for (int i = 0; i < folder.length; i++) {
            String str = folder[i];
            Trie t = root;
            for (char c : str.toCharArray()) {
                int idx = c == '/' ? 26 : c - 'a';
                if (t.next[idx] == null) {
                    t.next[idx] = new Trie();
                }
                t = t.next[idx];
            }
            t.index = i;
        }
        return bfs(root, folder);
    }
    public List<String> bfs(Trie t, String[] folder) {
        List<String> res = new ArrayList<>();
        Queue<Trie> q = new ArrayDeque<>();
        q.offer(t);
        while(!q.isEmpty()) {
            t = q.poll();
            if (t.index >= 0) {
                res.add(folder[t.index]);
            }
            for (int i = 0; i < 27; i++) {
                if (t.next[i] != null && !(i == 26 && t.index >= 0)) {
                    q.offer(t.next[i]);
                }
            }  
        } 
        return res;
    }    
    //     private List<String> bfs(Trie t, String[] folder) {
    //     List<String> ans = new ArrayList<>();
    //     Queue<Trie> q = new LinkedList<>();
    //     q.offer(t);
    //     while (!q.isEmpty()) { // BFS search.
    //         t = q.poll();
    //         if (t.index >= 0) { // found a parent folder, but there might be more.
    //             ans.add(folder[t.index]);
    //         }
    //         for (int i = 0; i < 27; ++i)
    //             if (t.next[i] != null && !(i == 26 && t.index >= 0)) // not yet found all parent folders in current trie branch.
    //                 q.offer(t.next[i]);
    //     }
    //     return ans;
    // }
}
