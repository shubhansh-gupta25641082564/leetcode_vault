// Last updated: 10/09/2025, 15:08:18
class Solution {
    public double myPow(double x, int n) {
        // Handle the case of negative powers
        long N = n;
        if (N < 0) {
            x = 1 / x;
            N = -N;
        }
        
        double result = 1.0;
        double currentProduct = x;

        // Exponentiation by squaring
        while (N > 0) {
            if (N % 2 == 1) {
                result *= currentProduct; // Multiply current product if N is odd
            }
            currentProduct *= currentProduct; // Square the base
            N /= 2; // Reduce the power by half
        }

        return result;
    }
}