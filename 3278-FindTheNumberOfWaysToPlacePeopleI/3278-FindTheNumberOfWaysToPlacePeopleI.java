// Last updated: 10/09/2025, 15:07:24
class Solution {
    public int numberOfPairs(int[][] points) {
        int n = points.length;
        int ans = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (i == j) continue;
                int xi = points[i][0], yi = points[i][1];
                int xj = points[j][0], yj = points[j][1];
                if (xi <= xj && yi >= yj) {
                    boolean empty = true;
                    for (int k = 0; k < n; k++) {
                        if (k == i || k == j) continue;
                        int xk = points[k][0], yk = points[k][1];
                        if (xk >= xi && xk <= xj && yk >= yj && yk <= yi) {
                            empty = false;
                            break;
                        }
                    }
                    if (empty) ans++;
                }
            }
        }
        return ans;
    }
}
