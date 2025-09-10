// Last updated: 10/09/2025, 15:08:00
class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s.isEmpty()) return false;

        boolean seenDigit = false;
        boolean seenDot = false;
        boolean seenExp = false;
        boolean seenDigitAfterExp = true;  // will reset to false once we see 'e'/'E'

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);

            if (Character.isDigit(c)) {
                seenDigit = true;
                if (seenExp) {
                    seenDigitAfterExp = true;
                }

            } else if (c == '+' || c == '-') {
                // sign is only valid at the very start or immediately after an exponent
                if (i != 0 && !(i > 0 && (s.charAt(i - 1) == 'e' || s.charAt(i - 1) == 'E'))) {
                    return false;
                }

            } else if (c == '.') {
                // dot is not allowed if we've already seen a dot or an exponent
                if (seenDot || seenExp) {
                    return false;
                }
                seenDot = true;

            } else if (c == 'e' || c == 'E') {
                // exponent is not allowed if we've already seen one, 
                // and there must be at least one digit before it
                if (seenExp || !seenDigit) {
                    return false;
                }
                seenExp = true;
                // reset this to ensure there's a digit after the exponent
                seenDigitAfterExp = false;

            } else {
                // any other character is invalid
                return false;
            }
        }

        // at the end, we need at least one digit before and (if exponent used) one digit after
        return seenDigit && seenDigitAfterExp;
    }
}