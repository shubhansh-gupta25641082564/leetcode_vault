// Last updated: 21/09/2025, 16:57:45
import java.util.*;

class Solution {
    public List<List<Integer>> getSkyline(int[][] buildings) {
        List<int[]> events = new ArrayList<>();
        for (int[] b : buildings) {
            events.add(new int[]{b[0], -b[2]}); // entering, height negative
            events.add(new int[]{b[1], b[2]});  // leaving, height positive
        }
        events.sort((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        TreeMap<Integer, Integer> map = new TreeMap<>(Collections.reverseOrder());
        map.put(0, 1);
        int prev = 0;
        List<List<Integer>> res = new ArrayList<>();

        for (int[] e : events) {
            int x = e[0], h = e[1];
            if (h < 0) { // entering
                map.put(-h, map.getOrDefault(-h, 0) + 1);
            } else { // leaving
                map.put(h, map.get(h) - 1);
                if (map.get(h) == 0) map.remove(h);
            }
            int cur = map.firstKey();
            if (cur != prev) {
                res.add(Arrays.asList(x, cur));
                prev = cur;
            }
        }
        return res;
    }
}
