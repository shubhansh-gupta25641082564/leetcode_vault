// Last updated: 18/09/2025, 23:21:09
import java.util.*;

public class Solution {
    public List<String> wordBreak(String s, List<String> wordDict) {
        Set<String> dict = new HashSet<>(wordDict);
        int maxLen = 0;
        for (String w : wordDict) maxLen = Math.max(maxLen, w.length());
        return dfs(s, 0, dict, maxLen, new HashMap<>());
    }

    // returns list of sentences that can be formed from s[start..end]
    private List<String> dfs(String s, int start, Set<String> dict, int maxLen, Map<Integer, List<String>> memo) {
        if (memo.containsKey(start)) return memo.get(start);

        List<String> res = new ArrayList<>();
        int n = s.length();
        if (start == n) {
            res.add(""); // empty sentence for successful decomposition
            memo.put(start, res);
            return res;
        }

        // try all end positions up to maxLen
        for (int end = start + 1; end <= Math.min(n, start + maxLen); end++) {
            String word = s.substring(start, end);
            if (!dict.contains(word)) continue;
            List<String> suffixes = dfs(s, end, dict, maxLen, memo);
            for (String suff : suffixes) {
                if (suff.isEmpty()) res.add(word);
                else res.add(word + " " + suff);
            }
        }

        memo.put(start, res);
        return res;
    }
}
