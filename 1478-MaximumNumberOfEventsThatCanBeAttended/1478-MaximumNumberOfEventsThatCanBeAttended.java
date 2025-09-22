// Last updated: 22/09/2025, 23:01:30
import java.util.*;

class Solution {
    public int maxEvents(int[][] events) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int day = 0, i = 0, n = events.length, attended = 0;

        while (i < n || !pq.isEmpty()) {
            if (pq.isEmpty()) day = events[i][0]; // jump to next event's start day

            while (i < n && events[i][0] <= day) {
                pq.offer(events[i][1]); // push end day
                i++;
            }

            pq.poll(); // attend the event that ends earliest
            attended++;
            day++; // move to next day

            while (!pq.isEmpty() && pq.peek() < day) pq.poll(); // remove expired events
        }

        return attended;
    }
}
