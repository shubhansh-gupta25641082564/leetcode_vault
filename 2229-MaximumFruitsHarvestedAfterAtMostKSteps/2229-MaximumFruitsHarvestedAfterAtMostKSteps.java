// Last updated: 22/09/2025, 16:13:34
import java.util.*;

class Solution {
    public int maxTotalFruits(int[][] fruits, int startPos, int k) {
        int n = fruits.length;
        // Extract positions and build prefix sums
        int[] pos = new int[n];
        long[] pref = new long[n + 1];
        for (int i = 0; i < n; i++) {
            pos[i] = fruits[i][0];
            pref[i + 1] = pref[i] + fruits[i][1];
        }
        
        int ans = 0;
        // Helper lambdas to do binary searches
        // first idx with pos[idx] >= x
        // Arrays.binarySearch returns >=0 if exact, else (-insPt-1)
        java.util.function.IntUnaryOperator lowerBound = key -> {
            int i = Arrays.binarySearch(pos, key);
            return i >= 0 ? i : -i - 1;
        };
        
        // sum of fruits in [L..R]
        java.util.function.BiFunction<Integer,Integer,Integer> sumRange = (L, R) -> {
            int l = lowerBound.applyAsInt(L);
            int r = lowerBound.applyAsInt(R + 1) - 1;
            if (l >= n || r < l) return 0;
            return (int)(pref[r + 1] - pref[l]);
        };
        
        // 1) go left x steps, then use remaining (k - 2*x) to go right
        for (int x = 0; x <= k; x++) {
            int rem = k - 2 * x;
            if (rem < 0) break;
            int L = startPos - x;
            int R = startPos + rem;
            ans = Math.max(ans, sumRange.apply(L, R));
        }
        // 2) go right x steps, then use remaining (k - 2*x) to go left
        for (int x = 0; x <= k; x++) {
            int rem = k - 2 * x;
            if (rem < 0) break;
            int R = startPos + x;
            int L = startPos - rem;
            ans = Math.max(ans, sumRange.apply(L, R));
        }
        
        return ans;
    }
}