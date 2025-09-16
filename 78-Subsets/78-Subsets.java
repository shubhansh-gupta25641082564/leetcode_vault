// Last updated: 16/09/2025, 23:03:50
class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1.length() != s2.length()) return false;
        return dfs(s1, s2, new java.util.HashMap<>());
    }
    private boolean dfs(String a, String b, java.util.Map<String, Boolean> memo) {
        String key = a + "#" + b;
        if (memo.containsKey(key)) return memo.get(key);
        if (a.equals(b)) {
            memo.put(key, true);
            return true;
        }
        int n = a.length();
        int[] cnt = new int[26];
        for (int i = 0; i < n; i++) {
            cnt[a.charAt(i) - 'a']++;
            cnt[b.charAt(i) - 'a']--;
        }
        for (int v : cnt) if (v != 0) {
            memo.put(key, false);
            return false;
        }
        for (int i = 1; i < n; i++) {
            if (dfs(a.substring(0, i), b.substring(0, i), memo) && dfs(a.substring(i), b.substring(i), memo)) {
                memo.put(key, true);
                return true;
            }
            if (dfs(a.substring(0, i), b.substring(n - i), memo) && dfs(a.substring(i), b.substring(0, n - i), memo)) {
                memo.put(key, true);
                return true;
            }
        }
        memo.put(key, false);
        return false;
    }
}
