// Last updated: 24/10/2025, 22:20:37
class Solution {
    public int nextBeautifulNumber(int n) {
        java.util.List<Integer> list = new java.util.ArrayList<>();
        int[] cnt = new int[10];
        choose(1, 0, cnt, list);
        java.util.Collections.sort(list);
        int l = 0, r = list.size() - 1, ans = list.get(r);
        while (l <= r) {
            int m = (l + r) >>> 1;
            int v = list.get(m);
            if (v > n) {
                ans = v;
                r = m - 1;
            } else {
                l = m + 1;
            }
        }
        return ans;
    }

    private void choose(int d, int sum, int[] cnt, java.util.List<Integer> out) {
        if (sum > 7) return;
        if (d == 8) {
            if (sum > 0) build(cnt, sum, 0, out);
            return;
        }
        choose(d + 1, sum, cnt, out);
        cnt[d] += d;
        choose(d + 1, sum + d, cnt, out);
        cnt[d] -= d;
    }

    private void build(int[] cnt, int remaining, int num, java.util.List<Integer> out) {
        if (remaining == 0) {
            out.add(num);
            return;
        }
        for (int d = 1; d <= 7; d++) {
            if (cnt[d] > 0) {
                cnt[d]--;
                build(cnt, remaining - 1, num * 10 + d, out);
                cnt[d]++;
            }
        }
    }
}
