// Last updated: 22/10/2025, 19:22:28
class Solution {
    public int longestSubsequence(int[] nums) {
        int n = nums.length;
        int totalXor = 0;
        boolean hasNonZero = false;
        for (int x : nums) {
            totalXor ^= x;         // XOR accumulate
            if (x != 0) hasNonZero = true;
        }
        if (!hasNonZero) return 0; // all zeros -> no non-zero XOR subsequence
        return totalXor != 0 ? n : n - 1; // if total XOR non-zero use all, else drop one non-zero
    }
}
