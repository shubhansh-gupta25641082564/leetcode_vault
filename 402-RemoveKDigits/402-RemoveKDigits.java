// Last updated: 22/09/2025, 07:52:12
import java.util.*;

class Solution {
    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, (a, b) -> a[0] == b[0] ? a[1] - b[1] : b[0] - a[0]);
        List<int[]> ans = new LinkedList<>();
        for (int[] p : people) ans.add(p[1], p);
        return ans.toArray(new int[people.length][]);
    }
}
