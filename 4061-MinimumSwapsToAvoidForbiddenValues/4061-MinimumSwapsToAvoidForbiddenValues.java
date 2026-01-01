// Last updated: 01/01/2026, 18:31:21
import java.util.*;

class Solution {
    public int minSwaps(int[] nums, int[] forbidden) {
        int n = nums.length;

        HashMap<Integer, Integer> cntNums = new HashMap<>();
        HashMap<Integer, Integer> cntForb = new HashMap<>();

        for (int x : nums) cntNums.put(x, cntNums.getOrDefault(x, 0) + 1);
        for (int x : forbidden) cntForb.put(x, cntForb.getOrDefault(x, 0) + 1);

        for (Map.Entry<Integer, Integer> e : cntNums.entrySet()) {
            int x = e.getKey();
            int c = e.getValue();
            int f = cntForb.getOrDefault(x, 0);
            if (c > n - f) return -1;
        }

        int conflicts = 0;
        int maxFreq = 0;
        HashMap<Integer, Integer> bad = new HashMap<>();

        for (int i = 0; i < n; i++) {
            if (nums[i] == forbidden[i]) {
                conflicts++;
                int v = nums[i];
                int nv = bad.getOrDefault(v, 0) + 1;
                bad.put(v, nv);
                if (nv > maxFreq) maxFreq = nv;
            }
        }

        if (conflicts == 0) return 0;
        return Math.max(maxFreq, (conflicts + 1) / 2);
    }
}
