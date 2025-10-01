// Last updated: 01/10/2025, 22:23:41
class Solution {
    public int minFlipsMonoIncr(String s) {
        int flipCount = 0, onesCount = 0;
        for (char c : s.toCharArray()) {
            if (c == '1') onesCount++;
            else {
                if (onesCount > 0) flipCount++;
            }
            flipCount = Math.min(flipCount, onesCount);
        }
        return flipCount;
    }
}
