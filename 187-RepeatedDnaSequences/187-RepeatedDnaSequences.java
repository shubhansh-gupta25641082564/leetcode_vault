// Last updated: 20/09/2025, 00:31:14
import java.util.*;

class Solution {
    public List<String> findRepeatedDnaSequences(String s) {
        int n = s.length();
        if (n < 10) return new ArrayList<>();

        // map characters to 2-bit values: A->0, C->1, G->2, T->3
        int[] map = new int[128];
        map['A'] = 0;
        map['C'] = 1;
        map['G'] = 2;
        map['T'] = 3;

        int mask = (1 << 20) - 1; // keep lowest 20 bits (10 letters * 2 bits)
        int hash = 0;

        // build hash for first 10 chars
        for (int i = 0; i < 10; i++) {
            hash = (hash << 2) | map[s.charAt(i)];
        }

        Set<Integer> seen = new HashSet<>();
        Set<String> repeats = new HashSet<>();
        seen.add(hash);

        for (int i = 10; i < n; i++) {
            // roll: drop highest 2 bits of previous 10-letter window and add new char
            hash = ((hash << 2) & mask) | map[s.charAt(i)];
            if (!seen.add(hash)) {
                // substring corresponding to current window [i-9 .. i]
                repeats.add(s.substring(i - 9, i + 1));
            }
        }

        return new ArrayList<>(repeats);
    }
}
