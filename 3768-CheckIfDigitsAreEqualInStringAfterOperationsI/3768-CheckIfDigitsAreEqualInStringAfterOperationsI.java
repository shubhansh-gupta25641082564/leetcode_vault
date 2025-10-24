// Last updated: 24/10/2025, 22:21:18
class Solution {
    public boolean hasSameDigits(String s) {
        while (s.length() != 2) {
            String append = "";
            for (int i = 0; i < s.length() - 1; i ++) {
                int ans = ((int) s.charAt(i) + (int) s.charAt(i + 1)) % 10;
                append += ans;
            }
            s = append;
        }
        return s.charAt(0) == s.charAt(1);
    }
}