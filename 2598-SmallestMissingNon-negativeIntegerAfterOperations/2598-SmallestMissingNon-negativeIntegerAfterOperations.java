// Last updated: 16/10/2025, 23:04:04
class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int m = value;
        int[] cnt = new int[m];
        for (int x : nums) {
            int r = x % m;
            if (r < 0) r += m;
            cnt[r]++;
        }
        int i = 0;
        while (true) {
            int r = i % m;
            if (cnt[r] == 0) return i;
            cnt[r]--;
            i++;
        }
    }
}
