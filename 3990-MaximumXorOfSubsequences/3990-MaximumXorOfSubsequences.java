// Last updated: 15/09/2025, 22:05:05
class Solution {
    public int maxXorSubsequences(int[] nums) {
        int MAXB = 31;
        int[] basis = new int[MAXB];
        for (int x : nums) {
            int v = x;
            for (int b = MAXB - 1; b >= 0 && v != 0; --b) {
                if (((v >> b) & 1) == 0) continue;
                if (basis[b] == 0) { basis[b] = v; break; }
                v ^= basis[b];
            }
        }
        int res = 0;
        for (int b = MAXB - 1; b >= 0; --b) {
            if (basis[b] != 0 && (res ^ basis[b]) > res) res ^= basis[b];
        }
        return res;
    }
}
