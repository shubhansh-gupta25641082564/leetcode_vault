// Last updated: 10/09/2025, 15:09:10
class Solution {
    public int reverse(int x) {
        int reversed = 0;

        while (x != 0) {
            int digit = x % 10;
            x = x / 10;

            if (reversed > Integer.MAX_VALUE / 10 || 
                (reversed == Integer.MAX_VALUE / 10 && digit > Integer.MAX_VALUE % 10)) {
                return 0;
            }

            if (reversed < Integer.MIN_VALUE / 10 || 
                (reversed == Integer.MIN_VALUE / 10 && digit < Integer.MIN_VALUE % 10)) {
                return 0;
            }

            reversed = reversed * 10 + digit;
        }

        return reversed;
    }
}