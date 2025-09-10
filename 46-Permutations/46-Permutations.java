// Last updated: 10/09/2025, 15:08:23
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        boolean[] used = new boolean[nums.length];
        backtrack(nums, used, new ArrayList<>(), result);
        return result;
    }

    private void backtrack(int[] nums, boolean[] used, 
                           List<Integer> current, 
                           List<List<Integer>> result) {
        // If the current permutation is the same length as nums, it's complete
        if (current.size() == nums.length) {
            result.add(new ArrayList<>(current));
            return;
        }
        // Try each unused number in turn
        for (int i = 0; i < nums.length; i++) {
            if (used[i]) continue;
            // Choose nums[i]
            used[i] = true;
            current.add(nums[i]);
            // Recurse
            backtrack(nums, used, current, result);
            // Undo choice
            current.remove(current.size() - 1);
            used[i] = false;
        }
    }
}