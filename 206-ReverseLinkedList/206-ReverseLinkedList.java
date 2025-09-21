// Last updated: 21/09/2025, 16:55:00
class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() <= 1) return s;
        String rev = new StringBuilder(s).reverse().toString();
        String comb = s + "#" + rev;
        int m = comb.length();
        int[] pi = new int[m];
        for (int i = 1; i < m; ++i) {
            int j = pi[i - 1];
            char c = comb.charAt(i);
            while (j > 0 && comb.charAt(j) != c) j = pi[j - 1];
            if (comb.charAt(j) == c) j++;
            pi[i] = j;
        }
        int palPrefLen = pi[m - 1];
        String suffix = s.substring(palPrefLen);
        String add = new StringBuilder(suffix).reverse().toString();
        return add + s;
    }
}
