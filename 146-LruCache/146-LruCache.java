// Last updated: 18/09/2025, 23:30:10
import java.util.*;

public class LRUCache {
    private final int capacity;
    private final Map<Integer, Node> map;
    private final Node head; // dummy head
    private final Node tail; // dummy tail

    private static class Node {
        int key;
        int val;
        Node prev;
        Node next;
        Node(int k, int v) { key = k; val = v; }
    }

    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.map = new HashMap<>();
        head = new Node(-1, -1);
        tail = new Node(-1, -1);
        head.next = tail;
        tail.prev = head;
    }

    public int get(int key) {
        Node node = map.get(key);
        if (node == null) return -1;
        // move accessed node to front (most recently used)
        remove(node);
        addFirst(node);
        return node.val;
    }

    public void put(int key, int value) {
        Node node = map.get(key);
        if (node != null) {
            // update value and move to front
            node.val = value;
            remove(node);
            addFirst(node);
        } else {
            // insert new node
            Node newNode = new Node(key, value);
            map.put(key, newNode);
            addFirst(newNode);
            if (map.size() > capacity) {
                // evict least recently used (tail.prev)
                Node lru = tail.prev;
                remove(lru);
                map.remove(lru.key);
            }
        }
    }

    // helper: insert node right after head
    private void addFirst(Node node) {
        node.next = head.next;
        node.prev = head;
        head.next.prev = node;
        head.next = node;
    }

    // helper: unlink node from list
    private void remove(Node node) {
        node.prev.next = node.next;
        node.next.prev = node.prev;
        node.prev = null;
        node.next = null;
    }
}
