class LFUCache {
    HashMap<Integer, Integer> vals;
    HashMap<Integer, Integer> counts;
    HashMap<Integer, LinkedHashSet<Integer>> lists;
    int cap;
    int min;
    
    public LFUCache(int capacity) {
        vals = new HashMap<>();
        counts = new HashMap<>();
        lists = new HashMap<>();
        cap = capacity;
        min = 0;
    }
    
    public int get(int key) {
        if(!vals.containsKey(key))
            return -1;
        
        update(key);
        return vals.get(key);
    }
    
    private void update (int key) {
        int cnt = counts.get(key);
        counts.put(key, cnt + 1);
        lists.get(cnt).remove(key);
        
        if(cnt == min && lists.get(cnt).size() == 0)
            min++;
        
        addToList(cnt + 1, key);
    }
    
    private void addToList(int cnt, int key) {
        if(!lists.containsKey(cnt))
            lists.put(cnt, new LinkedHashSet<>());
        
        lists.get(cnt).add(key);
    }
    
    private void evict () {
        int key = lists.get(min).iterator().next(); 
        lists.get(min).remove(key);
        vals.remove(key);
        counts.remove(key);
    }
    
    public void put(int key, int value) {
        if (cap <= 0)
            return;
        
        if (vals.containsKey(key)) {
            vals.put(key, value);
            update(key);
            return;
        } 
        
        if (vals.size() >= cap) 
            evict();
        
        vals.put(key, value);
        counts.put(key, 1);
        addToList(1, key);
        min = 1;
    }
}

/**
 * Your LFUCache object will be instantiated and called as such:
 * LFUCache obj = new LFUCache(capacity);
 * int param_1 = obj.get(key);
 * obj.put(key,value);
 */