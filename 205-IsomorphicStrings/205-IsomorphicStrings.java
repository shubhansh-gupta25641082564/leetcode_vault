// Last updated: 21/09/2025, 16:43:16
import java.util.*;

class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) return false;
        int[] ms = new int[256];
        int[] mt = new int[256];
        Arrays.fill(ms, -1);
        Arrays.fill(mt, -1);
        for (int i = 0; i < s.length(); ++i) {
            int a = s.charAt(i);
            int b = t.charAt(i);
            if (ms[a] == -1 && mt[b] == -1) {
                ms[a] = b;
                mt[b] = a;
            } else if (ms[a] != b || mt[b] != a) {
                return false;
            }
        }
        return true;
    }
}
