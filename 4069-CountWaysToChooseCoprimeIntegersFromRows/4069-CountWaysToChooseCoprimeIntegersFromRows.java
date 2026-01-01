// Last updated: 01/01/2026, 18:31:20
import java.util.*;

class Solution {
    static final int MAX = 150;
    static final int MOD = 1_000_000_007;

    public int countCoprime(int[][] mat) {
        int m = mat.length;

        int[][] cntDiv = new int[m][MAX + 1];
        for (int i = 0; i < m; i++) {
            int[] freq = new int[MAX + 1];
            for (int v : mat[i]) freq[v]++;
            for (int d = 1; d <= MAX; d++) {
                int s = 0;
                for (int mult = d; mult <= MAX; mult += d) s += freq[mult];
                cntDiv[i][d] = s;
            }
        }

        long[] ways = new long[MAX + 1];
        for (int d = 1; d <= MAX; d++) {
            long prod = 1;
            for (int i = 0; i < m; i++) {
                prod = (prod * cntDiv[i][d]) % MOD;
                if (prod == 0) break;
            }
            ways[d] = prod;
        }

        int[] mu = mobius(MAX);

        long ans = 0;
        for (int d = 1; d <= MAX; d++) {
            if (mu[d] == 0) continue;
            ans = (ans + (long) mu[d] * ways[d]) % MOD;
        }
        ans %= MOD;
        if (ans < 0) ans += MOD;
        return (int) ans;
    }

    private int[] mobius(int n) {
        int[] mu = new int[n + 1];
        int[] lp = new int[n + 1];
        int[] primes = new int[n + 1];
        int pc = 0;

        mu[1] = 1;
        for (int i = 2; i <= n; i++) {
            if (lp[i] == 0) {
                lp[i] = i;
                primes[pc++] = i;
                mu[i] = -1;
            }
            for (int j = 0; j < pc; j++) {
                int p = primes[j];
                long v = (long) i * p;
                if (v > n) break;
                int x = (int) v;
                lp[x] = p;
                if (i % p == 0) {
                    mu[x] = 0;
                    break;
                } else {
                    mu[x] = -mu[i];
                }
            }
        }
        return mu;
    }
}
