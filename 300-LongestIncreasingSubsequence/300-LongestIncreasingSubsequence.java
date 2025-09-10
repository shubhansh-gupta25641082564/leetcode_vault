// Last updated: 10/09/2025, 15:07:40
class Solution {
    public int lengthOfLIS(int[] nums) {
        return LTS(nums);   
    }
    public static int LTS(int[] arr) {
        int[] dp = new int[arr.length];
        Arrays.fill(dp, 1);
        for(int i = 1; i < arr.length; i ++) {
            for(int j = i - 1; j >= 0; j --) {
                if(arr[i] > arr[j]) {
                    int x = dp[j];
                    dp[i] = Math.max(dp[i], x + 1);
                }
            }
        }
        return Arrays.stream(dp).max().getAsInt();
    }
}