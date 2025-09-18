// Last updated: 18/09/2025, 23:30:40
public class Solution {
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            while (i < j && !Character.isLetterOrDigit(s.charAt(i))) i++;
            while (i < j && !Character.isLetterOrDigit(s.charAt(j))) j--;
            if (i < j) {
                char a = Character.toLowerCase(s.charAt(i));
                char b = Character.toLowerCase(s.charAt(j));
                if (a != b) return false;
                i++; j--;
            }
        }
        return true;
    }
}
