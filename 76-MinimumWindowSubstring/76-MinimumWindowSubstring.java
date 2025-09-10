// Last updated: 10/09/2025, 15:07:45
class Solution {
    public String minWindow(String s, String t) {
        int m = s.length(), n = t.length();
        if (m < n) return "";

        // need[c] = how many more of char c we still need in the window
        int[] need = new int[128];
        for (char c : t.toCharArray()) {
            need[c]++;
        }
        
        int missing = n;      // total chars still missing to cover t
        int left = 0;         // window's left boundary
        int minStart = 0;     // best window's start index
        int minLen = Integer.MAX_VALUE; // best window length
        
        // expand right boundary
        for (int right = 0; right < m; right++) {
            char c = s.charAt(right);
            // if this char is still needed, decrement missing
            if (need[c] > 0) {
                missing--;
            }
            // record that we've seen one more of c
            need[c]--;
            
            // when we've covered all of t (missing == 0), try to shrink
            while (missing == 0) {
                // update best window if smaller
                int windowLen = right - left + 1;
                if (windowLen < minLen) {
                    minLen = windowLen;
                    minStart = left;
                }
                
                // attempt to remove s[left] from the window
                char leftChar = s.charAt(left);
                need[leftChar]++;
                // if after incrementing need[leftChar] it's > 0,
                // it means we now are missing one of that char
                if (need[leftChar] > 0) {
                    missing++;
                }
                left++;
            }
        }
        
        return (minLen == Integer.MAX_VALUE)
            ? ""
            : s.substring(minStart, minStart + minLen);
    }
}