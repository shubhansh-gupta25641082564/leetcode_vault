// Last updated: 20/09/2025, 00:30:54
public class Spreadsheet {
    private final int rows;
    private final int[][] grid;

    public Spreadsheet(int rows) {
        this.rows = rows;
        this.grid = new int[rows][26];
    }

    public void setCell(String cell, int value) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        grid[row][col] = value;
    }

    public void resetCell(String cell) {
        int col = cell.charAt(0) - 'A';
        int row = Integer.parseInt(cell.substring(1)) - 1;
        grid[row][col] = 0;
    }

    public int getValue(String formula) {
        String expr = formula.substring(1);
        int plus = expr.indexOf('+');
        String left = expr.substring(0, plus);
        String right = expr.substring(plus + 1);
        return parseOperand(left) + parseOperand(right);
    }

    private int parseOperand(String s) {
        char c = s.charAt(0);
        if (c >= 'A' && c <= 'Z') {
            int col = c - 'A';
            int row = Integer.parseInt(s.substring(1)) - 1;
            return grid[row][col];
        } else {
            return Integer.parseInt(s);
        }
    }
}
