// Last updated: 22/09/2025, 16:13:28
class Solution {
    public long zeroFilledSubarray(int[] nums) {
        long res = 0, run = 0;
        for (int x : nums) {
            if (x == 0) run++;
            else { res += run * (run + 1) / 2; run = 0; }
        }
        if (run > 0) res += run * (run + 1) / 2;
        return res;
    }
}
