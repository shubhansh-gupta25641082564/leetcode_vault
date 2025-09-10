// Last updated: 10/09/2025, 15:08:35
class Solution {
    public int searchInsert(int[] nums, int target) {
        if(nums[0]>target) return 0;
        for(int i = 0; i<nums.length; i++)
        {
            if(nums[i] == target)
            {
                return i;
            }
            else if(nums[nums.length-1] > target)
            {
                for(int j = 0; j<=nums.length; j++)
                {
                    if(nums[i]>target)
                    {
                        return i;
                    }
                }
            }
        }
        return nums.length;
    }
}