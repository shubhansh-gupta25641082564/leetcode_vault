// Last updated: 22/09/2025, 16:13:31
class Solution {
    public String largestGoodInteger(String num) {
        int n = num.length();
        int maxDigit = -1; // -1 means none found yet
        
        for (int i = 0; i <= n - 3; i++) {
            char a = num.charAt(i);
            char b = num.charAt(i + 1);
            char c = num.charAt(i + 2);
            if (a == b && b == c) {
                int d = a - '0';
                if (d > maxDigit) maxDigit = d;
            }
        }
        
        if (maxDigit == -1) return "";
        char ch = (char) (maxDigit + '0');
        return "" + ch + ch + ch;
    }
}
