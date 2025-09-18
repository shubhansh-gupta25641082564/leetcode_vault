// Last updated: 18/09/2025, 23:30:26
import java.util.Arrays;

public class Solution {
    public int candy(int[] ratings) {
        if (ratings == null || ratings.length == 0) return 0;
        int n = ratings.length;
        int[] left = new int[n];
        Arrays.fill(left, 1);

        // left-to-right: satisfy left neighbor condition
        for (int i = 1; i < n; i++) {
            if (ratings[i] > ratings[i - 1]) {
                left[i] = left[i - 1] + 1;
            }
        }

        // right-to-left: satisfy right neighbor condition and accumulate result
        int res = 0;
        int right = 1; // candies needed considering only the right neighbor
        for (int i = n - 1; i >= 0; i--) {
            if (i < n - 1 && ratings[i] > ratings[i + 1]) {
                right = right + 1;
            } else if (i < n - 1) {
                right = 1;
            }
            res += Math.max(left[i], right);
        }

        return res;
    }
}
