// Last updated: 10/09/2025, 15:08:17
class Solution {
    private int count;

    public int totalNQueens(int n) {
        count = 0;
        // Arrays to track attacks on columns and diagonals
        boolean[] columns = new boolean[n];
        boolean[] diagonal1 = new boolean[2 * n - 1]; // \ diagonals
        boolean[] diagonal2 = new boolean[2 * n - 1]; // / diagonals

        // Start the backtracking process
        backtrack(0, n, columns, diagonal1, diagonal2);
        return count;
    }

    private void backtrack(int row, int n, boolean[] columns, boolean[] diagonal1, boolean[] diagonal2) {
        if (row == n) {
            count++; // Found a valid solution
            return;
        }

        for (int col = 0; col < n; col++) {
            int d1 = row - col + n - 1; // \ diagonal index
            int d2 = row + col;         // / diagonal index

            // Check if placing a queen at (row, col) is valid
            if (columns[col] || diagonal1[d1] || diagonal2[d2]) {
                continue;
            }

            // Place the queen
            columns[col] = true;
            diagonal1[d1] = true;
            diagonal2[d2] = true;

            // Recurse to the next row
            backtrack(row + 1, n, columns, diagonal1, diagonal2);

            // Remove the queen (backtrack)
            columns[col] = false;
            diagonal1[d1] = false;
            diagonal2[d2] = false;
        }
    }
}