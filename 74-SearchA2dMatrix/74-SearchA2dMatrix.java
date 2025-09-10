// Last updated: 10/09/2025, 15:07:48
class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;        // number of rows
        int n = matrix[0].length;     // number of columns

        int low = 0;
        int high = m * n - 1;

        while (low <= high) {
            int mid = low + (high - low) / 2;
            int midValue = matrix[mid / n][mid % n]; // convert 1D index to 2D

            if (midValue == target) {
                return true;
            } else if (midValue < target) {
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return false; // target not found
    }
}