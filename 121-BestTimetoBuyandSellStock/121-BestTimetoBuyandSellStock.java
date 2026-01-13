// Last updated: 13/01/2026, 11:15:08
1public class Solution {
2    public int maxProfit(int[] prices) {
3        int minPrice = Integer.MAX_VALUE;
4        int maxProfit = 0;
5        for (int price : prices) {
6            if (price < minPrice) minPrice = price;
7            else{
8                maxProfit = Math.max(maxProfit, price - minPrice);
9            }
10        }
11        return maxProfit;
12    }
13}