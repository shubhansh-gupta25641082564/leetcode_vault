// Last updated: 22/09/2025, 07:47:35
import java.util.*;

class Solution {
    public List<String> readBinaryWatch(int turnedOn) {
        List<String> res = new ArrayList<>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m++) {
                if (Integer.bitCount(h) + Integer.bitCount(m) == turnedOn) {
                    res.add(h + ":" + (m < 10 ? "0" + m : m));
                }
            }
        }
        return res;
    }
}
