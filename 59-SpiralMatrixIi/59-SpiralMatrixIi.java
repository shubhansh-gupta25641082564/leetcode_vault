// Last updated: 10/09/2025, 15:08:07
class Solution {
    public int[][] generateMatrix(int n) {
        int[][] matrix = new int[n][n];
        int top = 0, bottom = n - 1;
        int left = 0, right = n - 1;
        int num = 1;
        int max = n * n;
        
        while (num <= max) {
            // 1) Traverse from left to right along the top row
            for (int c = left; c <= right && num <= max; c++) {
                matrix[top][c] = num++;
            }
            top++;
            
            // 2) Traverse from top to bottom along the right column
            for (int r = top; r <= bottom && num <= max; r++) {
                matrix[r][right] = num++;
            }
            right--;
            
            // 3) Traverse from right to left along the bottom row
            for (int c = right; c >= left && num <= max; c--) {
                matrix[bottom][c] = num++;
            }
            bottom--;
            
            // 4) Traverse from bottom to top along the left column
            for (int r = bottom; r >= top && num <= max; r--) {
                matrix[r][left] = num++;
            }
            left++;
        }
        
        return matrix;
    }
}