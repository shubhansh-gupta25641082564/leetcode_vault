// Last updated: 16/09/2025, 23:08:59
import java.util.*;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> res = new ArrayList<>();
        backtrack(s, 0, new ArrayList<>(), res);
        return res;
    }
    private void backtrack(String s, int idx, List<String> parts, List<String> res) {
        if (parts.size() == 4) {
            if (idx == s.length()) res.add(String.join(".", parts));
            return;
        }
        int remaining = s.length() - idx;
        int need = 4 - parts.size();
        if (remaining < need || remaining > need * 3) return;
        for (int len = 1; len <= 3 && idx + len <= s.length(); len++) {
            if (len > 1 && s.charAt(idx) == '0') break;
            String seg = s.substring(idx, idx + len);
            if (Integer.parseInt(seg) > 255) continue;
            parts.add(seg);
            backtrack(s, idx + len, parts, res);
            parts.remove(parts.size() - 1);
        }
    }
}
