// Last updated: 22/09/2025, 16:13:03
class Solution {
    public int numOfUnplacedFruits(int[] fruits, int[] baskets) {
        int n = fruits.length;
        boolean[] used = new boolean[n]; // tracks which baskets have been used
        int unplacedCount = 0;

        for (int i = 0; i < n; i++) {
            boolean placed = false;
            for (int j = 0; j < n; j++) {
                if (!used[j] && baskets[j] >= fruits[i]) {
                    used[j] = true;  // mark this basket as used
                    placed = true;   // fruit placed
                    break;
                }
            }
            if (!placed) {
                unplacedCount++;
            }
        }

        return unplacedCount;
    }
}
