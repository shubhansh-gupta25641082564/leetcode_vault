// Last updated: 22/09/2025, 16:11:11
class Solution {
    public int maxFrequencyElements(int[] nums) {
        int[] freq = new int[101];
        for (int i = 0; i < nums.length; i ++)
        {
            int item = nums[i];
            freq[item] ++;
        }
        int max = 0;
        for (int j = 1; j < freq.length; j ++)
        {
            if (freq[j] > max)
            {
                max = freq[j];
            }
        }
        int sum = 0;
        for (int k = 1; k < freq.length; k ++)
        {
            if (max == freq[k])
            {
                sum += freq[k];
            }
        }
        return sum;
    }
}