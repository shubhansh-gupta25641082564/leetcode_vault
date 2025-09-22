// Last updated: 22/09/2025, 23:01:29
import java.util.*;

class Solution {
    public int numSubseq(int[] nums, int target) {
        Arrays.sort(nums);
        int MOD = 1_000_000_007;
        int n = nums.length;
        
        // Precompute powers of 2
        int[] pow2 = new int[n];
        pow2[0] = 1;
        for (int k = 1; k < n; k++) {
            pow2[k] = (pow2[k-1] * 2) % MOD;
        }
        
        int i = 0, j = n - 1;
        int ans = 0;
        
        while (i <= j) {
            if (nums[i] + nums[j] <= target) {
                ans = (ans + pow2[j - i]) % MOD; // all subsequences with nums[i] as min
                i++;
            } else {
                j--;
            }
        }
        
        return ans;
    }
}
