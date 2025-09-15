// Last updated: 15/09/2025, 21:59:29
import java.util.*;

class Solution {
    public boolean[] subsequenceSumAfterCapping(int[] nums, int k) {
        int n = nums.length;
        int maxV = n;
        int[] cnt = new int[maxV + 1];
        for (int v : nums) if (v <= maxV) cnt[v]++;
        int[] suffix = new int[maxV + 2];
        for (int v = maxV; v >= 1; --v) suffix[v] = suffix[v + 1] + cnt[v];
        int bits = k + 1;
        int W = (bits + 63) >>> 6;
        long lastMask;
        int rem = bits & 63;
        if (rem == 0) lastMask = ~0L;
        else lastMask = (1L << rem) - 1L;
        long[][] dpBits = new long[maxV + 1][];
        long[] init = new long[W];
        init[0] = 1L;
        dpBits[0] = init;
        for (int val = 1; val <= maxV; ++val) {
            long[] cur = Arrays.copyOf(dpBits[val - 1], W);
            int m = cnt[val];
            int take = 1;
            while (m > 0) {
                int c = Math.min(take, m);
                int shift = c * val;
                if (shift <= k) {
                    int sw = shift >>> 6;
                    int sb = shift & 63;
                    if (sb == 0) {
                        for (int i = W - 1; i >= sw; --i) {
                            cur[i] |= cur[i - sw];
                        }
                    } else {
                        for (int i = W - 1; i >= sw + 1; --i) {
                            cur[i] |= (cur[i - sw] << sb) | (cur[i - sw - 1] >>> (64 - sb));
                        }
                        if (sw < W) cur[sw] |= (cur[0] << sb);
                    }
                    cur[W - 1] &= lastMask;
                }
                m -= c;
                take <<= 1;
            }
            dpBits[val] = cur;
        }
        boolean[] ans = new boolean[maxV];
        for (int x = 1; x <= maxV; ++x) {
            long[] base = dpBits[x - 1];
            int maxY = Math.min(suffix[x], k / x);
            boolean ok = false;
            for (int y = 0; y <= maxY; ++y) {
                int target = k - y * x;
                int wi = target >>> 6;
                int bi = target & 63;
                if (((base[wi] >>> bi) & 1L) != 0L) { ok = true; break; }
            }
            ans[x - 1] = ok;
        }
        return ans;
    }
}
