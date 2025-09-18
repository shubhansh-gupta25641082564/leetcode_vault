// Last updated: 18/09/2025, 23:19:28
public class Solution {
    public int singleNumber(int[] nums) {
        int[] bits = new int[32];
        for (int num : nums) {
            for (int i = 0; i < 32; i++) {
                bits[i] += (num >>> i) & 1; // use unsigned shift
            }
        }
        int result = 0;
        for (int i = 0; i < 32; i++) {
            if (bits[i] % 3 != 0) {
                result |= (1 << i);
            }
        }
        return result;
    }
}
