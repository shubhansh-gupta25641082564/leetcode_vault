// Last updated: 22/10/2025, 19:22:30
class Solution {
    public String lexGreaterPermutation(String s, String target) {
        int n = s.length();
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            cnt[s.charAt(i) - 'a']++;
        }
        char[] t = target.toCharArray();
        char[] pref = new char[n];
        int i = 0;
        while (i < n && cnt[t[i] - 'a'] > 0) {
            pref[i] = t[i];
            cnt[t[i] - 'a']--;
            i++;
        }
        int start = i == n ? n - 1 : i;
        for (int j = start; j >= 0; j--) {
            if (j < i) {
                cnt[pref[j] - 'a']++;
            }
            int base = t[j] - 'a';
            int up = -1;
            for (int c = base + 1; c < 26; c++) {
                if (cnt[c] > 0) {
                    up = c;
                    break;
                }
            }
            if (up != -1) {
                StringBuilder sb = new StringBuilder();
                sb.append(pref, 0, j);
                sb.append((char)('a' + up));
                cnt[up]--;
                for (int c = 0; c < 26; c++) {
                    while (cnt[c]-- > 0) {
                        sb.append((char)('a' + c));
                    }
                }
                return sb.toString();
            }
        }
        return "";
    }
}