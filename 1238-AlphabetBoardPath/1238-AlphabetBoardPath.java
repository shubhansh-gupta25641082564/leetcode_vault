// Last updated: 01/10/2025, 22:23:18
class Solution {
    public String alphabetBoardPath(String target) {
        int[][] pos = new int[26][2];
        for (int i = 0; i < 26; i++) {
            pos[i][0] = i / 5; // row
            pos[i][1] = i % 5; // column
        }

        StringBuilder sb = new StringBuilder();
        int r = 0, c = 0;

        for (char ch : target.toCharArray()) {
            int nr = pos[ch - 'a'][0];
            int nc = pos[ch - 'a'][1];

            // Special handling for 'z'
            if (ch == 'z') {
                // move horizontally first, then vertically
                if (nc < c) sb.append("L".repeat(c - nc));
                if (nr > r) sb.append("D".repeat(nr - r));
            } else {
                // move vertically first
                if (nr < r) sb.append("U".repeat(r - nr));
                if (nr > r) sb.append("D".repeat(nr - r));
                // then horizontally
                if (nc < c) sb.append("L".repeat(c - nc));
                if (nc > c) sb.append("R".repeat(nc - c));
            }

            sb.append('!');
            r = nr;
            c = nc;
        }

        return sb.toString();
    }
}
