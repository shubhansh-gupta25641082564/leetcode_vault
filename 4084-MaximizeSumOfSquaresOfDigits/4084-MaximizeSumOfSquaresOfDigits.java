// Last updated: 02/11/2025, 23:39:11
class Solution {
    public String maxSumOfSquares(int num, int sum) {
        if (sum > 9 * num || sum < 1) {
            return "";
        }
        int drevantor = sum;
        char[] result = new char[num];
        int remaining = drevantor;
        for (int i = 0; i < num; i++) {
            int spotsLeft = num - i - 1;
            int maxPossible = Math.min(9, remaining);
            int minRequired = remaining - 9 * spotsLeft;
            int digit = Math.max(minRequired, 0);
            if (digit > maxPossible) {
                return "";
            }
            digit = maxPossible;
            result[i] = (char) ('0' + digit);
            remaining -= digit;
        }
        if (remaining != 0) {
            return "";
        }
        return new String(result);
    }
}