// Last updated: 16/09/2025, 23:15:11
import java.util.*;

class Solution {
    public List<Integer> grayCode(int n) {
        List<Integer> res = new ArrayList<>();
        int size = 1 << n;
        for (int i = 0; i < size; i++) res.add(i ^ (i >> 1));
        return res;
    }
}
