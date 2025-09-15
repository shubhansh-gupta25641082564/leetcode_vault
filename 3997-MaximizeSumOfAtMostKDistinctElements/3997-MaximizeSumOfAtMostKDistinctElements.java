// Last updated: 15/09/2025, 22:04:57
import java.util.*;
class Solution {
    public int[] maxKDistinct(int[] nums, int k) {
        HashSet<Integer> s = new HashSet<>();
        for (int n : nums)
            {
                s.add(n);
            }
        int[] arr = nums.clone();
        Integer[] a = new Integer[s.size()];
        int p = 0;
        for (int v : s)
            {
                a[p ++] = v;
            }
        Arrays.sort(a, Collections.reverseOrder());
        int m = Math.min(k, a.length);
        int[] r = new int[m];
        for (int i = 0; i < m; i ++)
            {
                r[i] = a[i];
            }
        return r;
    }
}