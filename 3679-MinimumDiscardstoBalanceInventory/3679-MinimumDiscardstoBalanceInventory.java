// Last updated: 15/09/2025, 21:51:19
class Solution {
    public int minArrivalsToDiscard(int[] arrivals, int w, int m) {
        int n = arrivals.length;
        int maxType = 0;
        for (int v : arrivals) if (v > maxType) maxType = v;
        int[] counts = new int[maxType + 1];
        boolean[] kept = new boolean[n];
        int discarded = 0;
        for (int i = 0; i < n; ++i) {
            int outIdx = i - w;
            if (outIdx >= 0 && kept[outIdx]) counts[arrivals[outIdx]]--;
            int t = arrivals[i];
            if (counts[t] < m) {
                kept[i] = true;
                counts[t]++;
            } else {
                kept[i] = false;
                discarded++;
            }
        }
        return discarded;
    }
}
