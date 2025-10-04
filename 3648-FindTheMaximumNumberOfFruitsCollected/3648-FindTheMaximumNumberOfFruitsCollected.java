// Last updated: 05/10/2025, 00:08:19
class Solution {
    public int maxCollectedFruits(int[][] fruits) {
        int n = fruits.length;

        // 1) Pre-sum Child 1’s diagonal path
        long diagSum = 0;
        for (int k = 0; k < n; k++) {
            diagSum += fruits[k][k];
        }

        // 2) DP for Child 2: walks from (0,n-1) to (n-1,n-1), always on row = k
        int[] dp2 = new int[n], new2 = new int[n];
        // base at k=0: only c = n-1 is valid
        Arrays.fill(dp2, Integer.MIN_VALUE);
        dp2[n-1] = fruits[0][n-1];
        for (int k = 1; k < n; k++) {
            // compute new2 for row k
            for (int c = 0; c < n; c++) {
                int best = dp2[c];
                if (c > 0)      best = Math.max(best, dp2[c-1]);
                if (c < n-1)    best = Math.max(best, dp2[c+1]);
                // if c == k, this is the diagonal cell (k,k) → Child 1 collects, so Child 2 gets 0
                new2[c] = best + (c == k ? 0 : fruits[k][c]);
            }
            // swap
            int[] tmp = dp2; dp2 = new2; new2 = tmp;
        }
        int child2 = dp2[n-1];  // must finish at column = n-1

        // 3) DP for Child 3: walks from (n-1,0) to (n-1,n-1), always on col = k
        int[] dp3 = new int[n], new3 = new int[n];
        // base at k=0: only r = n-1 is valid
        Arrays.fill(dp3, Integer.MIN_VALUE);
        dp3[n-1] = fruits[n-1][0];
        for (int k = 1; k < n; k++) {
            for (int r = 0; r < n; r++) {
                int best = dp3[r];
                if (r > 0)      best = Math.max(best, dp3[r-1]);
                if (r < n-1)    best = Math.max(best, dp3[r+1]);
                // if r == k, this is the diagonal cell (k,k) → Child 1 collects, so Child 3 gets 0
                new3[r] = best + (r == k ? 0 : fruits[r][k]);
            }
            int[] tmp = dp3; dp3 = new3; new3 = tmp;
        }
        int child3 = dp3[n-1];  // must finish at row = n-1

        // 4) Combine: diagSum covers every diagonal cell exactly once (Child 1)
        //    child2 and child3 never collected any diagonal, so we just add all three.
        return (int)(diagSum + child2 + child3);
    }
}