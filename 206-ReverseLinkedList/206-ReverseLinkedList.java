// Last updated: 21/09/2025, 16:49:51
class WordDictionary {
    private static class Node {
        Node[] next = new Node[26];
        boolean end;
    }
    private final Node root;
    public WordDictionary() {
        root = new Node();
    }
    public void addWord(String word) {
        Node cur = root;
        for (int i = 0; i < word.length(); ++i) {
            int c = word.charAt(i) - 'a';
            if (cur.next[c] == null) cur.next[c] = new Node();
            cur = cur.next[c];
        }
        cur.end = true;
    }
    public boolean search(String word) {
        return dfs(root, word, 0);
    }
    private boolean dfs(Node node, String word, int idx) {
        if (node == null) return false;
        if (idx == word.length()) return node.end;
        char ch = word.charAt(idx);
        if (ch == '.') {
            for (int i = 0; i < 26; ++i) {
                if (node.next[i] != null && dfs(node.next[i], word, idx + 1)) return true;
            }
            return false;
        } else {
            return dfs(node.next[ch - 'a'], word, idx + 1);
        }
    }
}
