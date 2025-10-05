// Last updated: 05/10/2025, 09:09:47
class Solution {
    public int alternatingSum(int[] nums) {
        int se = 0, so = 0;
        for (int i = 0; i < nums.length; i ++)
            {
                if (i % 2 == 0)
                {
                    se += nums[i];
                }
                else
                {
                    so += nums[i];
                }
            }
        return se - so;
    }
}