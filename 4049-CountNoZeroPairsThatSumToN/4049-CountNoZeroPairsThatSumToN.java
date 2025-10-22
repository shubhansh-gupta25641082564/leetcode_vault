// Last updated: 22/10/2025, 19:22:27
class Solution {
    public long countNoZeroPairs(long n) {
        int[] d = toDigits(n);
        java.util.HashMap<Long, Long> memo = new java.util.HashMap<>();
        return dfs(0, 0, 0, 0, 0, 0, d, memo);
    }

    private long dfs(int pos, int carry, int aEnd, int bEnd, int aStart, int bStart, int[] d, java.util.HashMap<Long, Long> memo) {
        if (pos == d.length) {
            return (carry == 0 && aStart == 1 && bStart == 1) ? 1L : 0L;
        }
        long key = (((((((long)pos<<1)|carry)<<1)|aEnd)<<1|bEnd)<<1|aStart)<<1|bStart;
        Long got = memo.get(key);
        if (got != null) return got;
        long res = 0L;
        int target = d[pos];
        int aMin = (aEnd == 1) ? 0 : 0;
        int aMax = (aEnd == 1) ? 0 : 9;
        int bMin = (bEnd == 1) ? 0 : 0;
        int bMax = (bEnd == 1) ? 0 : 9;
        for (int da = aMin; da <= aMax; da++) {
            if (aEnd == 0 && da == 0) {
            } else if (aEnd == 0 && da == 0) {
            }
            int naEnd = (aEnd == 1 || da == 0) ? 1 : 0;
            if (aEnd == 1 && da != 0) continue;
            if (aEnd == 0 && da == 0) naEnd = 1;
            int naStart = (aStart == 1 || da > 0) ? 1 : 0;
            for (int db = bMin; db <= bMax; db++) {
                int nbEnd = (bEnd == 1 || db == 0) ? 1 : 0;
                if (bEnd == 1 && db != 0) continue;
                if (bEnd == 0 && db == 0) nbEnd = 1;
                int nbStart = (bStart == 1 || db > 0) ? 1 : 0;
                int sum = da + db + carry;
                if (sum % 10 != target) continue;
                int ncarry = sum / 10;
                if (da == 0 && naStart == 0 && naEnd == 0) continue;
                if (db == 0 && nbStart == 0 && nbEnd == 0) continue;
                if (da == 0 && naEnd == 0) continue;
                if (db == 0 && nbEnd == 0) continue;
                res += dfs(pos + 1, ncarry, naEnd, nbEnd, naStart, nbStart, d, memo);
            }
        }
        memo.put(key, res);
        return res;
    }

    private int[] toDigits(long n) {
        java.util.ArrayList<Integer> list = new java.util.ArrayList<>();
        while (n > 0) {
            list.add((int)(n % 10));
            n /= 10;
        }
        int[] a = new int[list.size()];
        for (int i = 0; i < a.length; i++) a[i] = list.get(i);
        return a;
    }
}
