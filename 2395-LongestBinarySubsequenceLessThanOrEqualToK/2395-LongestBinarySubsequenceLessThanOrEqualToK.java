// Last updated: 05/10/2025, 00:08:36
class Solution {
    public int longestSubsequence(String s, int k) {
        int ans = 0;
        int value = 0;
        int n = s.length();
        
        // scan from LSB side (right) to MSB side (left)
        for (int i = n - 1; i >= 0; i--) {
            char c = s.charAt(i);
            if (c == '0') {
                // zero always safe: it just uses up a bit without changing value
                ans++;
            } else {
                // only if by setting this bit we stay ≤ k
                // bit-position is ans (0-based)
                if (ans < 31 && (value | (1 << ans)) <= k) {
                    value |= (1 << ans);
                    ans++;
                }
            }
        }
        
        return ans;
    }
}
