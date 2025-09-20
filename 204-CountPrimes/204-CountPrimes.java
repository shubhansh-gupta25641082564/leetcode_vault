// Last updated: 20/09/2025, 22:05:53
public class Solution {
    public int countPrimes(int n) {
        if (n <= 2) return 0;
        boolean[] isComposite = new boolean[n]; // default false
        int limit = (int)Math.sqrt(n - 1);
        for (int i = 2; i <= limit; i++) {
            if (!isComposite[i]) {
                for (int j = i * i; j < n; j += i) {
                    isComposite[j] = true;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < n; i++) {
            if (!isComposite[i]) count++;
        }
        return count;
    }
}
