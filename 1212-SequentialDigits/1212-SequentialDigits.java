// Last updated: 01/10/2025, 22:23:20
import java.util.*;

class Solution {
    public List<Integer> sequentialDigits(int low, int high) {
        List<Integer> result = new ArrayList<>();
        String digits = "123456789";
        
        int lowLen = String.valueOf(low).length();
        int highLen = String.valueOf(high).length();
        
        for (int len = lowLen; len <= highLen; len++) {
            for (int start = 0; start <= 9 - len; start++) {
                int num = Integer.parseInt(digits.substring(start, start + len));
                if (num >= low && num <= high) {
                    result.add(num);
                }
            }
        }
        
        return result;
    }
}
