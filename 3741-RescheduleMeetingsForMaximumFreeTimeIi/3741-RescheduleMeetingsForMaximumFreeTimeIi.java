// Last updated: 05/10/2025, 00:08:16
import java.util.*;

class Solution {
    public int maxFreeTime(int eventTime, int[] startTime, int[] endTime) {
        int n = startTime.length;
        long[] gaps = new long[n+1];
        // gap before first meeting
        gaps[0] = startTime[0];
        // gaps between meetings
        for (int i = 1; i < n; i++) {
            gaps[i] = (long)startTime[i] - endTime[i-1];
        }
        // gap after last meeting
        gaps[n] = (long)eventTime - endTime[n-1];

        long[] dur = new long[n];
        for (int i = 0; i < n; i++) {
            dur[i] = (long)endTime[i] - startTime[i];
        }

        // multiset of gaps
        TreeMap<Long,Integer> gapCounts = new TreeMap<>();
        for (long g : gaps) {
            gapCounts.merge(g, 1, Integer::sum);
        }

        // best free time if we don't move anything
        int ans = gapCounts.lastKey().intValue();

        // helper to remove one copy
        var removeOne = new BiConsumer<Long,TreeMap<Long,Integer>>() {
            public void accept(Long key, TreeMap<Long,Integer> map) {
                int c = map.get(key);
                if (c == 1) map.remove(key);
                else         map.put(key, c - 1);
            }
        };

        // try moving each meeting j
        for (int j = 0; j < n; j++) {
            int idxBefore = (j == 0 ? 0 : j);
            int idxAfter  = (j == n-1 ? n : j+1);
            long gBefore = gaps[idxBefore];
            long gAfter  = gaps[idxAfter];
            long merged  = gBefore + gAfter + dur[j];

            // remove the two old gaps, add merged
            removeOne.accept(gBefore, gapCounts);
            removeOne.accept(gAfter,  gapCounts);
            gapCounts.merge(merged, 1, Integer::sum);

            // pick a gap to re‑insert meeting of length dur[j]
            Long fitKey = gapCounts.ceilingKey(dur[j]);
            if (fitKey == null) fitKey = gapCounts.lastKey();
            long leftover = fitKey - dur[j];

            // compute new max free slot
            long currentMax = gapCounts.lastKey();
            long newMax;
            if (fitKey < currentMax) {
                newMax = currentMax;
            } else {
                // we’re splitting the largest-gap bucket
                int cnt = gapCounts.get(fitKey);
                long secondLargest;
                if (cnt > 1) {
                    secondLargest = fitKey;
                } else {
                    Long secKey = gapCounts.lowerKey(fitKey);
                    secondLargest = (secKey == null ? 0L : secKey);
                }
                newMax = Math.max(leftover, secondLargest);
            }
            ans = Math.max(ans, (int)newMax);

            // undo: remove merged, put back originals
            removeOne.accept(merged, gapCounts);
            gapCounts.merge(gBefore, 1, Integer::sum);
            gapCounts.merge(gAfter,  1, Integer::sum);
        }

        return ans;
    }
}
