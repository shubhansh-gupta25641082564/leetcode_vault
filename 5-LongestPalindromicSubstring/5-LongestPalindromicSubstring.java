// Last updated: 10/09/2025, 15:09:13
class Solution {
    public String longestPalindrome(String s) {
        int n = s.length();
        if (n < 2) return s;        // a single char or empty string is itself

        int bestL = 0, bestR = 0;   // endpoints (inclusive) of best palindrome

        for (int i = 0; i < n; i++) {
            // odd-length centered at i
            int[] odd = expand(s, i, i);
            // even-length centered between i and i+1
            int[] even = expand(s, i, i + 1);

            // choose the longer of odd vs even
            int[] longer = (odd[1] - odd[0] > even[1] - even[0]) ? odd : even;
            if (longer[1] - longer[0] > bestR - bestL) {
                bestL = longer[0];
                bestR = longer[1];
            }
        }

        // substring(endIndex is exclusive, so +1)
        return s.substring(bestL, bestR + 1);
    }

    // Expand around [L..R] as long as s.charAt(L)==s.charAt(R)
    // Returns the final [L',R'] inclusive bounds of the palindrome
    private int[] expand(String s, int L, int R) {
        int n = s.length();
        while (L >= 0 && R < n && s.charAt(L) == s.charAt(R)) {
            L--;
            R++;
        }
        // when the loop breaks, L and R have gone one step too far
        return new int[]{ L + 1, R - 1 };
    }
}