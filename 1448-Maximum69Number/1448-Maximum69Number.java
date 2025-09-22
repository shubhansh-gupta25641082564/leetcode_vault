// Last updated: 22/09/2025, 23:01:31
class Solution {
    public int maximum69Number (int num) {
        char[] digits = String.valueOf(num).toCharArray();
        for (int i = 0; i < digits.length; i++) {
            if (digits[i] == '6') {
                digits[i] = '9';
                break; // only change one digit
            }
        }
        return Integer.parseInt(new String(digits));
    }
}
