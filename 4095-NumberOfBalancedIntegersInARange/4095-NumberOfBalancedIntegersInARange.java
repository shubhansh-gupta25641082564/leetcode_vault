// Last updated: 01/01/2026, 18:31:15
import java.util.*;

class Solution {
    private static final int OFFSET = 200;

    private char[] dig;
    private long[][][][][] memo;

    public long countBalanced(long low, long high) {
        if (high <= 0) return 0;
        return countUpTo(high) - countUpTo(low - 1);
    }

    private long countUpTo(long x) {
        if (x < 10) return 0;
        dig = Long.toString(x).toCharArray();
        int L = dig.length;
        memo = new long[L + 1][2 * OFFSET + 1][2][2][L + 1];
        for (int i = 0; i <= L; i++) {
            for (int d = 0; d <= 2 * OFFSET; d++) {
                for (int s = 0; s < 2; s++) {
                    for (int p = 0; p < 2; p++) {
                        Arrays.fill(memo[i][d][s][p], -1L);
                    }
                }
            }
        }
        return dfs(0, 0, 0, 1, 0, 1);
    }

    private long dfs(int pos, int diff, int started, int parity, int len, int tight) {
        if (pos == dig.length) {
            return (started == 1 && len >= 2 && diff == 0) ? 1L : 0L;
        }

        int di = diff + OFFSET;
        if (tight == 0) {
            long cached = memo[pos][di][started][parity][len];
            if (cached != -1L) return cached;
        }

        int up = tight == 1 ? (dig[pos] - '0') : 9;
        long res = 0;

        for (int d = 0; d <= up; d++) {
            int ntight = (tight == 1 && d == up) ? 1 : 0;
            if (started == 0 && d == 0) {
                res += dfs(pos + 1, 0, 0, 1, 0, ntight);
            } else {
                int ndiff = diff;
                int nlen = len + 1;
                int nparity = 1 - parity;
                if (parity == 1) ndiff += d;
                else ndiff -= d;
                res += dfs(pos + 1, ndiff, 1, nparity, nlen, ntight);
            }
        }

        if (tight == 0) memo[pos][di][started][parity][len] = res;
        return res;
    }
}
