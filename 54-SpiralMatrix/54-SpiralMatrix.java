// Last updated: 10/09/2025, 15:08:14
import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        
        int top = 0;
        int bottom = matrix.length - 1;
        int left = 0;
        int right = matrix[0].length - 1;
        
        while (top <= bottom && left <= right) {
            // Traverse from left to right along the top row.
            for (int j = left; j <= right; j++) {
                result.add(matrix[top][j]);
            }
            top++; // move the top boundary down
            
            // Traverse from top to bottom along the right column.
            for (int i = top; i <= bottom; i++) {
                result.add(matrix[i][right]);
            }
            right--; // move the right boundary left
            
            // Ensure that we now have a valid row remaining.
            if (top <= bottom) {
                // Traverse from right to left along the bottom row.
                for (int j = right; j >= left; j--) {
                    result.add(matrix[bottom][j]);
                }
                bottom--; // move the bottom boundary up
            }
            
            // Ensure that we now have a valid column remaining.
            if (left <= right) {
                // Traverse from bottom to top along the left column.
                for (int i = bottom; i >= top; i--) {
                    result.add(matrix[i][left]);
                }
                left++; // move the left boundary right
            }
        }
        
        return result;
    }
}