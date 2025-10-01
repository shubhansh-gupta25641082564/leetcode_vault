// Last updated: 01/10/2025, 22:18:01
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int total = numBottles;
        int empty = numBottles;
        while (empty >= numExchange) {
            int newFull = empty / numExchange;
            total += newFull;
            empty = newFull + (empty % numExchange);
        }
        return total;
    }
}
