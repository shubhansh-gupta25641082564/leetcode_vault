// Last updated: 20/09/2025, 00:31:25
import java.util.*;

class Solution {
    public String fractionToDecimal(int numerator, int denominator) {
        if (numerator == 0) return "0";
        StringBuilder sb = new StringBuilder();

        // handle sign
        boolean negative = (numerator < 0) ^ (denominator < 0);
        if (negative) sb.append('-');

        // use long to avoid overflow when taking abs of Integer.MIN_VALUE
        long num = Math.abs((long) numerator);
        long den = Math.abs((long) denominator);

        // integer part
        long integerPart = num / den;
        sb.append(integerPart);

        long remainder = num % den;
        if (remainder == 0) {
            return sb.toString();
        }

        sb.append('.');

        // map remainder -> position in sb where the digit for that remainder was placed
        Map<Long, Integer> remPos = new HashMap<>();
        while (remainder != 0) {
            if (remPos.containsKey(remainder)) {
                // repeating part found
                int pos = remPos.get(remainder);
                sb.insert(pos, '(');
                sb.append(')');
                break;
            }
            remPos.put(remainder, sb.length());
            remainder *= 10;
            long digit = remainder / den;
            sb.append(digit);
            remainder = remainder % den;
        }

        return sb.toString();
    }
}
