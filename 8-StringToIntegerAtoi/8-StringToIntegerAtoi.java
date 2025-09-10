// Last updated: 10/09/2025, 15:09:09
class Solution {
    public int myAtoi(String s) {
        int i = 0, n = s.length();
        // 1) Skip leading whitespace
        while (i < n && s.charAt(i) == ' ') {
            i++;
        }
        // 2) Check sign
        int sign = 1;
        if (i < n) {
            char c = s.charAt(i);
            if (c == '-') {
                sign = -1;
                i++;
            } else if (c == '+') {
                i++;
            }
        }
        // 3) Parse digits
        long result = 0;  // use long to detect overflow
        while (i < n) {
            char c = s.charAt(i);
            if (c < '0' || c > '9') {
                break;
            }
            int digit = c - '0';
            result = result * 10 + digit;
            // 4) Clamp if outside 32-bit signed range
            if (sign == 1 && result > Integer.MAX_VALUE) {
                return Integer.MAX_VALUE;
            }
            if (sign == -1 && -result < Integer.MIN_VALUE) {
                return Integer.MIN_VALUE;
            }
            i++;
        }
        return (int)(sign * result);
    }
}