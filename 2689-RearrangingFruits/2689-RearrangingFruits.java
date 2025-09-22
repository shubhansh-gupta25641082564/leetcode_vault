// Last updated: 22/09/2025, 16:13:21
import java.util.*;

class Solution {
    public long minCost(int[] basket1, int[] basket2) {
        int n = basket1.length;
        Map<Integer, Long> diff = new HashMap<>();
        int minAll = Integer.MAX_VALUE;
        for (int x : basket1) {
            diff.put(x, diff.getOrDefault(x, 0L) + 1);
            minAll = Math.min(minAll, x);
        }
        for (int x : basket2) {
            diff.put(x, diff.getOrDefault(x, 0L) - 1);
            minAll = Math.min(minAll, x);
        }
        List<Integer> A = new ArrayList<>();
        List<Integer> B = new ArrayList<>();
        for (Map.Entry<Integer, Long> e : diff.entrySet()) {
            long cnt = e.getValue();
            if ((Math.abs(cnt) & 1) == 1) return -1;
            int times = (int)(Math.abs(cnt) / 2);
            for (int i = 0; i < times; i++) {
                if (cnt > 0) A.add(e.getKey());
                else B.add(e.getKey());
            }
        }
        Collections.sort(A);
        Collections.sort(B, Collections.reverseOrder());
        long res = 0;
        for (int i = 0; i < A.size(); i++) {
            long a = A.get(i);
            long b = B.get(i);
            long direct = Math.min(a, b);
            long viaMin = 2L * minAll;
            res += Math.min(direct, viaMin);
        }
        return res;
    }
}
