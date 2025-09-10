// Last updated: 10/09/2025, 15:07:42
import java.util.*;
class Solution {
    public int rob(int[] nums) {
        return RobberBU(nums);
    }
    public static int RobberBU(int[] arr) {
        if(arr.length == 1) return arr[0];
        int[] dp = new int[arr.length];
        dp[0] = arr[0];
        dp[1] = Math.max(arr[0], arr[1]);
        for(int i = 2; i < arr.length; i ++) {
            int rob = arr[i] + dp[i - 2];
            int dontRob = dp[i - 1];
            dp[i] = Math.max(rob, dontRob);
        }
        return dp[arr.length - 1];
    }
}