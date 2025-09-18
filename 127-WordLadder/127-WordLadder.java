// Last updated: 18/09/2025, 23:30:37
import java.util.*;

public class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) return 0;
        Queue<String> q = new LinkedList<>();
        q.add(beginWord);
        int level = 1;
        int L = beginWord.length();
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                String word = q.poll();
                if (word.equals(endWord)) return level;
                char[] chs = word.toCharArray();
                for (int pos = 0; pos < L; pos++) {
                    char old = chs[pos];
                    for (char c = 'a'; c <= 'z'; c++) {
                        if (c == old) continue;
                        chs[pos] = c;
                        String nxt = new String(chs);
                        if (wordSet.contains(nxt)) {
                            q.add(nxt);
                            wordSet.remove(nxt);
                        }
                    }
                    chs[pos] = old;
                }
            }
            level++;
        }
        return 0;
    }
}
