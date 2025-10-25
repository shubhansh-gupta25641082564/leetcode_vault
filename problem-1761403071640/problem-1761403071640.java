// Last updated: 25/10/2025, 20:07:51
class Solution {
    public String lexSmallest(String s) {
        int n = s.length();
        String ans = s;
        for (int k = 1; k <= n; k++) {
            StringBuilder a = new StringBuilder(s.substring(0, k)).reverse();
            a.append(s.substring(k));
            if (a.toString().compareTo(ans) < 0) {
                ans = a.toString();
            }
            StringBuilder b = new StringBuilder(s.substring(n - k)).reverse();
            b.insert(0, s.substring(0, n - k));
            if (b.toString().compareTo(ans) < 0) {
                ans = b.toString();
            }
        }
        return ans;
    }
}