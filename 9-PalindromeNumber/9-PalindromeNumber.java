// Last updated: 10/09/2025, 15:09:07
class Solution {
    public boolean isPalindrome(int x) {
        // Edge cases: negative numbers and numbers ending in zero (but not zero itself)
        if (x < 0 || (x % 10 == 0 && x != 0)) {
            return false;
        }

        int reversedHalf = 0;
        // Reverse the second half of the number and compare it with the first half
        while (x > reversedHalf) {
            reversedHalf = reversedHalf * 10 + x % 10;
            x /= 10;
        }

        // Check if the original first half equals the reversed second half
        // or if ignoring the middle digit (in case of odd length) results in equality
        return x == reversedHalf || x == reversedHalf / 10;
    }
}