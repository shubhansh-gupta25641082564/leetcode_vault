// Last updated: 10/09/2025, 15:07:28
import java.util.PriorityQueue;

public class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<int[]> pq = new PriorityQueue<>((x,y) -> {
            double dx = (double)(x[0]+1)/(x[1]+1) - (double)x[0]/x[1];
            double dy = (double)(y[0]+1)/(y[1]+1) - (double)y[0]/y[1];
            return Double.compare(dy, dx);
        });
        for (int[] c : classes) pq.offer(new int[]{c[0], c[1]});
        for (int i = 0; i < extraStudents; i++) {
            int[] cur = pq.poll();
            cur[0]++; cur[1]++;
            pq.offer(cur);
        }
        double sum = 0;
        while (!pq.isEmpty()) {
            int[] c = pq.poll();
            sum += (double)c[0] / c[1];
        }
        return sum / classes.length;
    }
}
