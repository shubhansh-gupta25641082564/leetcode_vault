// Last updated: 20/09/2025, 00:31:10
class Solution {
    // Reverse bits of a 32-bit unsigned integer
    public int reverseBits(int n) {
        int result = 0;
        for (int i = 0; i < 32; i++) {
            result <<= 1;          // shift result left to make room
            result |= (n & 1);     // copy the least significant bit of n
            n >>= 1;               // shift n right to process next bit
        }
        return result;
    }
}
