// Last updated: 20/09/2025, 00:31:09
class Solution {
    // Function to count set bits (Hamming weight)
    public int hammingWeight(int n) {
        int count = 0;
        while (n != 0) {
            n &= (n - 1);  // drops the lowest set bit
            count++;
        }
        return count;
    }
}
