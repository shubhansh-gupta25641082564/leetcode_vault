// Last updated: 18/09/2025, 23:16:04
public class Solution {
    public int minCut(String s) {
        int n = s.length();
        if (n <= 1) return 0;

        // pal[i][j] = true if s[i..j] is a palindrome
        boolean[][] pal = new boolean[n][n];
        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                pal[i][j] = (s.charAt(i) == s.charAt(j)) && (j - i < 2 || pal[i + 1][j - 1]);
            }
        }

        // cuts[i] = minimum cuts needed for substring s[0..i]
        int[] cuts = new int[n];
        for (int i = 0; i < n; i++) {
            if (pal[0][i]) {
                cuts[i] = 0; // no cut needed if s[0..i] is palindrome
            } else {
                int min = Integer.MAX_VALUE;
                for (int j = 0; j < i; j++) {
                    if (pal[j + 1][i]) {
                        min = Math.min(min, cuts[j] + 1);
                    }
                }
                cuts[i] = min;
            }
        }
        return cuts[n - 1];
    }
}
