// Last updated: 21/09/2025, 17:38:47
class Solution {
    public int countDigitOne(int n) {
        long digit = 1, res = 0;
        long high = n / 10, cur = n % 10, low = 0;
        
        while (high != 0 || cur != 0) {
            if (cur == 0) res += high * digit;
            else if (cur == 1) res += high * digit + low + 1;
            else res += (high + 1) * digit;
            
            low += cur * digit;
            cur = (int)(high % 10);
            high /= 10;
            digit *= 10;
        }
        
        return (int)res;
    }
}
