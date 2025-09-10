// Last updated: 10/09/2025, 15:07:31
import java.util.ArrayDeque;
import java.util.Deque;

class Solution {
    public int numSubmat(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[] heights = new int[n];
        int ans = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) heights[j] = mat[i][j] == 1 ? heights[j] + 1 : 0;
            Deque<int[]> stack = new ArrayDeque<>();
            int sum = 0;
            for (int j = 0; j < n; j++) {
                int cnt = 1;
                while (!stack.isEmpty() && stack.peekLast()[0] >= heights[j]) {
                    int[] p = stack.removeLast();
                    cnt += p[1];
                    sum -= p[0] * p[1];
                }
                if (heights[j] > 0) {
                    stack.addLast(new int[]{heights[j], cnt});
                    sum += heights[j] * cnt;
                }
                ans += sum;
            }
        }
        return ans;
    }
}
