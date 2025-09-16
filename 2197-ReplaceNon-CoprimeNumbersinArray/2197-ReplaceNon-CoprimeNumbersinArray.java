// Last updated: 16/09/2025, 22:50:44
import java.util.*;

class Solution {
    public List<Integer> replaceNonCoprimes(int[] nums) {
        Deque<Long> st = new ArrayDeque<>();
        for (int v : nums) {
            long cur = v;
            while (!st.isEmpty()) {
                long top = st.peekLast();
                long g = gcd(top, cur);
                if (g == 1) break;
                st.pollLast();
                cur = top / g * cur;
            }
            st.addLast(cur);
        }
        List<Integer> res = new ArrayList<>(st.size());
        for (long x : st) res.add((int)x);
        return res;
    }
    private long gcd(long a, long b) {
        while (b != 0) {
            long t = a % b;
            a = b;
            b = t;
        }
        return a;
    }
}
