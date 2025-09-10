// Last updated: 10/09/2025, 15:07:23
class Solution {
    public int areaOfMaxDiagonal(int[][] dimensions) {
        if (dimensions == null || dimensions.length == 0) return 0;
        long best = -1;
        long area = 0;
        for (int[] d : dimensions) {
            if (d == null || d.length < 2) continue;
            long w = d[0];
            long h = d[1];
            long diagSq = w * w + h * h;
            long a = w * h;
            if (diagSq > best || (diagSq == best && a > area)) {
                best = diagSq;
                area = a;
            }
        }
        return (int) area;
    }
}
