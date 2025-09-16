// Last updated: 16/09/2025, 23:01:30
import java.util.*;

class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0) return 0;
        int m = matrix.length, n = matrix[0].length;
        int[] h = new int[n];
        int max = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) h[j] = matrix[i][j] == '1' ? h[j] + 1 : 0;
            Deque<Integer> st = new ArrayDeque<>();
            for (int j = 0; j <= n; j++) {
                int cur = (j == n) ? 0 : h[j];
                while (!st.isEmpty() && h[st.peekLast()] > cur) {
                    int height = h[st.pollLast()];
                    int left = st.isEmpty() ? -1 : st.peekLast();
                    int width = j - left - 1;
                    int area = height * width;
                    if (area > max) max = area;
                }
                st.addLast(j);
            }
        }
        return max;
    }
}
