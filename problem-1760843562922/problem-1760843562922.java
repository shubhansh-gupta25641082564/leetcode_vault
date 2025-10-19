// Last updated: 19/10/2025, 08:42:42
import java.util.*;
class Solution {
    public int longestBalanced(int[] nums) {
        int n = nums.length, ans = 0;
        HashMap<Integer, Integer> even = new HashMap<>();
        HashMap<Integer, Integer> odd = new HashMap<>();
        for (int i = 0; i < n; i ++) {
            even.clear();
            odd.clear();
            int de = 0, doo = 0;
            for (int j = i; j < n; j ++) {
                int x = nums[j];
                if ((x & 1) == 0) {
                    int c = even.getOrDefault(x, 0) + 1;
                    even.put(x, c);
                    if (c == 1) de++;
                } else {
                    int c = odd.getOrDefault(x, 0) + 1;
                    odd.put(x, c);
                    if (c == 1) doo++;
                }
                if (de == doo) ans = Math.max(ans, j - i + 1);
            }
        }
        return ans;
    }
}