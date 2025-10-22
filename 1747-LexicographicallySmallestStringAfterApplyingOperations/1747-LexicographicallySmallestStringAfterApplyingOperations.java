// Last updated: 22/10/2025, 19:23:18
import java.util.*;

class Solution {
    public String findLexSmallestString(String s, int a, int b) {
        int n = s.length();
        String ans = s;
        Set<Integer> seenOffsets = new HashSet<>();
        int off = 0;
        while (!seenOffsets.contains(off)) {
            seenOffsets.add(off);
            String r = rotateRight(s, off);
            for (int addOdd = 0; addOdd < 10; addOdd++) {
                int incOdd = (addOdd * a) % 10;
                if ((b & 1) == 0) {
                    char[] ca = r.toCharArray();
                    for (int i = 1; i < n; i += 2) {
                        int d = (ca[i] - '0' + incOdd) % 10;
                        ca[i] = (char) ('0' + d);
                    }
                    String cand = new String(ca);
                    if (cand.compareTo(ans) < 0) ans = cand;
                } else {
                    for (int addEven = 0; addEven < 10; addEven++) {
                        int incEven = (addEven * a) % 10;
                        char[] ca = r.toCharArray();
                        for (int i = 0; i < n; i++) {
                            int d = ca[i] - '0';
                            if ((i & 1) == 1) d = (d + incOdd) % 10;
                            else d = (d + incEven) % 10;
                            ca[i] = (char) ('0' + d);
                        }
                        String cand = new String(ca);
                        if (cand.compareTo(ans) < 0) ans = cand;
                    }
                }
            }
            off = (off + b) % n;
        }
        return ans;
    }

    private String rotateRight(String s, int k) {
        int n = s.length();
        k %= n;
        if (k == 0) return s;
        return s.substring(n - k) + s.substring(0, n - k);
    }
}
