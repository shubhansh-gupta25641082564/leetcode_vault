// Last updated: 21/09/2025, 16:53:05
import java.util.*;

class Solution {
    private static class TrieNode {
        TrieNode[] next = new TrieNode[26];
        String word = null;
    }

    public List<String> findWords(char[][] board, String[] words) {
        TrieNode root = buildTrie(words);
        List<String> res = new ArrayList<>();
        int m = board.length, n = board[0].length;
        for (int i = 0; i < m; ++i) {
            for (int j = 0; j < n; ++j) {
                dfs(board, i, j, root, res);
            }
        }
        return res;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();
        for (String w : words) {
            TrieNode cur = root;
            for (int i = 0; i < w.length(); ++i) {
                int c = w.charAt(i) - 'a';
                if (cur.next[c] == null) cur.next[c] = new TrieNode();
                cur = cur.next[c];
            }
            cur.word = w;
        }
        return root;
    }

    private void dfs(char[][] board, int i, int j, TrieNode node, List<String> res) {
        int m = board.length, n = board[0].length;
        if (i < 0 || i >= m || j < 0 || j >= n) return;
        char ch = board[i][j];
        if (ch == '#') return;
        TrieNode child = node.next[ch - 'a'];
        if (child == null) return;

        if (child.word != null) {
            res.add(child.word);
            child.word = null;
        }

        board[i][j] = '#';
        dfs(board, i + 1, j, child, res);
        dfs(board, i - 1, j, child, res);
        dfs(board, i, j + 1, child, res);
        dfs(board, i, j - 1, child, res);
        board[i][j] = ch;

        if (isEmpty(child)) {
            node.next[ch - 'a'] = null;
        }
    }

    private boolean isEmpty(TrieNode node) {
        if (node == null) return true;
        if (node.word != null) return false;
        for (TrieNode t : node.next) if (t != null) return false;
        return true;
    }
}
