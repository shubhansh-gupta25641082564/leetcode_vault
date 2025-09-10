// Last updated: 10/09/2025, 15:08:06
import java.util.ArrayList;

class Solution {
    public String getPermutation(int n, int k) {
        // List of numbers to pick from
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            numbers.add(i);
        }

        // Factorials for (n-1)!
        int[] factorial = new int[n];
        factorial[0] = 1;
        for (int i = 1; i < n; i++) {
            factorial[i] = factorial[i - 1] * i;
        }

        // Convert k to 0-based index
        k--;

        // Build the kth permutation
        StringBuilder result = new StringBuilder();
        for (int i = n; i > 0; i--) {
            int index = k / factorial[i - 1];
            result.append(numbers.get(index));
            numbers.remove(index);
            k %= factorial[i - 1];
        }

        return result.toString();
    }
}