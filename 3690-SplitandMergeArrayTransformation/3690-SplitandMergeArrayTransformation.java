// Last updated: 21/09/2025, 15:33:02
import java.util.*;

class Solution {
    public int minSplitMerge(int[] nums1, int[] nums2) {
        int n = nums1.length;
        if (Arrays.equals(nums1, nums2)) return 0;

        String targetKey = Arrays.toString(nums2);
        Queue<int[]> q = new LinkedList<>();
        Queue<Integer> stepsQ = new LinkedList<>();
        Set<String> seen = new HashSet<>();

        q.add(nums1.clone());
        stepsQ.add(0);
        seen.add(Arrays.toString(nums1));

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int steps = stepsQ.poll();

            // generate all split-and-merge operations
            for (int L = 0; L < n; ++L) {
                for (int R = L; R < n; ++R) {
                    int len = R - L + 1;
                    // build removed subarray
                    int[] removed = new int[len];
                    for (int i = 0; i < len; ++i) removed[i] = cur[L + i];

                    // build remaining array
                    int[] rem = new int[n - len];
                    int idx = 0;
                    for (int i = 0; i < n; ++i) {
                        if (i < L || i > R) rem[idx++] = cur[i];
                    }

                    // insert removed at every possible position in remaining (0..rem.length)
                    for (int insertPos = 0; insertPos <= rem.length; ++insertPos) {
                        // if insertion position equals original position (i.e., results in same array), skip
                        // original insertion position relative to remaining after removal is L
                        if (insertPos == L) continue;

                        int[] next = new int[n];
                        int p = 0;
                        // copy left part of rem before insertion
                        for (int i = 0; i < insertPos; ++i) next[p++] = rem[i];
                        // copy removed
                        for (int x : removed) next[p++] = x;
                        // copy remaining right part
                        for (int i = insertPos; i < rem.length; ++i) next[p++] = rem[i];

                        String key = Arrays.toString(next);
                        if (seen.contains(key)) continue;
                        if (key.equals(targetKey)) return steps + 1;
                        seen.add(key);
                        q.add(next);
                        stepsQ.add(steps + 1);
                    }
                }
            }
        }

        // since nums2 is a permutation of nums1 and operations can reorder, we should find it;
        // but return -1 defensively if not found
        return -1;
    }
}
