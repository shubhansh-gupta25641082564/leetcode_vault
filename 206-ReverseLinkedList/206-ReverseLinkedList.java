// Last updated: 21/09/2025, 16:46:41
class Trie {
    private static class Node {
        Node[] next = new Node[26];
        boolean end;
    }
    private final Node root;
    public Trie() {
        root = new Node();
    }
    public void insert(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); ++i) {
            int c = word.charAt(i) - 'a';
            if (cur.next[c] == null) cur.next[c] = new Node();
            cur = cur.next[c];
        }
        cur.end = true;
    }
    public boolean search(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); ++i) {
            int c = word.charAt(i) - 'a';
            if (cur.next[c] == null) return false;
            cur = cur.next[c];
        }
        return cur.end;
    }
    public boolean startsWith(String prefix) {
        Node cur = root;
        for (int i = 0; i < prefix.length(); ++i) {
            int c = prefix.charAt(i) - 'a';
            if (cur.next[c] == null) return false;
            cur = cur.next[c];
        }
        return true;
    }
}
