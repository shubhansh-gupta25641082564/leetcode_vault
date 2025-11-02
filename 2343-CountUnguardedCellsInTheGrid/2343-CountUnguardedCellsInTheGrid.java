// Last updated: 02/11/2025, 23:39:53
import java.util.*;

class Solution {
    public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
        Set<Integer> guardSet = new HashSet<>();
        Set<Integer> wallSet = new HashSet<>();
        Set<Integer> guardedSet = new HashSet<>();

        // Register guards and walls positions
        for (int[] g : guards) {
            guardSet.add(encode(g[0], g[1], n));
        }
        for (int[] w : walls) {
            wallSet.add(encode(w[0], w[1], n));
        }
        
        // Four directions: [dr, dc]
        int[][] dirs = { {1,0}, {-1,0}, {0,1}, {0,-1} };
        
        for (int[] g : guards) {
            int gr = g[0], gc = g[1];
            for (int[] dir : dirs) {
                int nr = gr, nc = gc;
                while (true) {
                    nr += dir[0];
                    nc += dir[1];
                    if (nr < 0 || nr >= m || nc < 0 || nc >= n) break;
                    int key = encode(nr, nc, n);
                    if (wallSet.contains(key) || guardSet.contains(key)) break;
                    guardedSet.add(key);
                }
            }
        }

        int result = 0;
        for (int row = 0; row < m; ++row) {
            for (int col = 0; col < n; ++col) {
                int key = encode(row, col, n);
                if (guardSet.contains(key) || wallSet.contains(key)) continue; // Occupied
                if (!guardedSet.contains(key)) {
                    result++;
                }
            }
        }
        return result;
    }

    // Correct: Declare encode as a method in the class, not inside another method
    private int encode(int row, int col, int n) {
        return row * n + col;
    }
}
