// Last updated: 01/10/2025, 22:23:42
class Solution {
    public int threeSumMulti(int[] arr, int target) {
        long mod = 1_000_000_007;
        long[] count = new long[101];
        for (int num : arr) count[num]++;
        long ans = 0;
        for (int i = 0; i <= 100; i++) {
            for (int j = i; j <= 100; j++) {
                int k = target - i - j;
                if (k < 0 || k > 100) continue;
                if (i == j && j == k) {
                    ans += count[i] * (count[i] - 1) * (count[i] - 2) / 6;
                } else if (i == j && j != k) {
                    ans += count[i] * (count[i] - 1) / 2 * count[k];
                } else if (i < j && j < k) {
                    ans += count[i] * count[j] * count[k];
                }
                ans %= mod;
            }
        }
        return (int) ans;
    }
}