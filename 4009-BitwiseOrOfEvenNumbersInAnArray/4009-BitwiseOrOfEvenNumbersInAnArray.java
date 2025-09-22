// Last updated: 22/09/2025, 16:12:50
class Solution {
    public int evenNumberBitwiseORs(int[] nums) {
        int ans = 0;
        boolean flag = false;
        for (int i = 0; i < nums.length; i ++)
            {
                if ((nums[i] & 1) == 0)
                {
                    ans |= nums[i];
                    flag = true;
                }
            }
        return flag ? ans : 0;
    }
}