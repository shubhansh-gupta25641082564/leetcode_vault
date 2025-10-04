// Last updated: 05/10/2025, 00:08:22
class Solution {
    public char kthCharacter(long k, int[] operations) {
        int n = operations.length;
        // len[i] = length of word after i operations, capped at k to avoid overflow
        long[] len = new long[n+1];
        len[0] = 1;
        for (int i = 1; i <= n; i++) {
            // Each operation doubles the length
            len[i] = len[i-1] * 2;
            if (len[i] > k) len[i] = k;
        }
        
        // Walk backwards through the operations, tracking how many "+1 shifts" we've
        // passed in the second half of any type‑1 operation.
        int shift = 0;   // total shift to apply to the base 'a'
        int i = n;
        while (i > 0) {
            // If k falls in the second half of the i-th operation
            if (k > len[i-1]) {
                k -= len[i-1];
                // If it was a type‑1 op, this half is the shifted copy
                if (operations[i-1] == 1) {
                    shift = (shift + 1) % 26;
                }
            }
            // Otherwise k remains unchanged and we just move to the previous state
            i--;
        }
        
        // Now i == 0, we’re at the original single-character word "a"
        // Apply the accumulated shift
        return (char)('a' + shift);
    }
}
