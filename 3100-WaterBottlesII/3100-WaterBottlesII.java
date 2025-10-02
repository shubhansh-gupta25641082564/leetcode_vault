// Last updated: 03/10/2025, 00:25:46
class Solution {
    public int maxBottlesDrunk(int numBottles, int numExchange) {
        int full = numBottles;
        int empty = 0;
        int total = 0;
        int exch = numExchange;
        while (true) {
            if (full > 0) {
                total += full;
                empty += full;
                full = 0;
            }
            if (empty >= exch) {
                full += 1;
                empty -= exch;
                exch += 1;
            } else {
                break;
            }
        }
        return total;
    }
}
