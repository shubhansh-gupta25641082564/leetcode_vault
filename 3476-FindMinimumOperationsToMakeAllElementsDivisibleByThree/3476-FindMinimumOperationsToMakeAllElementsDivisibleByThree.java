// Last updated: 22/09/2025, 16:13:13
class Solution {
    public int minimumOperations(int[] nums) {
        int operations = 0;
        
        // Iterate through each element in the array
        for (int num : nums) {
            int remainder = num % 3;
            
            // If the remainder is 1, we need 1 operation to make it divisible by 3
            // (either subtract 1 or add 2)
            if (remainder == 1) {
                operations += 1;
            }
            // If the remainder is 2, we need 1 operation to make it divisible by 3
            // (either add 1 or subtract 2)
            else if (remainder == 2) {
                operations += 1;
            }
        }
        
        return operations;
    }
}