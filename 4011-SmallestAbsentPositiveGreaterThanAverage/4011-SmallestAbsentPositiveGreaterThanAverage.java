// Last updated: 15/09/2025, 22:05:01
class Solution {
    public int smallestAbsent(int[] nums) {
        int n = nums.length, sum = 0;
        for(int i : nums) {
            sum += i;
        }
        double avg = sum / (double) n;
        int start = Math.max(1, (int)Math.floor(avg) + 1);
        int M = 1005;
        boolean[] s = new boolean[M];
        for(int i : nums) {
            if(i > 0 && i < M) {
                s[i] = true;
            }
        }
        for(int j = start; j < M; j++) {
            if(!s[j]) {
                return j;
            }
        }
        return M;
    }
}