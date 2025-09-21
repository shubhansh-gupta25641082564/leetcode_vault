// Last updated: 21/09/2025, 18:45:56
class Solution {
    public int maxProfit(int[] prices) {
        if (prices == null || prices.length == 0) return 0;
    
    int n = prices.length;
    int hold = -prices[0]; // holding stock
    int sold = 0;          // just sold
    int rest = 0;          // cooldown / rest
    
    for (int i = 1; i < n; i++) {
        int prevHold = hold;
        int prevSold = sold;
        int prevRest = rest;
        
        hold = Math.max(prevHold, prevRest - prices[i]);
        sold = prevHold + prices[i];
        rest = Math.max(prevRest, prevSold);
    }
    
    return Math.max(sold, rest);
    }
}