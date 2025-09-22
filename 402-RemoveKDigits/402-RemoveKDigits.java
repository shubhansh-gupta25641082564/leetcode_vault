// Last updated: 22/09/2025, 07:50:23
import java.util.*;

class Solution {
    public boolean canCross(int[] stones) {
        Map<Integer, Set<Integer>> map = new HashMap<>();
        for (int s : stones) map.put(s, new HashSet<>());
        map.get(0).add(0);
        for (int s : stones) {
            Set<Integer> jumps = map.get(s);
            if (jumps.isEmpty()) continue;
            for (int k : jumps) {
                for (int step = k - 1; step <= k + 1; step++) {
                    if (step > 0 && map.containsKey(s + step)) {
                        map.get(s + step).add(step);
                    }
                }
            }
        }
        return !map.get(stones[stones.length - 1]).isEmpty();
    }
}
