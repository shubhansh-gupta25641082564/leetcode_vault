// Last updated: 18/09/2025, 23:30:28
public class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        long total = 0;   // overall gas - cost
        long tank = 0;    // current tank from candidate start
        int start = 0;
        for (int i = 0; i < n; i++) {
            int diff = gas[i] - cost[i];
            total += diff;
            tank += diff;
            if (tank < 0) {
                // cannot start from current start, choose next station
                start = i + 1;
                tank = 0;
            }
        }
        return total >= 0 ? (start % n) : -1;
    }
}
