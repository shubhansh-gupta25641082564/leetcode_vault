// Last updated: 05/10/2025, 00:08:42
class Solution {
    // “nextPos[i][c]” = the smallest index ≥ i where s.charAt(index)==c, or n if none
    private int[][] nextPos;
    private List<Character> validChars;
    private int k, n;
    private String best;

    public String longestSubsequenceRepeatedK(String s, int k) {
        this.k = k;
        this.n = s.length();
        buildNextTable(s);
        collectValidChars(s);
        best = "";
        dfs(new StringBuilder(), s);
        return best;
    }

    // Build nextPos table in O(n·26)
    private void buildNextTable(String s) {
        nextPos = new int[n + 1][26];
        // initialize row n to “no occurrence”
        for (int c = 0; c < 26; c++) nextPos[n][c] = n;
        // fill backwards
        for (int i = n - 1; i >= 0; i--) {
            for (int c = 0; c < 26; c++) {
                nextPos[i][c] = nextPos[i + 1][c];
            }
            nextPos[i][s.charAt(i) - 'a'] = i;
        }
    }

    // Only characters with freq ≥ k can appear in our answer; sort them descending
    private void collectValidChars(String s) {
        int[] freq = new int[26];
        for (char ch : s.toCharArray()) freq[ch - 'a']++;
        validChars = new ArrayList<>();
        for (int c = 0; c < 26; c++) {
            if (freq[c] >= k) {
                validChars.add((char) ('a' + c));
            }
        }
        // descending so we try lex‐larger first
        validChars.sort(Collections.reverseOrder());
    }

    // DFS: try to append each valid char, check if repeated-k is still subsequence, recurse
    private void dfs(StringBuilder curr, String s) {
        for (char c : validChars) {
            curr.append(c);
            if (isRepeatedKSubseq(curr)) {
                String cand = curr.toString();
                // update best if longer or lex‐larger when equal length
                if (cand.length() > best.length() ||
                   (cand.length() == best.length() && cand.compareTo(best) > 0)) {
                    best = cand;
                }
                dfs(curr, s);
            }
            curr.setLength(curr.length() - 1);
        }
    }

    // Check whether curr^k is a subsequence of s in O(|curr|·k)
    private boolean isRepeatedKSubseq(StringBuilder curr) {
        int idx = 0;  // current position in s
        for (int repeat = 0; repeat < k; repeat++) {
            for (int j = 0; j < curr.length(); j++) {
                int c = curr.charAt(j) - 'a';
                if (nextPos[idx][c] == n) return false;
                idx = nextPos[idx][c] + 1;
            }
        }
        return true;
    }
}
