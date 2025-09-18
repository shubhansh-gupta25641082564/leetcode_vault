// Last updated: 18/09/2025, 23:30:20
import java.util.*;

public class Solution {
    public boolean wordBreak(String s, List<String> wordDict) {
        int n = s.length();
        boolean[] dp = new boolean[n + 1];
        dp[0] = true;
        // optional: put words in a HashSet for O(1) contains checks
        Set<String> set = new HashSet<>(wordDict);
        // optional: compute max word length to limit inner loop
        int maxLen = 0;
        for (String w : wordDict) maxLen = Math.max(maxLen, w.length());

        for (int i = 1; i <= n; i++) {
            // try previous cut position j where j >= i - maxLen
            for (int j = Math.max(0, i - maxLen); j < i; j++) {
                if (dp[j] && set.contains(s.substring(j, i))) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[n];
    }
}
