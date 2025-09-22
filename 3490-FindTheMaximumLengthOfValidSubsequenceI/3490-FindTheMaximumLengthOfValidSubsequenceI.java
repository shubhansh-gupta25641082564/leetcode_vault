// Last updated: 22/09/2025, 16:13:12
class Solution {
    public int maximumLength(int[] nums) {
        int even = 0, odd = 0;
        for (int v : nums) {
            if ((v & 1) == 0) even++;
            else odd++;
        }
        int ans = Math.max(even, odd);
        int alt0 = 0, expect = 0;
        for (int v : nums) {
            if ((v & 1) == expect) {
                alt0++;
                expect ^= 1;
            }
        }
        int alt1 = 0;
        expect = 1;
        for (int v : nums) {
            if ((v & 1) == expect) {
                alt1++;
                expect ^= 1;
            }
        }
        ans = Math.max(ans, Math.max(alt0, alt1));
        return ans;
    }
}
