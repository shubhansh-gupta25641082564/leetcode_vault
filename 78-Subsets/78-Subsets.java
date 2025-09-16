// Last updated: 16/09/2025, 23:00:39
import java.util.*;

class Solution {
    public int largestRectangleArea(int[] heights) {
        int n = heights.length;
        Deque<Integer> st = new ArrayDeque<>();
        long max = 0;
        for (int i = 0; i <= n; i++) {
            int h = (i == n ? 0 : heights[i]);
            while (!st.isEmpty() && heights[st.peekLast()] > h) {
                int idx = st.pollLast();
                int left = st.isEmpty() ? -1 : st.peekLast();
                long width = i - left - 1;
                long area = (long)heights[idx] * width;
                if (area > max) max = area;
            }
            st.addLast(i);
        }
        return (int)max;
    }
}
