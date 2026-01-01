// Last updated: 01/01/2026, 18:31:12
class Solution {
    public long minCost(String s, int[] cost) {
        int n = s.length();
        long[] a = new long[n];
        long total = 0;
        for(int i = 0; i < n; i ++) {
            total += cost[i];
            a[i] = (((long)s.charAt(i)) << 32) | (cost[i] & 0xffffffffL);
        }
        Arrays.sort(a);
        long bst = 0, run = 0, prev = -1;
        for(int i = 0; i < n; i ++) {
            long ch = a[i] >>> 32;
            long c = a[i] & 0xffffffffL;
            if(ch != prev) {
                bst = Math.max(bst, run);
                run = 0;
                prev = ch;
            }
            run += c;
        }
        bst = Math.max(bst, run);
        return total - bst;
    }
}