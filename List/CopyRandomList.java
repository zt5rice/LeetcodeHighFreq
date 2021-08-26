import java.util.HashMap;
import java.util.Map;

public class CopyRandomList {
    Map<Node, Node> copied = new HashMap<>();
    
    public Node copyRandomList(Node head) {
        if (head == null) {
            return null;
        }
        if (this.copied.containsKey(head)) {
            return this.copied.get(head); // why return null?
        }    
        Node newNode = new Node(head.val);
        copied.put(head, newNode);
        newNode.next = copyRandomList(head.next);
        newNode.random = copyRandomList(head.random);
        return newNode;
    }
}
