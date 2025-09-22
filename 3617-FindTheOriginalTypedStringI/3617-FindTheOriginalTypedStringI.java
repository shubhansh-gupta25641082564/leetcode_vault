// Last updated: 22/09/2025, 16:13:07
class Solution {
    public int possibleStringCount(String word) {
        int n = word.length();
        int groups = 1;
        for (int i = 1; i < n; i++) if (word.charAt(i) != word.charAt(i - 1)) groups++;
        return n - groups + 1;
    }
}
