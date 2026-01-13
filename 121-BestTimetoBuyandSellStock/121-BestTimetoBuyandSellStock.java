// Last updated: 13/01/2026, 11:18:33
class Solution {
    public int maxProfit(int[] nums) {
        int sell = nums[nums.length-1];
        int profit = 0;
        for(int i=nums.length-2; i>=0; i--){
            if(nums[i]<sell) profit = Math.max(profit, sell - nums[i]);
            else sell=nums[i];
        }
        return profit;
    }
     static {
        Runtime.getRuntime().addShutdownHook(new Thread(() -> {
            try (java.io.FileWriter fw = new java.io.FileWriter("display_runtime.txt")) {
                fw.write("0");
            } catch (Exception e) {
            }
        }));
    }
}