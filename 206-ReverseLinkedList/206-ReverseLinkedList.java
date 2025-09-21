// Last updated: 21/09/2025, 16:59:21
import java.util.*;

class Solution {
    public boolean containsNearbyAlmostDuplicate(int[] nums, int indexDiff, int valueDiff) {
        TreeSet<Long> set = new TreeSet<>();
        for (int i = 0; i < nums.length; ++i) {
            Long floor = set.floor((long) nums[i] + valueDiff);
            Long ceil = set.ceiling((long) nums[i] - valueDiff);
            if ((floor != null && floor >= nums[i]) || (ceil != null && ceil <= nums[i])) return true;
            set.add((long) nums[i]);
            if (set.size() > indexDiff) set.remove((long) nums[i - indexDiff]);
        }
        return false;
    }
}
