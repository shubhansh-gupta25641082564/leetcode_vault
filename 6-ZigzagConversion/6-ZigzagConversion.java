// Last updated: 10/09/2025, 15:09:11
class Solution {
    public String convert(String s, int numRows) {
        int n = s.length();
        if (numRows == 1 || numRows >= n) {
            return s;
        }
        
        // Prepare StringBuilder for each row
        StringBuilder[] rows = new StringBuilder[numRows];
        for (int i = 0; i < numRows; i++) {
            rows[i] = new StringBuilder();
        }
        
        int curRow = 0;
        boolean goingDown = false;
        
        // Build the zigzag pattern
        for (char c : s.toCharArray()) {
            rows[curRow].append(c);
            // Flip direction at top or bottom
            if (curRow == 0 || curRow == numRows - 1) {
                goingDown = !goingDown;
            }
            curRow += goingDown ? 1 : -1;
        }
        
        // Concatenate all rows
        StringBuilder result = new StringBuilder();
        for (StringBuilder rowSb : rows) {
            result.append(rowSb);
        }
        return result.toString();
    }
}