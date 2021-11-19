public class TimeMap {
    public Map<String, List<Node>> map;
    
    public class Node {
        String value;
        int timeStamp;
        Node(String value, int timeStamp) {
            this.value = value;
            this.timeStamp = timeStamp;
        }
    }
    
    public TimeMap() {
        this.map = new HashMap<>();    
    }
    
    public void set(String key, String value, int timestamp) {
        Node newNode = new Node(value, timestamp);
        if (!map.containsKey(key)) {
            map.put(key, new ArrayList<Node>());
        }
        map.get(key).add(newNode);
    }
    
    public String get(String key, int timestamp) {
        if (!map.containsKey(key)) {
            return "";
        }
        List<Node> tmp = map.get(key);
        int index = binarySearch(tmp, timestamp);
        //System.out.println(index);
        if (index == -1) {
            return "";
        }
        String res = tmp.get(index).value;
        return res != null ?  res : "";
    }
    
    public int binarySearch(List<Node> tmp, int timestamp) { // biggest smaller
        if (tmp.get(0).timeStamp > timestamp) {
            return -1;
        }
        int left = 0;
        int right = tmp.size() - 1;
        int mid;
        while (left < right - 1) {
            mid = left + (right - left) / 2;
            if (tmp.get(mid).timeStamp == timestamp) {
                return mid;
            } else if (tmp.get(mid).timeStamp < timestamp) {
                left = mid;
            } else {
                right = mid;
            }
        }
        if (tmp.get(right).timeStamp <= timestamp) {
            return right;
        } else {
            return left;
        }
        //return -1;
    }    
}
/*abstract

Design a time-based key-value data structure that can store multiple values for the same key at different time stamps and retrieve the key's value at a certain timestamp.

Implement the TimeMap class:

TimeMap() Initializes the object of the data structure.
void set(String key, String value, int timestamp) Stores the key key with the value value at the given time timestamp.
String get(String key, int timestamp) Returns a value such that set was called previously, with timestamp_prev <= timestamp. If there are multiple such values, it returns the value associated with the largest timestamp_prev. If there are no values, it returns "".
 


Example 1:

Input
["TimeMap", "set", "get", "get", "set", "get", "get"]
[[], ["foo", "bar", 1], ["foo", 1], ["foo", 3], ["foo", "bar2", 4], ["foo", 4], ["foo", 5]]
Output
[null, null, "bar", "bar", null, "bar2", "bar2"]

Explanation
TimeMap timeMap = new TimeMap();
timeMap.set("foo", "bar", 1);  // store the key "foo" and value "bar" along with timestamp = 1.
timeMap.get("foo", 1);         // return "bar"
timeMap.get("foo", 3);         // return "bar", since there is no value corresponding to foo at timestamp 3 and timestamp 2, then the only value is at timestamp 1 is "bar".
timeMap.set("foo", "bar2", 4); // store the key "foo" and value "ba2r" along with timestamp = 4.
timeMap.get("foo", 4);         // return "bar2"
timeMap.get("foo", 5);         // return "bar2"

*/