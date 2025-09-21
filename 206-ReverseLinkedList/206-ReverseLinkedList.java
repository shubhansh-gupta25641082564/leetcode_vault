// Last updated: 21/09/2025, 16:55:50
import java.util.*;

class Solution {
    private final Random rand = new Random();
    public int findKthLargest(int[] nums, int k) {
        int n = nums.length;
        int target = n - k;
        int lo = 0, hi = n - 1;
        while (lo <= hi) {
            int pivotIndex = lo + rand.nextInt(hi - lo + 1);
            int pos = partition(nums, lo, hi, pivotIndex);
            if (pos == target) return nums[pos];
            else if (pos < target) lo = pos + 1;
            else hi = pos - 1;
        }
        return -1;
    }
    private int partition(int[] a, int l, int r, int pivotIdx) {
        int pv = a[pivotIdx];
        swap(a, pivotIdx, r);
        int store = l;
        for (int i = l; i < r; ++i) {
            if (a[i] < pv) {
                swap(a, store, i);
                store++;
            }
        }
        swap(a, store, r);
        return store;
    }
    private void swap(int[] a, int i, int j) {
        int t = a[i]; a[i] = a[j]; a[j] = t;
    }
}
